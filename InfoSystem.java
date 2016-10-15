import java.io.*;
import java.util.*;
import java.util.regex.*;

public class InfoSystem{
	public static void main(String[] args) throws IOException {
		List <StudentSystem> listOfStudents = new ArrayList<StudentSystem>();
		BufferedReader br = null;
		String studentNumber, firstName, lastName, course, middleInitial;
		char middleIn;
		int yearLevel;
		Scanner sc = new Scanner(System.in);
		try {
			String sCurrentline;
			br = new BufferedReader(new FileReader("db.txt"));
			while((sCurrentline = br.readLine()) != null){
				studentNumber = sCurrentline;
				firstName = br.readLine();
				middleInitial = br.readLine();
				if (middleInitial.equals("")){
					middleIn = 32;
				}
				else{
					middleIn = middleInitial.charAt(0);
				}
				lastName = br.readLine();
				course = br.readLine();
				yearLevel = Integer.parseInt(br.readLine());
				StudentSystem ss = new StudentSystem(studentNumber, firstName, middleIn, lastName, course, yearLevel);
				listOfStudents.add(ss);
			}
		}
		catch(IOException e) {
			System.out.println("FILE NOT FOUND!");
			e.printStackTrace();
			System.exit(0);
		}
		finally {
			try{
				if(br != null) br.close();
			}

			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		int choice;
		do{
		System.out.println("STUDENT INFORMATION SYSTEM");
		System.out.println("1 - REGISTER\n2 - INFORMATION\n3 - DELETE\n4 - SAVE\n5 - EDIT\n6 - EXIT\n"); 
			choice = sc.nextInt();
			if (choice == 1){
				System.out.println("Student Number: ");
				studentNumber = sc.next();
				register(listOfStudents, studentNumber, sc);
			}
			else if (choice == 2){
				System.out.print("Student Number: ");
				studentNumber = sc.next();
				search(listOfStudents, studentNumber);
			}
			else if (choice == 3){
				System.out.print("Student Number: ");
				studentNumber = sc.next();
				delete(listOfStudents, studentNumber);
			}
			else if (choice == 4){
				save(listOfStudents);
			}	
			else if (choice == 5){
				System.out.println("Student Number: ");
				studentNumber = sc.next();
				edit(listOfStudents, studentNumber, sc);
			}
			else{
				System.out.println("Do you want to save your current work? 1 if YES and 0 if NO.");
				int ifsave = sc.nextInt();
				if(ifsave == 1){
					save(listOfStudents);
				}
				System.out.println("Au revoir! A bientot!");
				break;
			}
		}while (choice<=6 && choice>=1);
	}
public static void save(List<StudentSystem> listOfStudents){
	try{
		File file = new File ("db.txt");
		if (!file.exists()){
			file.createNewFile();
		}
			FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				for(StudentSystem s: listOfStudents){
					bw.write(s.getStudentNumber());
					bw.newLine();
					bw.write(s.getFirstName());
					bw.newLine();
					bw.write(s.getMiddleInitial());
					bw.newLine();
					bw.write(s.getLastName());
					bw.newLine();
					bw.write(s.getCourse());
					bw.newLine();
					bw.write(s.getYearLevel() + "");
					bw.newLine();
				}
				System.out.println("The InfoSystem has been saved.");
				bw.close();
	}
	catch (IOException e){
		e.printStackTrace();
	}
}
public static void register(List<StudentSystem> listOfStudents, String studentNumber, Scanner sc){
	String firstName, lastName, course;
	char middleIn;
	int yearLevel;
			if (listOfStudents.contains(studentNumber)){
					System.out.println("The student number exist.");
			}
			else{
			System.out.println("First Name: ");				
			firstName = sc.next();
			System.out.println("Middle Initial: ");				
				if (sc.nextLine().equals("")){
					middleIn = 32;
				}
				middleIn = sc.next().charAt(0);
					
				System.out.println("Last Name: ");				
				lastName = sc.next();
				System.out.println("Course: ");				
				course = sc.next();
				System.out.println("Year Level: ");				
				yearLevel = sc.nextInt();
				StudentSystem ss2 = new StudentSystem(studentNumber, firstName, middleIn, lastName, course, yearLevel);
				listOfStudents.add(ss2);
				System.out.println("Student Added!");
			}
}
public static void search(List<StudentSystem> listOfStudents, String studentNumber){
	boolean flag = false;
	for(StudentSystem s: listOfStudents){
		if(s.getStudentNumber().equals(studentNumber)){
			System.out.println(s);
			flag = true;
		}
	}
		if (!flag){
			System.out.println("The student number " + studentNumber + " does not exist.");
		}
}
public static void delete(List<StudentSystem> listOfStudents, String studentNumber){
	boolean flag = false;
		for(StudentSystem s: listOfStudents){
			if(s.getStudentNumber().equals(studentNumber)){
				listOfStudents.remove(s);
				flag = true;
				break; 
			}
		}
			if (!flag){
				System.out.println("The student number " + studentNumber + " does not exist.");
			}
}
public static void edit(List<StudentSystem> listOfStudents, String studentNumber, Scanner sc){
	String firstName, lastName, course;
	char middleIn;
	int yearLevel;
	boolean flag = false;
	for(StudentSystem s: listOfStudents){
		if(s.getStudentNumber().equals(studentNumber)){
			System.out.println("Change First Name: ");
			firstName = sc.next();
			s.setFirstName(firstName);
			System.out.println("Change Middle Initial: ");
			middleIn = sc.next().charAt(0);
			s.setMiddleInitial(middleIn);
			System.out.println("Change Last Name: ");
			lastName = sc.next();
			s.setLastName(lastName);
			System.out.println("Change Course: ");
			course = sc.next();
			s.setCourse(course);
			System.out.println("Change Year Level: ");
			yearLevel = sc.nextInt();
			s.setYearLevel(yearLevel);
			System.out.println("Updated a student!");
			flag = true;
		}
	}
		if (!flag){
			System.out.println("The student number " + studentNumber + " does not exist.");
		}			
}
}