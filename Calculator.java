package week1.day2;

public class Calculator {
	
	public int addition(int a,int b) {
		return a+b;
		}
	public double multiplication(double x, double y) {
		return x*y;

	}
	public int subtraction(int c, int d) {
		return c-d;
	}

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		int add = cal.addition(100, 200);
		System.out.println("Additon of a and b :" +add);
		double mul = cal.multiplication(500, 500);
		System.out.println("Multiplication of x and y :" +mul);
		int sub = cal.subtraction(300, 100);
		System.out.println("subtraction of c and d :" +sub);

	}

}
