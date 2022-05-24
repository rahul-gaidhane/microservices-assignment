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
	public FundTranserResponse transfer(FundTransferRequest request) throws JsonProcessingException {
		LOGGER.debug("Service to transfer fund : {}", request);
		
		String srcCurr = "USD";
		String destCurr = "INR";
		
		ForexRequest forexReq = new ForexRequest(srcCurr, destCurr, request.getAmount()); 
		ForexResponse forexRes = null;
		try {
			forexRes = forexClient.getForexAmount(forexReq);
		} catch (RestClientException | URISyntaxException e) {
			LOGGER.error("Error Occured while making api call to forex service");
			//TODO: print stack trace
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
		
		return null;
	}

}
