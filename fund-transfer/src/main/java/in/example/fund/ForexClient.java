package in.example.fund;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ForexClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ForexClient.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ForexResponse getForexAmount(ForexRequest forexReq) throws RestClientException, URISyntaxException {
		
		LOGGER.debug("Service to get forex amount : {}", forexReq);
		
		ForexResponse response = restTemplate.postForObject(new URI("http://forex-service/api/forex"), forexReq, ForexResponse.class);
		
		return response;
	}
}
