package assignment02;

public class Diesel extends Oil {
	private int price; // ���ް�
	private double VAT; // �ΰ���ġ����
	private double envTax; // ȯ�漼

	// Diesel Constructor
	public Diesel(int price, String company) {
		super(company, "diesel");	// super ������ ȣ��
		this.price = price;
		int dValue = (int) (Math.random() * 30);
		this.VAT = (double) (dValue + 1) / 100;
		this.envTax = 500;
	}

	// Copy Constructor
	public Diesel(Oil oil) {
		super(oil);	// super ������ ȣ��(Oil::Oil(Oil oil --> copy constructor)
		Diesel d = (Diesel) oil; // Oil --> Diesel (downcasting)
		this.price = d.price;
		this.VAT = d.VAT;
		this.envTax = d.envTax;
	}

	@Override
	public double getOilPrice() {
		// ���� ���� = ���ް� + ȯ�漼 + ���ް� * �ΰ���ġ����
		return this.price + this.envTax + this.price * this.VAT;
	}

	public String toString() {
		String info = super.toString();
		info += String.format("\nsupply price: %s", this.price);
		return info;
	}
}
