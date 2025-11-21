import java.util.HashMap;

public class HW14 {
	public static int findInterval(int[] A, int L, int R) {
		int[] nums = new int[R-L+1];
		for (int i = 0; i < A.length; i++) {
			if (L <= A[i] && A[i] <= R) nums[A[i]-L]++;
		}
		
		for (int i = L; i <= R; i++) {
			if (nums[i-L] < 1) return -1;
		}
		
		int s = 0;
		int e = A.length-1;
		boolean sDone = false;
		boolean eDone = false;
		while(!sDone || !eDone) {
			if (A[s] < L || A[s] > R) {
				s++;
			} else if (nums[A[s] - L] > 1) {
				nums[A[s] - L]--;
				s++;
			} else {
				sDone = true;
			}
			
			if (A[e] < L || A[e] > R) {
				e--;
			} else if (nums[A[e] - L] > 1) {
				nums[A[e] - L]--;
				e--;
			} else {
				eDone = true;
			}
 		}
		
		return (e - s + 1);
	}
	
	public static int findInterval2(int[] A, int L, int R) {
		HashMap<Integer, Integer> nums = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (L > A[i] || A[i] > R) {
				continue;
			}
			nums.put(A[i], nums.getOrDefault(A[i], 0) + 1);
		}
		
		if (nums.size() < R-L+1) return -1;
		
		int s = 0;
		int e = A.length-1;
		boolean sDone = false;
		boolean eDone = false;
		while(!sDone || !eDone) {
			if (A[s] < L || A[s] > R) {
				s++;
			} else if (nums.get(A[s]) > 1) {
				nums.put(A[s], nums.get(A[s]) - 1);
				s++;
			} else {
				sDone = true;
			}
			
			if (A[e] < L || A[e] > R) {
				e--;
			} else if (nums.get(A[e]) > 1) {
				nums.put(A[e], nums.get(A[e]) - 1);
				e--;
			} else {
				eDone = true;
			}
 		}
		
		return (e - s + 1);
	}
	
	public static void main(String[] args) {
		int[] A = {2, 1, 4, 3, 2, 1, 1, 4};
		int[] B = {109, 1, 1, 1, 1, 1, 108};
		int[] C = {1, 3, 5, 7};
		
		System.out.println(findInterval(A, 2, 4));
		System.out.println(findInterval(B, 108, 109));
		System.out.println(findInterval(C, 3, 5));
		
		System.out.println();
		
		System.out.println(findInterval2(A, 2, 4));
		System.out.println(findInterval2(B, 108, 109));
		System.out.println(findInterval2(C, 3, 5));
	}
}
