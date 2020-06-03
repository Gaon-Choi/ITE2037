package assignment02;

public class Gasoline extends Oil {
	private int price; // ���ް�
	private double VAT; // �ΰ���ġ����

	// Gasoline Constructor
	public Gasoline(int price, String company) {
		super(company, "gasoline");	// super ������ ȣ��
		this.price = price;
		int dValue = (int) (Math.random() * 30);
		this.VAT = (double) (dValue + 1) / 100;
	}

	// Copy Constructor
	public Gasoline(Oil oil) {
		super(oil);	// super ������ ȣ��
		Gasoline g = (Gasoline) oil; // Oil --> Gasoline (downcasting)
		this.price = g.price;
		this.VAT = g.VAT;
	}

	@Override
	public double getOilPrice() {
		// �ֹ��� ���� = ���ް� +���ް� * �ΰ���ġ����
		return this.price * (1 + this.VAT);
	}

	public String toString() {
		String info = super.toString();
		info += String.format("\nsupply price: %s", this.price);
		return info;
	}
}
