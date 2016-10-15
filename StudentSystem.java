public class StudentSystem{

	private String studentNumber;
	private String firstName;
	private char middleInitial;
	private String lastName;
	private String course;
	private int yearLevel;

	public String toString() {
		return "Student Number: "+studentNumber+"\nName: "+lastName+", "+firstName+" "+middleInitial+".\nProgram: "+course+"\nYear Level: "+yearLevel+"\n";
	}

	public StudentSystem(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel){
		setStudentNumber(studentNumber);
		setFirstName(firstName);
		setMiddleInitial(middleInitial);
		setLastName(lastName);
		setCourse(course);
		setYearLevel(yearLevel); 
	}

	public void setStudentNumber(String studentNumber){	this.studentNumber = studentNumber; }
	public void setFirstName(String firstName){		this.firstName = firstName;	}
	public void setMiddleInitial(char middleInitial){		this.middleInitial = middleInitial;	}
	public void setLastName(String lastName){		this.lastName = lastName;	}
	public void setCourse(String course){		this.course = course;	}
	public void setYearLevel(int yearLevel){		this.yearLevel = yearLevel;	}

	public String getStudentNumber(){		return studentNumber;	}
	public String getFirstName(){		return firstName;	}
	public char getMiddleInitial(){		return middleInitial;	}
	public String getLastName(){		return lastName;	}
	public String getCourse(){		return course;	}
	public int getYearLevel(){		return yearLevel;	}
}