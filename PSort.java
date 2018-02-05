
//UT-EID1= av28837
//UT-EID2= 

import java.util.*;
import java.util.concurrent.*;

public class PSort extends RecursiveTask<ArrayList<Integer>> {
	ArrayList<Integer> A;
	int begin;
	int end;

	public static void parallelSort(int[] A, int begin, int end) {
		ArrayList<Integer> AL = new ArrayList<Integer>();

		for (int i = 0; i < A.length; i++) {
			AL.add(A[i]);
		}

		PSort ps = new PSort();
		ps.A = AL;
		ps.begin = begin;
		ps.end = end;

		ForkJoinPool pool = new ForkJoinPool();
		ArrayList<Integer> result = pool.invoke(ps);

		for (int i = 0; i < result.size(); i++) {
			A[i] = result.get(i);
		}
	}

	@Override
	protected ArrayList<Integer> compute() {
		int arraySize = end - begin;

		// Insert sort for array size <= 16
		if (arraySize <= 16) {
			for (int i = begin; i < end; i++) {
				int k = i;
				while ((k > begin) && (A.get(k - 1) > A.get(k))) {
					int temp = A.get(k);
					A.set(k, A.get(k - 1));
					A.set(k - 1, temp);
					k--;
				}
			}

			return A;
		}

		else {
			ArrayList<Integer> A1 = new ArrayList<Integer>();
			ArrayList<Integer> A2 = new ArrayList<Integer>();

			// Choosing pivot element
			int pivot = A.get(A.size() / 2);
			for (int i = begin; i < end; i++) {
				if (A.get(i) >= pivot) {
					A1.add(A.get(i));
				} else {
					A2.add(A.get(i));
				}
			}

			PSort ps1 = new PSort();
			ps1.A = A1;
			ps1.begin = 0;
			ps1.end = A1.size();
			ps1.fork();

			PSort ps2 = new PSort();
			ps2.A = A2;
			ps2.begin = 0;
			ps2.end = A2.size();

			ArrayList<Integer> result = ps2.compute();
			result.addAll(ps1.join());

			return result;

		}
	}
}
