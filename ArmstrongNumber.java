package week1.day2;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int input = 153;
		
		int cal=0;
		int rem;
		int org = 153;
		
		org=input;
		
		while (input>0) {
			
			rem = input % 10;//3 , 5 , 1
			
			input = input / 10;//15 , 1 , 0
			
			cal = cal+(rem*rem*rem);//3*3*3 , 5*5*5 , 1*1*1
		}
			
						
		if (cal == org) {
			System.out.println("Armstrong Number : "+cal);
		}
			else {
				System.out.println("Not an Armstrong Number");
			}
		
		}

	}
