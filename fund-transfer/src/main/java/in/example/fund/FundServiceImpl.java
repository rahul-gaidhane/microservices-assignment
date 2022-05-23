package in.example.fund;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
public class FundServiceImpl implements FundService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FundServiceImpl.class);
	
	@Autowired
	private ForexClient forexClient;
	
	@Override
	public FundTranserResponse transfer(FundTransferRequest request) {
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
		
		LOGGER.debug("Forex Response : {}", forexRes);
		
		return null;
	}

}
