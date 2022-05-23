package in.example.rate;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl implements RateService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RateServiceImpl.class);
	
	@Autowired
	private Map<String, Double> rates;
	
	@Override
	public ForexResponse getForex(ForexRequest request) {
		LOGGER.debug("Service to get forex : {}", request);
		
		//creating key
		String key = request.getSrcCur() + "_" + request.getDestCur();
		
		ForexResponse response = new ForexResponse();
		
		if(rates.containsKey(key)) {
			
			Double forexRate = rates.get(key);
			
			response = new ForexResponse();
			response.setAmount(request.getAmount() * forexRate);
			
		} else {
			//TODO: We will look into that later
		}
		
		return response;
	}
}
