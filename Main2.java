import java.util.Arrays;

public class Main2 {

	public static void main(String[] args) {
		
		//Test 1
		int [] A = {1,5,10};
		int [] B = {2,4,6};
		int [] C = new int [6];
		
		PMerge pm = new PMerge();
		
		pm.parallelMerge(A, B, C, 1);
		System.out.println(Arrays.toString(C));
		
		//Test 2
		A = new int [] {1,5,10};
		B = new int [] {2,4,6};
		C = new int [6];
		
		pm = new PMerge();
		
		pm.parallelMerge(A, B, C, 2);
		System.out.println(Arrays.toString(C));
		
		//Test 3
		A = new int [] {1,5,10};
		B = new int [] {2,5,6};
		C = new int [6];
		
		pm = new PMerge();
		
		pm.parallelMerge(A, B, C, 1);
		System.out.println(Arrays.toString(C));
		
		//Test 4
		A = new int [] {1,5,10};
		B = new int [] {2,5,6};
		C = new int [6];
		
		pm = new PMerge();
		
		pm.parallelMerge(A, B, C, 9);
		System.out.println(Arrays.toString(C));
		
		
		

	}

}
