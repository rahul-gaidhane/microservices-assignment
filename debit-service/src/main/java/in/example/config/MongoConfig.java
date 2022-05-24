package in.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {
	
	@Bean
    public MongoDatabaseFactory mongoDatabaseFactory() {

        return new SimpleMongoClientDatabaseFactory("mongodb://localhost:27011/virtusa");
    }
}
