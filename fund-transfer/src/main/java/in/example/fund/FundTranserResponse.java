package in.example.fund;

public class FundTranserResponse {
	
	private Double debitedAmount;
	
	private Double creditedAmount;
	
	private String message;
	
	public FundTranserResponse(Double debitedAmount, Double creditedAmount, String message) {
		this.debitedAmount = debitedAmount;
		this.creditedAmount = creditedAmount;
		this.message = message;
	}
	
	public Double getDebitedAmount() {
		return debitedAmount;
	}

	public void setDebitedAmount(Double debitedAmount) {
		this.debitedAmount = debitedAmount;
	}

	public Double getCreditedAmount() {
		return creditedAmount;
	}

	public void setCreditedAmount(Double creditedAmount) {
		this.creditedAmount = creditedAmount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "FundTranserResponse [debitedAmount=" + debitedAmount + ", creditedAmount=" + creditedAmount
				+ ", message=" + message + "]";
	}
}
