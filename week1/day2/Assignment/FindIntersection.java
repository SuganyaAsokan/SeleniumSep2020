package week1.day2;

public class FindIntersection {

	public static void main(String[] args) {
		
		int[] firstSet = {3,2,11,4,6,7};
		int[] secondSet = {1,2,8,4,9,7};
		
		int firstSetSize = firstSet.length;
		int secondSetSize = secondSet.length;
		
		for (int i = 0; i < firstSetSize; i++) {
			for (int j = 0; j < secondSetSize; j++) {
				
				if (firstSet[i] == secondSet[j]) {
					
					System.out.println(firstSet[i]);
				}
			}
		}

	}

}
