package in.example.debit;

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
public class DebitListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DebitListener.class);
	
	@Autowired
	private AccountService accountService;

	@KafkaListener(topics = "kafka-debit", groupId = "archived")
	public void handleDebit(@Payload String message) throws JsonMappingException, JsonProcessingException {
		
		LOGGER.debug("Message Recieved to debit amount : {}", message);
		
		ObjectMapper objMap = new ObjectMapper();
		
		AccountDebitOperationRequest debitOper = objMap.readValue(message, AccountDebitOperationRequest.class);
		
		accountService.debitAmount(debitOper.getAccountNumber(), debitOper.getAmount());
	}
}
