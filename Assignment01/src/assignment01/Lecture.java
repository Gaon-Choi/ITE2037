package assignment01;

public class Lecture
{
	private String day; // 강의 요일
	private int time; // 강의 시간
	private String lectureName; // 강의 이름
	private String professor; // 교수 이름
	private String roomNumber; // 강의 장소
	private int Enrolled; // 강의를 수강중인 학생 수
	private int maxEnrolled; // 수강 정원

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
		this.Enrolled = 0;	// Enrolled의 값은 0으로 초기화
	}
	
	/* 각 변수들에 대한 accessor, mutator 메소드 선언 */
	// day의 accessor
	public String getDay()
	{
		return this.day;
	}

	// day의 mutator
	public void setDay(String day)
	{
		this.day = day;
	}

	// time의 accessor
	public int getTime()
	{
		return this.time;
	}

	// time의 mutator
	public void setTime(int time)
	{
		this.time = time;
	}

	// lectureName의 accessor
	public String getLectureName()
	{
		return this.lectureName;
	}

	// lectureName의 mutator
	public void setLectureName(String lectureName)
	{
		this.lectureName = lectureName;
	}

	// professor의 accessor
	public String getProfessor()
	{
		return this.professor;
	}

	// professor의 mutator
	public void setProfessor(String professor)
	{
		this.professor = professor;
	}

	// roomNumber의 accessor
	public String getRoomNumber()
	{
		return this.roomNumber;
	}

	// roomNumber의 mutator
	public void setRoomNumber(String roomNumber)
	{
		this.roomNumber = roomNumber;
	}

	// maxEnrolled의 accessor
	public int getMaxEnrolled()
	{
		return this.maxEnrolled;
	}

	// maxEnrolled의 mutator
	public void setMaxEnrolled(int maxEnrolled)
	{
		this.maxEnrolled = maxEnrolled;
	}

	// Enrolled의 accessor
	public int getEnrolled()
	{
		return this.Enrolled;
	}
	
	// Enrolled를 1만큼 증가시키는 메소드
	public void incEnrolled()
	{
		this.Enrolled++;
	}

	// Enrolled를 1만큼 감소시키는 메소드
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
			// 같은 수업인지 확인한다.
			boolean b1 = (this.lectureName).equals(s.lectureName);	// lectureName 비교
			boolean b2 = (this.professor).equals(s.professor);		// professor 비교
			boolean b3 = (this.roomNumber).equals(s.roomNumber);	// roomNumber 비교
			return b1 && b2 && b3;	// 셋 모두가 같아야 하므로 AND 조건으로 묶음.
		}
	}

	public boolean checkLecture()
	{
		// 강의를 추가할 수 있는지 확인하는 메소드
		return this.lectureName.equals("----");
	}

}