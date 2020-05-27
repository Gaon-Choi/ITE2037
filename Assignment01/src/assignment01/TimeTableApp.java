package assignment01;

import java.util.Calendar;
import java.util.Scanner;

public class TimeTableApp {
	// ���� �߰��� �� �ִ� ���Ǹ� �ܼ��ϰ� �ֿܼ� ������ִ� �޼ҵ�
	public static void show_menu()
	{
		System.out.println();
		System.out.println("�л��� �ð�ǥ�� �Է��Ϸ��� 1���� ��������");
		System.out.println("Ư�� ������ �����ϴ� �л����� ����Ϸ��� 2���� ��������");
		System.out.println("�л����� �ð�ǥ�� ���Ϸ��� 3���� ��������");
		System.out.println("�л��� �ð�ǥ�� ������� 4���� ��������");
		System.out.println("�ð�ǥ�� ����Ϸ��� 5���� ��������");
		System.out.println("�ش� �л��� Ư�� ��¥ �ð�ǥ�� ����Ϸ��� 6���� ��������");
		System.out.println("���α׷��� �����Ϸ��� 7���� ��������");
		System.out.println();
	}

	// ���ڷ� ���� id���� �ش��ϴ� �л��� �ε����� ��ȯ�ϴ� �޼ҵ�
	public static int find_idx(Student[] students, int id)
	{
		for (int i = 0; i < students.length; i++)
		{
			if (students[i].getStudentCode() == id)
				return i;
		}
		// �߰����� ���� ���, -1 ��ȯ
		return -1;
	}

	// ���ڷ� ���� title�� �ش��ϴ� ������ �ε����� ��ȯ�ϴ� �޼ҵ�
	public static int find_subject(Lecture[] lectures, String title)
	{
		for (int i = 0; i < lectures.length; i++)
		{
			if (lectures[i].getLectureName().equals(title))
				return i;
		}
		// �߰����� ���� ���, -1 ��ȯ
		return -1;
	}

