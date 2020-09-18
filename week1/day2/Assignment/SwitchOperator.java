package week1.day2;

public class SwitchOperator {

	public static void main(String[] args) {
		
		int a = 50;
		int b = 30;
	
		String operation = "div" ;
		
		switch (operation) {
		
		case "add":System.out.println("Additon of a & b is : " + (a+b));
			break;
			
		case "sub":System.out.println("Subtraction of a & b is : " + (a-b));
		    break;
		    
		case "mul":System.out.println("Multiplication of a & b is : " + (a*b));
	        break;
	    
		case "div":System.out.println("Division of a & b is : " + (a/b));
	        break;

		default :System.out.println("Mod operation of a & b is : " + (a%b));
		}
	}

	}


