package assignment03;

public class Candidate implements Comparable {

	private String name;	// �ĺ����� �̸�
	private int numVotes;	// �ĺ��ڰ� ���� ��ǥ ��
	private Vote[] votes;	// �ĺ��ڰ� ���� ǥ�� �迭
	private int maxVotes;

	public Candidate(String name, int maxVotes) {
		this.name = name;
		this.votes = new Vote[maxVotes];
		this.numVotes = 0;
		// maxVotes: �ĺ��ڰ� ���� �� �ִ� �ִ� ��ǥ ��
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
		// �ĺ��ڰ� ��ǥ�� ���� ������ votes �迭�� �÷��ش�.
		private int regionNum; // ���� ��ȣ

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
			// ���� �����尡 ���ÿ� Ư�� �ڿ��� ���� --> ����ȭ �ʿ� --> synchronized
			Vote v = new Vote(regionNum);
			votes[numVotes++] = new Vote(v);
			notifyAll();
		}
	}
}
