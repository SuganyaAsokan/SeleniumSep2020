package org.student;

import org.department.Department;

public class Students extends Department {
	
	public void studentName() {
		
		System.out.println("Suganya");
	}
	
	public void studentDept() {
		
		System.out.println("Student department is computer science");

	}

	public void studentId() {
		
		System.out.println("Student ID is 82");

	}

	public static void main(String[] args) {
		
		Students stu = new Students();
		
		stu.studentName();
		stu.studentDept();
		stu.studentId();
		stu.deptName();
		stu.collegeName();
		stu.collegeCode();
		stu.collegeRank();

	}

}
