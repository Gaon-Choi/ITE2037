package assignment02;

public class PriceList {
	private Oil[][] pricelist; // ������Ʈ�� ������ Ŭ���� Ÿ�� ���� �迭
	private int vertical; // �迭�� ���� ����

	private int size;

	// PriceList Constructor
	public PriceList() {
		this.size = 0;
		this.vertical = 2;
		this.pricelist = new Oil[this.vertical][2];
	}

	// accessor of size
	public int getSize() {
		return this.size;
	}

	// increase size by 1
	public void inc_size() {
		this.size++;
	}

	// accessor of vertical
	public int getVertical() {
		return this.vertical;
	}

	public void setPricelist(int i, int j, Oil oil) {
		Class a = oil.getClass();

		// ���ָ��� ���(Gasoline)
		if (a.getName().contentEquals("assignment02.Gasoline")) {
			this.pricelist[i][j] = new Gasoline(oil);
		}
		// ������ ���(Diesel)
		else if (a.getName().equals("assignment02.Diesel")) {
			this.pricelist[i][j] = new Diesel(oil);
		}
		this.pricelist[i][j].setConsumerPrice(); // �Һ��� ���� ���
	}

	public void extendList(int amount) {
		this.vertical += amount;
		Oil[][] tmp = new Oil[vertical][2];

		// ĭ�� �ø� �� ������ ������ ����
		for (int i = 0; i < pricelist.length; i++) {
			for (int j = 0; j < pricelist[i].length; j++) {
				if (j == 0)
					tmp[i][j] = new Gasoline(pricelist[i][j]);
				else if (j == 1)
					tmp[i][j] = new Diesel(pricelist[i][j]);
				// ������ �Һ��� ���� ����
				tmp[i][j].setConsumerPrice();
			}
		}
		
		this.pricelist = tmp;
	}

	public String getRegionInfo(int i) {
		/* the region number starts from 1. */
		String str = "";
		str += this.pricelist[i - 1][0].toString(); // print info of Gasoline
		str += "\n";
		str += this.pricelist[i - 1][1].toString(); // print info of Diesel

		return str;
	}

	public void printList() {
		int i;
		System.out.println("                  Gasoline         Diesel        ");
		System.out.println("=================================================");
		for (i = 0; i < this.getSize(); i++) {
			System.out.printf("Region #%d        %8.2f         %8.2f \n\n", i + 1,
					this.pricelist[i][0].getConsumerPrice(), this.pricelist[i][1].getConsumerPrice());
		}
	}
}
