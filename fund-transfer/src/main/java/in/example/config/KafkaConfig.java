package in.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin.NewTopics;

@Configuration
public class KafkaConfig {
	
	@Bean
	public NewTopics topic() {
		return new NewTopics(new NewTopic("kafka-credit", 1, (short)1), new NewTopic("kafka-debit", 1, (short)1));
	}
}
