package week1.day2;

import java.util.Arrays;

public class PrintDuplicates {

	public static void main(String[] args) {
		int[] data = {14,12,13,11,15,14,18,16,17,19,18,17,20};
		
		Arrays.sort(data); 
		
		int dataSize = data.length;
		
		int count = 0;
		
		for (int i = 0; i < dataSize; i++) {
			for (int j = i+1; j < dataSize; j++) {
				
				if (data[i] == data[j]) {
					System.out.println(data[i]);
				}
			}
		}
		

	}

}
