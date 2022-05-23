package in.example.debit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DebitListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DebitListener.class);
	
	@KafkaListener(topics = "kafka-debit", groupId = "archived")
	public void handleDebit(String message) {
		
		LOGGER.debug("Message Recieved to debit amount : {}", message);
	}
}
