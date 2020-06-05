package assignment03;

public class Candidate implements Comparable {

	private String name;	// 후보자의 이름
	private int numVotes;	// 후보자가 받은 투표 수
	private Vote[] votes;	// 후보자가 받은 표의 배열
	private int maxVotes;

	public Candidate(String name, int maxVotes) {
		this.name = name;
		this.votes = new Vote[maxVotes];
		this.numVotes = 0;
		// maxVotes: 후보자가 받을 수 있는 최대 득표 수
		this.maxVotes = maxVotes;
	}

	// Copy Constructor
	public Candidate(Candidate obj) {
		this.name = obj.getName();
		this.maxVotes = obj.getMaxVotes();
		this.votes = new Vote[obj.getMaxVotes()];
		this.numVotes = obj.getNumVotes();

		for (int i = 0; i < this.numVotes; i++) {
			this.votes[i] = new Vote(obj.votes[i].getRegionNum());
		}
	}

	public String getName() {
		return this.name;
	}

	public int getNumVotes() {
		return this.numVotes;
	}

	public void incre_num() {
		this.numVotes++;
	}

	public int getMaxVotes() {
		return this.maxVotes;
	}

	public String toString() {
		return "------------Candidate------------\n" 
				+ "Name: " + this.name + "\n" 
				+ "Total Votes: " + this.numVotes;
	}

	public int toRegionString(int regionNum) {
		int count = 0;
		for (int i = 0; i < this.numVotes; i++) {
			if (this.votes[i].getRegionNum() == regionNum)
				count++;
		}
		return count;
	}

	public void callAddVotes(int regionNum) {
		this.votes[this.numVotes] = new Vote(0);
		this.votes[this.numVotes].addVote(regionNum);
	}

	@Override
	public int compareTo(Object obj) {
		if (obj == null) {
			throw new NullPointerException("Object is null.");
		}
		else if (!this.getClass().equals(obj.getClass())) {
			throw new ClassCastException("Object not of the same type.");
		}
		else {
			Candidate toCompare = (Candidate) obj;
			return this.numVotes - toCompare.numVotes;
		}
	}

	private class Vote {
		// 후보자가 투표를 받을 때마다 votes 배열을 늘려준다.
		private int regionNum; // 지역 번호

		public Vote(int regionNum) {
			this.regionNum = regionNum;
		}

		public int getRegionNum() {
			return this.regionNum;
		}

		public Vote(Vote vote) {
			this.regionNum = vote.regionNum;
		}

		public synchronized void addVote(int regionNum) {
			// 여러 스레드가 동시에 특정 자원에 접근 --> 동기화 필요 --> synchronized
			Vote v = new Vote(regionNum);
			votes[numVotes++] = new Vote(v);
			notifyAll();
		}
	}
}
