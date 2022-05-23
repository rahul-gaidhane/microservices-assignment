package in.example.fund;

public class FundTransferRequest {
	
	private String srcAccount;
	
	private String destAccount;
	
	private Double amount;
	
	public FundTransferRequest(String srcAccount, String destAccount, Double amount) {
		this.srcAccount = srcAccount;
		this.destAccount = destAccount;
		this.amount = amount;
	}

	public String getSrcAccount() {
		return srcAccount;
	}

	public void setSrcAccount(String srcAccount) {
		this.srcAccount = srcAccount;
	}

	public String getDestAccount() {
		return destAccount;
	}

	public void setDestAccount(String destAccount) {
		this.destAccount = destAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "FundTransferRequest [srcAccount=" + srcAccount + ", destAccount=" + destAccount + ", amount=" + amount
				+ "]";
	}
}
