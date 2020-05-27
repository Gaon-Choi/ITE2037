package assignment01;

public class Lecture
{
	private String day; // ���� ����
	private int time; // ���� �ð�
	private String lectureName; // ���� �̸�
	private String professor; // ���� �̸�
	private String roomNumber; // ���� ���
	private int Enrolled; // ���Ǹ� �������� �л� ��
	private int maxEnrolled; // ���� ����

	public Lecture()
	{
		this.lectureName = "----";
		this.professor = "None";
		this.roomNumber = "None";
	}

	public Lecture(String day, int time, String lectureName, String professor, String roomNumber, int maxEnrolled)
	{
		this.day = day;
		this.time = time;
		this.lectureName = lectureName;
		this.professor = professor;
		this.roomNumber = roomNumber;
		this.maxEnrolled = maxEnrolled;
		this.Enrolled = 0;	// Enrolled�� ���� 0���� �ʱ�ȭ
	}
	
	/* �� �����鿡 ���� accessor, mutator �޼ҵ� ���� */
	// day�� accessor
	public String getDay()
	{
		return this.day;
	}

	// day�� mutator
	public void setDay(String day)
	{
		this.day = day;
	}

	// time�� accessor
	public int getTime()
	{
		return this.time;
	}

	// time�� mutator
	public void setTime(int time)
	{
		this.time = time;
	}

	// lectureName�� accessor
	public String getLectureName()
	{
		return this.lectureName;
	}

	// lectureName�� mutator
	public void setLectureName(String lectureName)
	{
		this.lectureName = lectureName;
	}

	// professor�� accessor
	public String getProfessor()
	{
		return this.professor;
	}

	// professor�� mutator
	public void setProfessor(String professor)
	{
		this.professor = professor;
	}

	// roomNumber�� accessor
	public String getRoomNumber()
	{
		return this.roomNumber;
	}

	// roomNumber�� mutator
	public void setRoomNumber(String roomNumber)
	{
		this.roomNumber = roomNumber;
	}

	// maxEnrolled�� accessor
	public int getMaxEnrolled()
	{
		return this.maxEnrolled;
	}

	// maxEnrolled�� mutator
	public void setMaxEnrolled(int maxEnrolled)
	{
		this.maxEnrolled = maxEnrolled;
	}

	// Enrolled�� accessor
	public int getEnrolled()
	{
		return this.Enrolled;
	}
	
	// Enrolled�� 1��ŭ ������Ű�� �޼ҵ�
	public void incEnrolled()
	{
		this.Enrolled++;
	}

	// Enrolled�� 1��ŭ ���ҽ�Ű�� �޼ҵ�
	public void decEnrolled()
	{
		this.Enrolled--;
	}

	public boolean equals(Lecture s)
	{
		if (s == null)
			return false;
		else
		{
			// ���� �������� Ȯ���Ѵ�.
			boolean b1 = (this.lectureName).equals(s.lectureName);	// lectureName ��
			boolean b2 = (this.professor).equals(s.professor);		// professor ��
			boolean b3 = (this.roomNumber).equals(s.roomNumber);	// roomNumber ��
			return b1 && b2 && b3;	// �� ��ΰ� ���ƾ� �ϹǷ� AND �������� ����.
		}
	}

	public boolean checkLecture()
	{
		// ���Ǹ� �߰��� �� �ִ��� Ȯ���ϴ� �޼ҵ�
		return this.lectureName.equals("----");
	}

}