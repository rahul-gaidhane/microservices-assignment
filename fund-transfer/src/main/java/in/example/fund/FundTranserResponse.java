package in.example.fund;

public class FundTranserResponse {
	
	private Double amount;
	
	private String message;

	public FundTranserResponse(Double amount, String message) {
		this.amount = amount;
		this.message = message;
	}
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "FundTranserResponse [amount=" + amount + ", message=" + message + "]";
	}
}
