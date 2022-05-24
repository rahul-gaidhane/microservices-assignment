package in.example.debit;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

	Optional<Account> findByAccountNumber(String accNum);
}
