package in.example.debit;

public class AccountDebitOperationResponse {
	
	private String accountNumber;
	
	private String message;

	public AccountDebitOperationResponse(String accountNumber, Double amount) {
		this.accountNumber = accountNumber;
		this.message = "The amount of " + amount + " debited from account successfully";
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
