package in.example.deposit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DepositListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DepositListener.class);
	
	@KafkaListener(topics = "kafka1", groupId = "archived")
	public void consume(String message) {
		LOGGER.debug("Message Recieved by deposit service : {}", message);
	}
}
