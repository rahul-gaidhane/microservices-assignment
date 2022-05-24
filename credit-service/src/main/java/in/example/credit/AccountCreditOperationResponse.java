package in.example.credit;

public class AccountCreditOperationResponse {
	
	private String accountNumber;
	
	private String message;
	
	public AccountCreditOperationResponse(String accNum, Double amount) {
		this.accountNumber = accNum;
		this.message = "The amount of " + amount + " credited into account successfully";
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
