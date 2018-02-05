import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// Test 1
		int [] A = {4,3,2,1};		
		PSort ps = new PSort();
		ps.parallelSort(A, 0, 4);		
		System.out.println(Arrays.toString(A));
		
		
		// Test 2
		A = new int [17];
		for(int i=0; i<17; i++) {
			A[16-i] = i;
		}
		ps.parallelSort(A, 0, 17);
		System.out.println(Arrays.toString(A));
		
		// Test 3
		A = new int [60];
		for(int i=0; i<60; i++) {
			A[59-i] = i;
		}
		ps.parallelSort(A, 0, 60);
		System.out.println(Arrays.toString(A));
		
		// Test 4
		A = new int [1000];
		for(int i=0; i<1000; i++) {
			A[999-i] = i;
		}
		ps.parallelSort(A, 0, 1000);
		System.out.println(Arrays.toString(A));
		
		// Test 5
		A = new int [10000];
		for(int i=0; i<10000; i++) {
			A[9999-i] = i;
		}
		ps.parallelSort(A, 0, 10000);
		System.out.println(Arrays.toString(A));


	}

}
