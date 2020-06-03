package assignment02;

public class PriceList {
	private Oil[][] pricelist; // 오브젝트를 저장할 클래스 타입 이중 배열
	private int vertical; // 배열의 세로 길이

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

		// 가솔린인 경우(Gasoline)
		if (a.getName().contentEquals("assignment02.Gasoline")) {
			this.pricelist[i][j] = new Gasoline(oil);
		}
		// 디젤인 경우(Diesel)
		else if (a.getName().equals("assignment02.Diesel")) {
			this.pricelist[i][j] = new Diesel(oil);
		}
		this.pricelist[i][j].setConsumerPrice(); // 소비자 가격 계산
	}

	public void extendList(int amount) {
		this.vertical += amount;
		Oil[][] tmp = new Oil[vertical][2];

		// 칸을 늘린 후 기존의 내용을 복사
		for (int i = 0; i < pricelist.length; i++) {
			for (int j = 0; j < pricelist[i].length; j++) {
				if (j == 0)
					tmp[i][j] = new Gasoline(pricelist[i][j]);
				else if (j == 1)
					tmp[i][j] = new Diesel(pricelist[i][j]);
				// 기존의 소비자 가격 복사
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
