package in.example.debit;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = Account.COLLECTION_NAME)
public class Account {
	
	public static final String COLLECTION_NAME = "account";
	
	public static final class Columns {
		private static final String ACCOUNT_NUMBER = "accountNumber";
		private static final String AMOUNT = "amount";
	}

	@Id
	private String id;
	
	@Field(name = Columns.ACCOUNT_NUMBER)
	private String accountNumber;
	
	@Field(name = Columns.AMOUNT)
	private double amount;

	public String getId() {
		return id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void credit(Double amount) {
		this.amount = this.amount + amount;
	}
	
	public void debit(Double amount) {
		this.amount = this.amount - amount;
	}	
}

