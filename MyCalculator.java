package week1.day2;

public class MyCalculator {
	
	public int dividion(int m, int n) {
		
		return m/n;
		

	}

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		MyCalculator cal1 = new MyCalculator();
		
		int add = cal.addition(100, 200);
		System.out.println("Additon of a and b :" +add);
		
		double mul = cal.multiplication(500, 500);
		System.out.println("Multiplication of x and y :" +mul);
		
		int sub = cal.subtraction(300, 100);
		System.out.println("subtraction of c and d :" +sub);
		
		int div = cal1.dividion(100, 10);
		System.out.println("Division of m and n :" +div);
		
	}

}
