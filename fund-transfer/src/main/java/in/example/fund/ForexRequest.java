package in.example.fund;

public class ForexRequest {
	
	private String srcCur;
	
	private String destCur;
	
	private Double amount;
	
	public ForexRequest(String srcCur, String destCur, Double amount) {
		this.srcCur = srcCur;
		this.destCur = destCur;
		this.amount = amount;
	}

	public String getSrcCur() {
		return srcCur;
	}

	public void setSrcCur(String srcCur) {
		this.srcCur = srcCur;
	}

	public String getDestCur() {
		return destCur;
	}

	public void setDestCur(String destCur) {
		this.destCur = destCur;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ForexRequest [srcCur=" + srcCur + ", destCur=" + destCur + ", amount=" + amount + "]";
	}
}
