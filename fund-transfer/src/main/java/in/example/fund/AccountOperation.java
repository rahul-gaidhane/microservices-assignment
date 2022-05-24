package in.example.fund;

public class AccountOperation {
	
	private String accountNumber;
	
	private Double amount;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "AccountOperation [accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}
}
