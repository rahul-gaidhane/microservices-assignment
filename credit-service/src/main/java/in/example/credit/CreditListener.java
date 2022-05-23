package in.example.credit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CreditListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CreditListener.class);
	
	@KafkaListener(topics = "kafka-credit", groupId = "archived")
	public void handleCredit(String message) {
		
		LOGGER.debug("Message Recieved by credit service : {}", message);
	}
}
