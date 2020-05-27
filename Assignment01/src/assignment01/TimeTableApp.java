package assignment01;

import java.util.Calendar;
import java.util.Scanner;

public class TimeTableApp {
	// 현재 추가할 수 있는 강의를 단순하게 콘솔에 출력해주는 메소드
	public static void show_menu()
	{
		System.out.println();
		System.out.println("학생의 시간표를 입력하려면 1번을 누르세요");
		System.out.println("특정 과목을 수강하는 학생수를 출력하려면 2번을 누르세요");
		System.out.println("학생들의 시간표를 비교하려면 3번을 누르세요");
		System.out.println("학생의 시간표를 지우려면 4번을 누르세요");
		System.out.println("시간표를 출력하려면 5번을 누르세요");
		System.out.println("해당 학생의 특정 날짜 시간표를 출력하려면 6번을 누르세요");
		System.out.println("프로그램을 종료하려면 7번을 누르세요");
		System.out.println();
	}

	// 인자로 받은 id값에 해당하는 학생의 인덱스를 반환하는 메소드
	public static int find_idx(Student[] students, int id)
	{
		for (int i = 0; i < students.length; i++)
		{
			if (students[i].getStudentCode() == id)
				return i;
		}
		// 발견하지 못할 경우, -1 반환
		return -1;
	}

	// 인자로 받은 title에 해당하는 수업의 인덱슬를 반환하는 메소드
	public static int find_subject(Lecture[] lectures, String title)
	{
		for (int i = 0; i < lectures.length; i++)
		{
			if (lectures[i].getLectureName().equals(title))
				return i;
		}
		// 발견하지 못할 경우, -1 반환
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
		System.out.println("학생수를 입력하세요");
		int stu_num = keyboard.nextInt();

		String name;	// 학생 이름
		int code;		// 학생 학번

		/* write code */
		Student[] student = new Student[stu_num];
		// 학생수만큼 각각의 이름과 학번을 입력받는다.
		for (int i = 0; i < stu_num; i++)
		{
			System.out.printf("%d 학생의 이름을 입력하세요\n", i + 1);
			name = keyboard.next();
			System.out.printf("%d 학생의 학번을 입력하세요\n", i + 1);
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
				System.out.println("시간표를 입력할 학생의 학번을 입력하세요");
				code = keyboard.nextInt();
				idx = find_idx(student, code);
				System.out.println("다음 중 추가할 시간표의 번호를 입력하세요");
				System.out.print("\n\n");
				showClass();
				System.out.print("\n");
				idx_ = keyboard.nextInt();
				
				// 학생의 시간표에 해당 Lecture를 추가
				student[idx].setScheduleInformation(lecture[idx_ - 1]);
				break;

			case 2:
				System.out.println("과목의 이름을 입력하세요");
				String buffer = keyboard.nextLine();
				String sub = keyboard.nextLine();	// 과목 이름을 한줄로 입력받음.
				if (find_subject(lecture, sub) == -1)	// 입력받은 title에 해당하는 Lecture가 존재하지 않은 경우
					System.out.println("해당 과목이 존재하지 않습니다. 다시 입력해주세요.");
				else	// 입력받은 title에 해당하는 Lecture가 존재하는 경우
				{
					Lecture lec = lecture[find_subject(lecture, sub)];
					// 해당 과목의 수강 인원을 알려주는 메시지 출력
					System.out.println(lec.getLectureName() + " 과목을 수강하는 학생의 수는 " + lec.getEnrolled());
				}
				break;

			case 3:
				System.out.println("시간표를 비교할 첫번째 학생의 학번을 입력하세요");
				int id_1 = keyboard.nextInt();
				System.out.println("두번째 학생의 학번을 입력하세요");
				int id_2 = keyboard.nextInt();
				
				// Student 클래스의 equals 메소드를 이용하여 비교(--> timeTable를 비교함)
				boolean check = student[find_idx(student, id_1)].equals(student[find_idx(student, id_2)]);
				if (check)	// 두 학생의 시간표가 동일한 경우
					System.out.println("두 학생의 시간표는 같습니다.");
				else		// 두 학생의 시간표가 동일하지 않은 경우
					System.out.println("두 학생의 시간표는 다릅니다.");
				break;

			case 4:
				System.out.println("시간표를 삭제할 학생의 학번을 입력하세요");
				code = keyboard.nextInt();
				idx = find_idx(student, code);
				
				System.out.println("지울 시간표의 요일을 입력하세요");
				String day = keyboard.next();
				day = day.toUpperCase();	// 입력받을 때 대소문자의 구분을 없게하기 위함.
				
				System.out.println("지울 시간표의 시간을 입력하세요");
				int time = keyboard.nextInt();
				
				// 입력받은 day, time에 해당하는 시간표를 지움
				student[idx].deleteSchedule(day, time);
				
				// 삭제 후 showTimetable() 메소드를 호출하여 시간표를 출력
				System.out.println(student[idx].showTimetable());
				break;

			case 5:
				System.out.println("시간표를 출력할 학생의 학번을 입력하세요");
				code = keyboard.nextInt();
				idx = find_idx(student, code);
				System.out.println(student[idx].showTimetable());
				break;

			case 6:
				System.out.println("출력할 학생의 학번을 입력하세요");
				code = keyboard.nextInt();
				idx = find_idx(student, code);
				
				System.out.println("Enter the date:");
				cal = student[idx].setInputDate();
				int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
				
				if(day_of_week >= 2 && day_of_week <= 6)	// 입력받은 날이 월요일~금요일의 주중인 경우
					System.out.println(student[idx].oneDaySchedule(weeks[day_of_week - 1]));
				else										// 입력받은 날이 토요일, 일요일의 주말인 경우
					System.out.println("해당 날짜는 주말(토요일, 일요일)입니다.");
				break;

			case 7:	// 프로그램 종료
				endCoin = false;
				break;

			default:	// 그 이외의 숫자를 입력받은 경우 에러 메시지 출력한 후 메인문으로 돌아감.
				System.out.println("Try again\n");
				break;
			}

		} while (endCoin);
		keyboard.close();
	}

	// 추가할 수 있는 수업의 리스트를 보여주는 메소드
	private static void showClass()
	{
		System.out.println("(1) OOP - 월요일 - 1교시");
		System.out.println("(2) security - 화요일 - 2교시");
		System.out.println("(3) Datastructure - 수요일 - 1교시");
		System.out.println("(4) Network - 목요일 - 6교시");
		System.out.println("(5) computer architecture - 금요일 - 8교시");
		System.out.println("(6) Digital logic - 화요일 - 5교시");
		System.out.println("(7) OS - 수요일 - 2교시");
		System.out.println("(8) C-language - 목요일 - 3교시");
		System.out.println("(9) Python - 금요일 - 6교시");
		System.out.println("(10) Ski-Board - 화요일 - 9교시");
	}
}
