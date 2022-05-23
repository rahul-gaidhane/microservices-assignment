package in.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class ForexServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForexServiceApplication.class, args);
	}
	
	@Bean
	public Map<String, Double> getRates() {
		
		Map<String, Double> rates = new HashMap<>();
		rates.put("USD_INR", 72.54);
		rates.put("JPY_INR", 1.54);
		rates.put("EUR_INR", 94.54);
		rates.put("SIG_INR", 50.54);
		rates.put("AUD_INR", 44.54);
		
		return rates;
	}
}
