package week1.day2;
import java.util.Arrays;

public class FindSecondLargest {

	public static void main(String[] args) {
		int[] data = {3,2,11,4,6,7};
		
		Arrays.sort(data); // 2,3,4,6,7,11
		
		int dataSize = data.length;
		int secondLar = data[dataSize-2];
		
		System.out.println("Second largest Number is : "+secondLar);
		
		
	
	}

}
