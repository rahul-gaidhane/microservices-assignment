package in.example.rate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/forex")
public class RateController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RateController.class);
	
	@Autowired
	private RateService rateService;
	
	/**
	 * Get the Forex amount for the given current type
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping
	public ResponseEntity<ForexResponse> getForex(@RequestBody ForexRequest request) {
		LOGGER.debug("Request to get forex : {}", request);
		
		ForexResponse response = rateService.getForex(request);
		
		return new ResponseEntity<ForexResponse>(response, HttpStatus.OK);
	}
}
