package week1.day2;

import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		int[] data = {1,2,3,4,7,8};
		
		Arrays.sort(data); // 1,2,3,4,6,7,8
		
		int firstNum = data[0];
		int lastNum = data[data.length-1];
		
		int nextNum = firstNum+1;
		
		while(nextNum <= lastNum ) {
			 if (Arrays.binarySearch(data, nextNum) < 0) {
				
				 System.out.println(nextNum);
			}
			 nextNum++;
		}

	}

}
