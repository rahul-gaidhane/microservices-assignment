package in.example.credit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CreditListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CreditListener.class);
	
	@Autowired
	private AccountService accountService;
	
	@KafkaListener(topics = "kafka-credit", groupId = "archived")
	public void handleCredit(@Payload String message) throws JsonMappingException, JsonProcessingException {
		
		LOGGER.debug("Message Recieved by credit service : {}", message);
		
		ObjectMapper objMap = new ObjectMapper();
		
		AccountOperation creditOper = objMap.readValue(message, AccountOperation.class);
		
		accountService.creditAmount(creditOper.getAccountNumber(), creditOper.getAmount());
	}
}
