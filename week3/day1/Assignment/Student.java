package week3.day1;

public class Student {
	
	public void getStudentInfo(int id) {
		System.out.println("student id is : " +id);
	}
	
	public void getStudentInfo(int id , String name) {
		System.out.println("student id is : " +id+"Student name is : "+name);
	}
	
	public void getStudentInfo(String name , int id ) {
		System.out.println("student id is : " +id+"Studennt name is : "+name);
	}
	
	public void getStudentInfo(String email , long phno) {
		System.out.println("student email is : " +email+"Student phone number is :"+phno);
	}


	public static void main(String[] args) {
		
		Student stuDetails = new Student();
		
		stuDetails.getStudentInfo(82);
		stuDetails.getStudentInfo(82, "Suganya");
		stuDetails.getStudentInfo("sug@gmail.com", 9566095660L);
		stuDetails.getStudentInfo("Suganya" , 82);
		

	}

}
