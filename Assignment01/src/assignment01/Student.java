package assignment01;

import java.util.Calendar;
import java.util.Scanner;

public class Student
{
	private String studentName;	// �̸�
	private int studentCode;	// �й�
	Lecture timeTable[][] = new Lecture[10][5];

	public enum DAYS	// ���� ���� ǥ��(������, ȭ����, ������, �����, �ݿ���)
	{
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
	}

	public Student()
	{
		if (this.timeTable != null)
			this.timeTable = new Lecture[10][5];
		
		// timeTable �ʱ�ȭ
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 5; j++)
				this.timeTable[i][j] = new Lecture();
	}

	public Student(String studentName, int studentCode)
	{
		// studentName, studentCode �ʱ�ȭ
		this.studentName = studentName;
		this.studentCode = studentCode;
		if (this.timeTable != null)
			this.timeTable = new Lecture[10][5];
		
		// timeTable �ʱ�ȭ
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 5; j++)
				this.timeTable[i][j] = new Lecture();
	}

	/* �� �����鿡 ���� accessor, mutator �޼ҵ� ���� */
	// studentName�� accessor
	public String getStudentName()
	{
		return this.studentName;
	}

	// studentName�� mutator
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}

	// studentCode�� accessor
	public int getStudentCode()
	{
		return this.studentCode;
	}

	// studentCode�� mutator
	public void setStudentCode(int studentCode)
	{
		this.studentCode = studentCode;
	}

	// ���ڷ� ���� ������ �ð�ǥ�� �߰��ϴ� �޼ҵ�
	public void setScheduleInformation(Lecture lecture)
	{
		// �ִ� ���� �ο��� ������ ��� ��� �޽��� ���
		if (lecture.getEnrolled() >= lecture.getMaxEnrolled())
		{
			System.out.println("���Ǹ� �߰��� �� �����ϴ�. : �ִ� ���� �ο� �ʰ�");
		}
		// ���Ǹ� �߰��� �� �ִ��� Ȯ���ϰ�, �Ұ����� ��� ��� �޽��� ���
		else if (!this.timeTable[lecture.getTime() - 1][DAYS.valueOf(lecture.getDay()).ordinal()].checkLecture()) {
			System.out.println("���Ǹ� �߰��� �� �����ϴ�.");
		} else
		{
			this.timeTable[lecture.getTime() - 1][DAYS.valueOf(lecture.getDay()).ordinal()] = lecture;	// ���ڷ� ���� Lecture�� �ش� ��ġ�� �߰�
			lecture.incEnrolled();	// ���� �ο��� 1��ŭ ����
			System.out.println("�ð��� ���������� �߰��Ǿ����ϴ�.");
		}
	}
	
	// �л��� timeTable�� String ���·� �����ϴ� �޼ҵ�
	public String showTimetable()
	{
		// �� ���ٿ� ������ ǥ��
		String time_table = String.format("  %25s%25s%25s%25s%25s\n", DAYS.MONDAY, DAYS.TUESDAY, DAYS.WEDNESDAY, DAYS.THURSDAY,
				DAYS.FRIDAY);
		
		// �� ���ϰ� �ð��� �ش��ϴ� lectureName�� ���
		for (int i = 0; i < 10; i++)
		{
			// �ð��� ���ڷ� ǥ��
			time_table += String.format("%2d", i + 1);
			for (int j = 0; j < 5; j++)
			{
				// lectureName �κ� ���
				String str = String.format("%25s", timeTable[i][j].getLectureName());
				time_table += str;
			}
			time_table += '\n';	// ���� �ð��� ���� ����� ���� ����
		}
		return time_table;
	}

	// �޼ҵ带 ȣ���� ��ü�� ���ڷ� ���� ��ü�� �ð�ǥ�� ���ϴ� �޼ҵ�
	public boolean equals(Student stu)
	{
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				// Lecture Ŭ������ equals �޼ҵ� ȣ��
				if (!(this.timeTable[i][j].equals(stu.timeTable[i][j])))
					return false;	// timeTable�� lecture�� �ٸ��� false ��ȯ
			}
		}
		// ��ø for������ timeTable�� ��� ��ġ�� Ȯ�� �� true ��ȯ
		return true;
	}

	// ���ϰ� �ð��� ���ڷ� �޾� �ش� ������ �л��� �ð�ǥ���� ����� �޼ҵ�
	public void deleteSchedule(String day, int period)
	{
		// �켱 �ش� ��ġ�� ������ ����ִ��� Ȯ��
		// ������ ���� ��� �ƹ��͵� ���� �ʰ� main������ �̵�
		if (this.timeTable[period - 1][DAYS.valueOf(day).ordinal()].checkLecture() == false)
		{
			this.timeTable[period - 1][DAYS.valueOf(day).ordinal()].decEnrolled();	// �ش� ������ �����ο��� 1��ŭ ����
			this.timeTable[period - 1][DAYS.valueOf(day).ordinal()] = new Lecture();	// default ���·� ����� ���� Lecture ������ ȣ��
		}
	}

	// Ű����κ��� ��, ��, ���� �Է����� �޾� Calendar Ŭ������ ��ü�� ��ȯ�ϴ� �޼ҵ�
	public Calendar setInputDate()
	{
		Calendar calendar = Calendar.getInstance();
		// 8�ڸ��� ���·� �� ��¥�� �Է¹���.("YYYYMMDD")
		Scanner scanner = new Scanner(System.in);
		String date = scanner.next();
		int year = Integer.parseInt(date.substring(0, 4));	// "YYYY" --> from index 0, to index 3
		int month = Integer.parseInt(date.substring(4, 6));	// "MM"   --> from index 4, to index 5
		int day = Integer.parseInt(date.substring(6, 8));	// "DD"   --> from index 6, to index 7
		// �Է¹��� ��¥�� ����
		calendar.set(year, month - 1, day);

		// calendar ��ü�� ��ȯ
		return calendar;
	}

	// ���ڷ� ���� ������ �ð�ǥ�� String ���·� ��ȯ�ϴ� �޼ҵ�
	public String oneDaySchedule(String day)
	{
		// �ش� ���� ���
		String time_table_ = String.format("%s\n", day);
		for (int i = 0; i < 10; i++)
		{
			time_table_ += String.format("%s\n", this.timeTable[i][DAYS.valueOf(day).ordinal()].getLectureName());
		}
		return time_table_;
	}

}
