package homework_1;

import java.util.Arrays;
import java.util.Random;

public class RandomTestPmerge {
  public static void main (String[] args) {
	int[] anArray1 = new int[100];
    for(int i=0;i<anArray1.length;i++)
    {
    	Random rand = new Random();
        int randomNum = rand.nextInt(i*10+10)+(i*10000);
        anArray1[i] = randomNum;
    }
    int[] anArray2 = new int[100];
    for(int i=0;i<anArray1.length;i++)
    {
    	Random rand = new Random();
        int randomNum = rand.nextInt(i*10+10)+(i*10000);
        anArray2[i] = randomNum;
    }
    int[] anArray3 = new int[2000];
    verifyParallelMerge(anArray1,anArray2);
    
  }

  static void verifyParallelMerge(int[] A, int[] B) {
    int[] C = new int[A.length + B.length];
	int[] D = new int[A.length + B.length];

    System.out.println("Verify Parallel Merge for arrays: ");
    printArray(A);

	printArray(B);
    merge(A, B, C);

    PMerge.parallelMerge(A, B, D, 10);
   	
    boolean isSuccess = true;
    for (int i = 0; i < C.length; i++) {
      if (C[i] != D[i]) {
        System.out.println("Your parallel sorting algorithm is not correct");
        System.out.println("Expect:");
        printArray(C);
        System.out.println("Your results:");
        printArray(D);
        isSuccess = false;
        break;
      }
    }

    if (isSuccess) {
      System.out.println("Great, your sorting algorithm works for this test case");
    }
    System.out.println("=========================================================");
  }

  public static void merge(int[] A, int[] B, int[] C) {
  	int h = 0, i = 0, j = 0;
	while(i < A.length || j < B.length) {
		if(i == A.length) {
			C[h ++] = B[j ++];
		} else if(j == B.length) {
			C[h ++] = A[i ++];
		} else {
			if(A[i] < B[j]) C[h ++] = A[i ++];
			else C[h ++] = B[j ++];
		}
	}
  }

  public static void printArray(int[] A) {
    for (int i = 0; i < A.length; i++) {
      if (i != A.length - 1) {
        System.out.print(A[i] + " ");
      } else {
        System.out.print(A[i]);
      }
    }
    System.out.println();
  }
}