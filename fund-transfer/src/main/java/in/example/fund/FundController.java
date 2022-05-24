package in.example.fund;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api/funds")
public class FundController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FundController.class);
	
	@Autowired
	private FundService fundService;
	
	@PutMapping("/transfer")
	public ResponseEntity<FundTranserResponse> transfer(@RequestBody FundTransferRequest request) throws JsonProcessingException {
		LOGGER.debug("Request to transfer fund : {}", request);
		
		FundTranserResponse response = fundService.transfer(request);
		
		return new ResponseEntity<FundTranserResponse>(response, HttpStatus.OK);
	}
}
