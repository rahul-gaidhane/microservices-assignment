package in.example.credit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class AccountServiceImplTest {
	
	@MockBean
	private AccountRepository accountRepository;
	
	private AccountServiceImpl accountService;
	
	@BeforeEach
	public void setup() {
		accountService = new AccountServiceImpl(accountRepository);
	}
	
	@Test
	public void testCreditAmountMethod() {
		
		Account acc = new Account();
		acc.setAccountNumber("102");
		acc.credit(50d);
		
		when(accountRepository.findByAccountNumber(Mockito.anyString())).thenReturn(Optional.of(acc));
		
		Double creditAmt = 10d;
		AccountCreditOperationResponse response = accountService.creditAmount(acc.getAccountNumber(), creditAmt);
		
		assertEquals(acc.getAccountNumber(), response.getAccountNumber());
		assertNotNull(response.getMessage());
		assertTrue(response.getMessage().contains(creditAmt.toString()));
	}
}