	public static void main(String[] args)
	{
		Lecture lecture[] = new Lecture[10];
		lecture[0] = new Lecture("MONDAY", 1, "OOP", "mr.park", "ITBT808", 1);
		lecture[1] = new Lecture("TUESDAY", 2, "security", "mr.park", "ITBT816", 20);
		lecture[2] = new Lecture("WEDNESDAY", 1, "Datastructure", "mr.park", "ITBT808", 25);
		lecture[3] = new Lecture("THURSDAY", 6, "Network", "mr.yang", "ITBT503", 20);
		lecture[4] = new Lecture("FRIDAY", 9, "computer architecture", "mr.han", "ITBT507", 20);
		lecture[5] = new Lecture("TUESDAY", 5, "Digital logic", "mr.kim", "ITBT401", 15);
		lecture[6] = new Lecture("WEDNESDAY", 2, "OS", "mr.yoon", "ITBT606", 15);
		lecture[7] = new Lecture("THURSDAY", 3, "C-language", "mr.choi", "ITBT503", 20);
		lecture[8] = new Lecture("FRIDAY", 6, "Python", "mr.han", "ITBT504", 15);
		lecture[9] = new Lecture("TUESDAY", 9, "Ski-Board", "mr.kang", "ITBT404", 5);

		Scanner keyboard = new Scanner(System.in);
		String[] weeks = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
		Calendar cal = Calendar.getInstance();

		/* u can define variables */
		System.out.println("�л����� �Է��ϼ���");
		int stu_num = keyboard.nextInt();

		String name;	// �л� �̸�
		int code;		// �л� �й�

		/* write code */
		Student[] student = new Student[stu_num];
		// �л�����ŭ ������ �̸��� �й��� �Է¹޴´�.
		for (int i = 0; i < stu_num; i++)
		{
			System.out.printf("%d �л��� �̸��� �Է��ϼ���\n", i + 1);
			name = keyboard.next();
			System.out.printf("%d �л��� �й��� �Է��ϼ���\n", i + 1);
			code = keyboard.nextInt();
			student[i] = new Student(name, code);
		}

		int enter;
		boolean endCoin = true;
		do
		{

			/* write code */
			int idx = -1, idx_;
			show_menu();
			// buffer = keyboard.nextLine();
			enter = keyboard.nextInt();

			switch (enter)
			{
			case 1:
				System.out.println("�ð�ǥ�� �Է��� �л��� �й��� �Է��ϼ���");
				code = keyboard.nextInt();
				idx = find_idx(student, code);
				System.out.println("���� �� �߰��� �ð�ǥ�� ��ȣ�� �Է��ϼ���");
				System.out.print("\n\n");
				showClass();
				System.out.print("\n");
				idx_ = keyboard.nextInt();
				
				// �л��� �ð�ǥ�� �ش� Lecture�� �߰�
				student[idx].setScheduleInformation(lecture[idx_ - 1]);
				break;

			case 2:
				System.out.println("������ �̸��� �Է��ϼ���");
				String buffer = keyboard.nextLine();
				String sub = keyboard.nextLine();	// ���� �̸��� ���ٷ� �Է¹���.
				if (find_subject(lecture, sub) == -1)	// �Է¹��� title�� �ش��ϴ� Lecture�� �������� ���� ���
					System.out.println("�ش� ������ �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				else	// �Է¹��� title�� �ش��ϴ� Lecture�� �����ϴ� ���
				{
					Lecture lec = lecture[find_subject(lecture, sub)];
					// �ش� ������ ���� �ο��� �˷��ִ� �޽��� ���
					System.out.println(lec.getLectureName() + " ������ �����ϴ� �л��� ���� " + lec.getEnrolled());
				}
				break;

			case 3:
				System.out.println("�ð�ǥ�� ���� ù��° �л��� �й��� �Է��ϼ���");
				int id_1 = keyboard.nextInt();
				System.out.println("�ι�° �л��� �й��� �Է��ϼ���");
				int id_2 = keyboard.nextInt();
				
				// Student Ŭ������ equals �޼ҵ带 �̿��Ͽ� ��(--> timeTable�� ����)
				boolean check = student[find_idx(student, id_1)].equals(student[find_idx(student, id_2)]);
				if (check)	// �� �л��� �ð�ǥ�� ������ ���
					System.out.println("�� �л��� �ð�ǥ�� �����ϴ�.");
				else		// �� �л��� �ð�ǥ�� �������� ���� ���
					System.out.println("�� �л��� �ð�ǥ�� �ٸ��ϴ�.");
				break;

			case 4:
				System.out.println("�ð�ǥ�� ������ �л��� �й��� �Է��ϼ���");
				code = keyboard.nextInt();
				idx = find_idx(student, code);
				
				System.out.println("���� �ð�ǥ�� ������ �Է��ϼ���");
				String day = keyboard.next();
				day = day.toUpperCase();	// �Է¹��� �� ��ҹ����� ������ �����ϱ� ����.
				
				System.out.println("���� �ð�ǥ�� �ð��� �Է��ϼ���");
				int time = keyboard.nextInt();
				
				// �Է¹��� day, time�� �ش��ϴ� �ð�ǥ�� ����
				student[idx].deleteSchedule(day, time);
				
				// ���� �� showTimetable() �޼ҵ带 ȣ���Ͽ� �ð�ǥ�� ���
				System.out.println(student[idx].showTimetable());
				break;

			case 5:
				System.out.println("�ð�ǥ�� ����� �л��� �й��� �Է��ϼ���");
				code = keyboard.nextInt();
				idx = find_idx(student, code);
				System.out.println(student[idx].showTimetable());
				break;

			case 6:
				System.out.println("����� �л��� �й��� �Է��ϼ���");
				code = keyboard.nextInt();
				idx = find_idx(student, code);
				
				System.out.println("Enter the date:");
				cal = student[idx].setInputDate();
				int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
				
				if(day_of_week >= 2 && day_of_week <= 6)	// �Է¹��� ���� ������~�ݿ����� ������ ���
					System.out.println(student[idx].oneDaySchedule(weeks[day_of_week - 1]));
				else										// �Է¹��� ���� �����, �Ͽ����� �ָ��� ���
					System.out.println("�ش� ��¥�� �ָ�(�����, �Ͽ���)�Դϴ�.");
				break;

			case 7:	// ���α׷� ����
				endCoin = false;
				break;

			default:	// �� �̿��� ���ڸ� �Է¹��� ��� ���� �޽��� ����� �� ���ι����� ���ư�.
				System.out.println("Try again\n");
				break;
			}

		} while (endCoin);
		keyboard.close();
	}

	// �߰��� �� �ִ� ������ ����Ʈ�� �����ִ� �޼ҵ�
	private static void showClass()
	{
		System.out.println("(1) OOP - ������ - 1����");
		System.out.println("(2) security - ȭ���� - 2����");
		System.out.println("(3) Datastructure - ������ - 1����");
		System.out.println("(4) Network - ����� - 6����");
		System.out.println("(5) computer architecture - �ݿ��� - 8����");
		System.out.println("(6) Digital logic - ȭ���� - 5����");
		System.out.println("(7) OS - ������ - 2����");
		System.out.println("(8) C-language - ����� - 3����");
		System.out.println("(9) Python - �ݿ��� - 6����");
		System.out.println("(10) Ski-Board - ȭ���� - 9����");
	}
}
