package in.example.fund;

public class ForexResponse {
	
	private Double amount;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ForexResponse [amount=" + amount + "]";
	}
}
