package in.example.debit;

public interface AccountService {
	
	AccountDebitOperationResponse debitAmount(String accNum, Double amount);
}
