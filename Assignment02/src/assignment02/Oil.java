package assignment02;

public abstract class Oil {
	private String company; // 공급 회사
	private String oilType; // 기름 종류
	private double consumerPrice; // 소비자 가격

	// Oil Constructor
	public Oil(String company, String oilType) {
		this.company = company;
		this.oilType = oilType;
		this.consumerPrice = 0;
	}

	// Copy Constructor
	public Oil(Oil oil) {
		this(oil.company, oil.oilType);
	}

	// accessor method of consumerPrice
	public double getConsumerPrice() {
		return this.consumerPrice;
	}

	// mutator method of consumerPrice
	public void setConsumerPrice() {
		this.consumerPrice = getOilPrice();
	}

	public String toString() {
		String info = String.format("company: %s\noil type: %s", this.company, this.oilType);
		return info;
	}

	// abstract method --> Class Oil is abstract class.
	public abstract double getOilPrice();
}
