package in.example.credit;

public interface AccountService {
	
	AccountCreditOperationResponse creditAmount(String accNum, Double amount);
}
