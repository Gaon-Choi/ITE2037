package assignment02;

public class Gasoline extends Oil {
	private int price; // 공급가
	private double VAT; // 부가가치세율

	// Gasoline Constructor
	public Gasoline(int price, String company) {
		super(company, "gasoline");	// super 생성자 호출
		this.price = price;
		int dValue = (int) (Math.random() * 30);
		this.VAT = (double) (dValue + 1) / 100;
	}

	// Copy Constructor
	public Gasoline(Oil oil) {
		super(oil);	// super 생성자 호출
		Gasoline g = (Gasoline) oil; // Oil --> Gasoline (downcasting)
		this.price = g.price;
		this.VAT = g.VAT;
	}

	@Override
	public double getOilPrice() {
		// 휘발유 가격 = 공급가 +공급가 * 부가가치세율
		return this.price * (1 + this.VAT);
	}

	public String toString() {
		String info = super.toString();
		info += String.format("\nsupply price: %s", this.price);
		return info;
	}
}
