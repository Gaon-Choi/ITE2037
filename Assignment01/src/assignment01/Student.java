package assignment01;

import java.util.Calendar;
import java.util.Scanner;

public class Student
{
	private String studentName;	// 이름
	private int studentCode;	// 학번
	Lecture timeTable[][] = new Lecture[10][5];

	public enum DAYS	// 주중 요일 표시(월요일, 화요일, 수요일, 목요일, 금요일)
	{
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
	}

	public Student()
	{
		if (this.timeTable != null)
			this.timeTable = new Lecture[10][5];
		
		// timeTable 초기화
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 5; j++)
				this.timeTable[i][j] = new Lecture();
	}

	public Student(String studentName, int studentCode)
	{
		// studentName, studentCode 초기화
		this.studentName = studentName;
		this.studentCode = studentCode;
		if (this.timeTable != null)
			this.timeTable = new Lecture[10][5];
		
		// timeTable 초기화
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 5; j++)
				this.timeTable[i][j] = new Lecture();
	}

	/* 각 변수들에 대한 accessor, mutator 메소드 선언 */
	// studentName의 accessor
	public String getStudentName()
	{
		return this.studentName;
	}

	// studentName의 mutator
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}

	// studentCode의 accessor
	public int getStudentCode()
	{
		return this.studentCode;
	}

	// studentCode의 mutator
	public void setStudentCode(int studentCode)
	{
		this.studentCode = studentCode;
	}

	// 인자로 받은 과목을 시간표에 추가하는 메소드
	public void setScheduleInformation(Lecture lecture)
	{
		// 최대 수강 인원에 도달한 경우 경고 메시지 출력
		if (lecture.getEnrolled() >= lecture.getMaxEnrolled())
		{
			System.out.println("강의를 추가할 수 없습니다. : 최대 수강 인원 초과");
		}
		// 강의를 추가할 수 있는지 확인하고, 불가능한 경우 경고 메시지 출력
		else if (!this.timeTable[lecture.getTime() - 1][DAYS.valueOf(lecture.getDay()).ordinal()].checkLecture()) {
			System.out.println("강의를 추가할 수 없습니다.");
		} else
		{
			this.timeTable[lecture.getTime() - 1][DAYS.valueOf(lecture.getDay()).ordinal()] = lecture;	// 인자로 받은 Lecture을 해당 위치에 추가
			lecture.incEnrolled();	// 수강 인원을 1만큼 증가
			System.out.println("시간이 정상적으로 추가되었습니다.");
		}
	}
	
	// 학생의 timeTable을 String 형태로 리턴하는 메소드
	public String showTimetable()
	{
		// 맨 윗줄에 요일을 표시
		String time_table = String.format("  %25s%25s%25s%25s%25s\n", DAYS.MONDAY, DAYS.TUESDAY, DAYS.WEDNESDAY, DAYS.THURSDAY,
				DAYS.FRIDAY);
		
		// 각 요일과 시간에 해당하는 lectureName을 출력
		for (int i = 0; i < 10; i++)
		{
			// 시간을 숫자로 표시
			time_table += String.format("%2d", i + 1);
			for (int j = 0; j < 5; j++)
			{
				// lectureName 부분 출력
				String str = String.format("%25s", timeTable[i][j].getLectureName());
				time_table += str;
			}
			time_table += '\n';	// 다음 시간에 대한 출력을 위해 개행
		}
		return time_table;
	}

	// 메소드를 호출한 객체와 인자로 받은 객체의 시간표를 비교하는 메소드
	public boolean equals(Student stu)
	{
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				// Lecture 클래스의 equals 메소드 호출
				if (!(this.timeTable[i][j].equals(stu.timeTable[i][j])))
					return false;	// timeTable의 lecture가 다르면 false 반환
			}
		}
		// 중첩 for문에서 timeTable의 모든 위치를 확인 후 true 반환
		return true;
	}

	// 요일과 시간을 인자로 받아 해당 수업을 학생의 시간표에서 지우는 메소드
	public void deleteSchedule(String day, int period)
	{
		// 우선 해당 위치에 수업이 들어있는지 확인
		// 수업이 없는 경우 아무것도 하지 않고 main문으로 이동
		if (this.timeTable[period - 1][DAYS.valueOf(day).ordinal()].checkLecture() == false)
		{
			this.timeTable[period - 1][DAYS.valueOf(day).ordinal()].decEnrolled();	// 해당 강의의 수강인원을 1만큼 감소
			this.timeTable[period - 1][DAYS.valueOf(day).ordinal()] = new Lecture();	// default 상태로 만들기 위해 Lecture 생성자 호출
		}
	}

	// 키보드로부터 년, 월, 일을 입력으로 받아 Calendar 클래스의 객체를 반환하는 메소드
	public Calendar setInputDate()
	{
		Calendar calendar = Calendar.getInstance();
		// 8자리의 형태로 된 날짜를 입력받음.("YYYYMMDD")
		Scanner scanner = new Scanner(System.in);
		String date = scanner.next();
		int year = Integer.parseInt(date.substring(0, 4));	// "YYYY" --> from index 0, to index 3
		int month = Integer.parseInt(date.substring(4, 6));	// "MM"   --> from index 4, to index 5
		int day = Integer.parseInt(date.substring(6, 8));	// "DD"   --> from index 6, to index 7
		// 입력받은 날짜로 설정
		calendar.set(year, month - 1, day);

		// calendar 객체로 반환
		return calendar;
	}

	// 인자로 받은 요일의 시간표만 String 형태로 반환하는 메소드
	public String oneDaySchedule(String day)
	{
		// 해당 요일 출력
		String time_table_ = String.format("%s\n", day);
		for (int i = 0; i < 10; i++)
		{
			time_table_ += String.format("%s\n", this.timeTable[i][DAYS.valueOf(day).ordinal()].getLectureName());
		}
		return time_table_;
	}

}
