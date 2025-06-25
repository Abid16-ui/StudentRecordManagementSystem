import java.util.ArrayList;
import java.util.Scanner;

class Student {
	
	int id;
	String name;
	double marks;
	
	public Student(int id, String name, double marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}
}

public class StudentCURD{
	static ArrayList<Student> students = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int choice;
		
		do {
			System.out.println("***** STUDENT RECORD MANAGEMENT SYSTEM *****");
			System.out.println("1.Add Student");
			System.out.println("2.View All Students");
			System.out.println("3.Update Students");
			System.out.println("4.Delete Students");
			System.out.println("5.Exit");
			
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1 -> addStudent();
			case 2 -> viewStudent();
  		    case 3 -> updateStudent();
			case 4 -> deleteStudent();
			case 5 -> System.out.println("Exiting.....");
			default -> System.out.println("Invalid Choice");
			}
		}while(choice != 5);
	}
	
	static void addStudent() {
		System.out.print("Enter ID : ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Name : ");
		String name = sc.nextLine();
		System.out.print("Enter Marks : ");
		double marks = sc.nextDouble();
		students.add(new Student(id,name,marks));
		System.out.println("Student Added Successfully");
	}
	
	static void viewStudent() {
		if(students.isEmpty()) {
			System.out.println("No Students to display");
		}else {
			System.out.println("Student List");
			for(Student s : students) {
				System.out.println(s);
			}
		}
	}
	
	static void updateStudent() {
		System.out.println("Enter Id of Student to update : ");
		int id = sc.nextInt();
		boolean found = false;
		for(Student s : students) {
			if(s.id == id) {
				sc.nextLine();
				System.out.print("Enter New Name : ");
				s.name = sc.nextLine();
				System.out.print("Enter New Marks : ");
				s.marks = sc.nextDouble();
				System.out.println("Student Updated Successfully");
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("Student not found.");
		}
	}
	
	static void deleteStudent() {
		System.out.println("Enter Id of the Student to delete : ");
		int id = sc.nextInt();
		boolean removed = students.removeIf(s -> s.id == id);
		if(removed) {
			System.out.println("Student Deleted successfully");
		}else {
			System.out.println("Student not found.");
		}
	}
}