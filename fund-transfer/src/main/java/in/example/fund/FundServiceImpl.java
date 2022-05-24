package in.example.fund;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FundServiceImpl implements FundService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FundServiceImpl.class);
	
	@Autowired
	private ForexClient forexClient;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Override
	@io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "fallbackService", fallbackMethod = "fallbackTransfer")
	public FundTranserResponse transfer(FundTransferRequest request) throws JsonProcessingException {
		LOGGER.debug("Service to transfer fund : {}", request);
		
		String srcCurr = "USD";
		String destCurr = "INR";
		
		ForexRequest forexReq = new ForexRequest(srcCurr, destCurr, request.getAmount()); 
		ForexResponse forexRes = null;
		
		try {
			forexRes = forexClient.getForexAmount(forexReq);
		} catch (RestClientException | URISyntaxException e) {
			LOGGER.debug("Error Occured while getting Forex info");
			//TODO: Print message
		}
		
		ObjectMapper objMap = new ObjectMapper();
		
		LOGGER.debug("Forex Response : {}", forexRes);
		
		AccountOperation debitOper = new AccountOperation();
		debitOper.setAccountNumber(request.getSrcAccount());
		debitOper.setAmount(request.getAmount());
		
		kafkaTemplate.send("kafka-debit", objMap.writeValueAsString(debitOper));
		
		AccountOperation creditOper = new AccountOperation();
		creditOper.setAccountNumber(request.getDestAccount());
		creditOper.setAmount(forexRes.getAmount());
		
		kafkaTemplate.send("kafka-credit", objMap.writeValueAsString(creditOper));
		
		return new FundTranserResponse(request.getAmount(), forexRes.getAmount(), "Fund Transfered Successfully");
	}
	
	public FundTranserResponse fallbackTransfer(Exception ex) {
		return new FundTranserResponse(0d, 0d, "Fund Transfer Failed");
	}

}
