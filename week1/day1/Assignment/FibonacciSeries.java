package week1.day1;

public class FibonacciSeries {

	public static void main(String[] args) {
		int range =8;
		int fnum = 0;
		int snum = 1;
		
		System.out.println(fnum);
		System.out.println(snum);
		
		for (int i = 3;i<=range;i++) {
			
			int sum=fnum+snum;
			System.out.println(sum);
			
			fnum=snum;
			snum=sum;
			
		}

	}

}
