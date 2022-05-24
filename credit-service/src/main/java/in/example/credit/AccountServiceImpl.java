package in.example.credit;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	private AccountRepository accountRepository;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountCreditOperationResponse creditAmount(String accNum, Double amount) {
		LOGGER.debug("Service to credit amount to an account : {}, {}", accNum, amount);
		
		Optional<Account> foundAccount = accountRepository.findByAccountNumber(accNum);
		
		if(foundAccount.isPresent()) {
			
			Account acc = foundAccount.get();
			
			acc.credit(amount);
			
			accountRepository.save(acc);
			
		} else {
			//TODO: We will handle it later
		}
		
		return new AccountCreditOperationResponse(accNum, amount);
	}

}
