package assignment02;

public class Diesel extends Oil {
	private int price; // 공급가
	private double VAT; // 부가가치세율
	private double envTax; // 환경세

	// Diesel Constructor
	public Diesel(int price, String company) {
		super(company, "diesel");	// super 생성자 호출
		this.price = price;
		int dValue = (int) (Math.random() * 30);
		this.VAT = (double) (dValue + 1) / 100;
		this.envTax = 500;
	}

	// Copy Constructor
	public Diesel(Oil oil) {
		super(oil);	// super 생성자 호출(Oil::Oil(Oil oil --> copy constructor)
		Diesel d = (Diesel) oil; // Oil --> Diesel (downcasting)
		this.price = d.price;
		this.VAT = d.VAT;
		this.envTax = d.envTax;
	}

	@Override
	public double getOilPrice() {
		// 경유 가격 = 공급가 + 환경세 + 공급가 * 부가가치세율
		return this.price + this.envTax + this.price * this.VAT;
	}

	public String toString() {
		String info = super.toString();
		info += String.format("\nsupply price: %s", this.price);
		return info;
	}
}
