public class HW13 {
	public static int countSameDigitMerge(int[] A) {
		int[] firstDigits = new int[10];
		int[] lastDigits = new int[10];
		
		for (int i = 0; i < A.length; i++) {
			lastDigits[A[i] % 10]++;
			while (A[i] > 9) {
				A[i] = (int) A[i] / 10;
			}
			firstDigits[A[i]]++;
		}
		
		int result = 0;
		for (int i = 0; i < firstDigits.length; i ++) {
			result += firstDigits[i] * lastDigits[i];
		}
		return result;
	} // On
	
	public static int calculateMoves(int[] A) {
		int[] numCount = new int[A[A.length-1] + 1];
		for (int i = 0; i < A.length; i++) {
			numCount[A[i]]++;
		}
		
		int moves = 0;
		for (int i = 0; i < numCount.length; i++) {
			if (numCount[i] > (int) i / 2) {
				moves += Math.abs(i - numCount[i]);
			} else {
				moves += (numCount[i]);
			}
		}
		return moves;
	} // On
	
	public static int findNextNoEqualDigits(int N) {
		N++;
		int[] digits = new int[String.valueOf(N).length() + 1];
		int result = 0;
		
		for (int i = 0, j = N; i < digits.length; i++) {
			digits[i] = j % 10;
			j = (int) j / 10;
		}

		for (int i = 0; i < digits.length-1; i++) {
			if (digits[i] == digits[i+1]) {
				if (digits[i] == 9) {
					digits[i++] = 1;
					while (digits[i] == 9) {
						digits[i] = digits[i-1] == 0 ? 1 : 0;
						i++;
					}
				}
				digits[i--]++;
			}
		}
		
		for (int i = digits.length-1; i >= 0; i--) {
			if(result > N) digits[i] = digits[i+1] == 0 ? 1 : 0;
			result += digits[i] * Math.pow(10, i);
		}
		return result;
	} // O1
	
	public static double squareRoot(int N) {
		double numAfterDecimal = -8d;
		double numBeforeDecimal = 5d;
		double result = 0d;
		
		for (double i = numBeforeDecimal - 1d; i >= numAfterDecimal; i--) {
			double unit = Math.pow(10d, i);		
			while (Math.pow(result + unit, 2d) - N <= 0d) {
				result += unit;
			}		
			if (Math.abs(Math.pow(result, 2d) - N) < 0.01d) {
				double corrector = Math.pow(10d, -numAfterDecimal);
				return Math.round(result * corrector) / corrector;
			}
		}
		return -1;
	} //O1
	
	public static void main(String[] args) {
		int[] A1 = {30, 12, 29, 91};
		int[] A2 = {122, 21, 21, 23};
		int[] A3 = {19, 19, 91, 91, 13, 32, 29};
		
		System.out.println(countSameDigitMerge(A1));
		System.out.println(countSameDigitMerge(A2));
		System.out.println(countSameDigitMerge(A3));
		
		System.out.println();
		
		int[] B1 = {1, 1, 3, 4, 4, 4};
		int[] B2 = {1, 2, 2, 2, 5, 5, 5, 8};
		int[] B3 = {1, 1, 1, 1, 3, 3, 4, 4, 4, 4, 4};
		int[] B4 = {10, 10, 10};
		
		System.out.println(calculateMoves(B1));
		System.out.println(calculateMoves(B2));
		System.out.println(calculateMoves(B3));
		System.out.println(calculateMoves(B4));
		
		System.out.println();
		
		System.out.println(findNextNoEqualDigits(9));
		System.out.println(findNextNoEqualDigits(55));
		System.out.println(findNextNoEqualDigits(1765));
		System.out.println(findNextNoEqualDigits(98));
		System.out.println(findNextNoEqualDigits(3298));
		System.out.println(findNextNoEqualDigits(339833));
		System.out.println(findNextNoEqualDigits(999999998));
		System.out.println(findNextNoEqualDigits(989899898));
		System.out.println(findNextNoEqualDigits(1999999999));
		
		System.out.println();
		
		System.out.println(squareRoot(1));
		System.out.println(squareRoot(2));
		System.out.println(squareRoot(3));
		System.out.println(squareRoot(4));
		System.out.println(squareRoot(171));
		System.out.println(squareRoot(Integer.MAX_VALUE));
	}
}
