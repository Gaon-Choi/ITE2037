package assignment03;

public class Region extends Thread {

	private String regionName; // The name of the region
	private int regionNum; // The number of the region
	private int population; // The population of the region
	private Candidate[] candidates; // An array of the candidates of the election
	private int num = 0;

	// Constructor of Region
	public Region(String regionName, int regionNum, int population, Candidate[] candidates) {
		this.regionName = regionName;
		this.regionNum = regionNum;
		this.population = population;
		this.candidates = new Candidate[candidates.length];		// Candidate Array: candidates 생성
		for(int i = 0; i < candidates.length; i++)
			this.candidates[i] = candidates[i];
	}

	// accessor of regionName
	public String getRegionName() {
		return this.regionName;
	}

	// accessor of regionNum
	public int getRegionNum() {
		return this.regionNum;
	}

	public void generateVotes() throws InterruptedException {
		int num = (int) (Math.random() * candidates.length);	// 투표할 후보 랜덤 선택
		this.candidates[num].callAddVotes(getRegionNum());		// 선택된 후보에 투표하기 위해 callAddVotes 메소드 호출
	}

	public void run() {
		try {
			for (int i = 0; i < this.population; i++)
				generateVotes();
		} catch (InterruptedException e) {
			e.getStackTrace();
		}
	}
}
