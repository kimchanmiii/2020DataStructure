// Lab 010	: Natural Merge
// Name : Kim Chan Mi
// Student ID : 20191574

import java.util.*;


class NaturalMerge {
	int noe;  // the number of elements
	private int[] inputArray; // input array 
	int[] outputArray; // output array 


	NaturalMerge() { 
		noe = 0;
	}

	void Init(int [] arr, int n) { 
		noe = n;
		inputArray = new int[noe];
		System.arraycopy(arr, 0, inputArray, 0, n);

		outputArray = new int[noe];
	}

	void Merge() { 
		int m = 0;
		int idx = 0;
		
		while(idx < noe - 1){
			if(inputArray[idx] > inputArray[idx + 1]){
				m = idx + 1;
				idx++;
			}
			else idx++;
		}

		System.out.println("m = " + m + ", n = " + noe);
		
		int mid = m;
		int[] first_arr = Arrays.copyOfRange(inputArray, 0, mid);
		int[] second_arr = Arrays.copyOfRange(inputArray, mid, inputArray.length);

		int k = 0, f = 0, s = 0;
		while (f < first_arr.length && s < second_arr.length) {
			if (first_arr[f] < second_arr[s])
		    outputArray[k++] = first_arr[f++];
		  else
		    outputArray[k++] = second_arr[s++];
		}
		while (f < first_arr.length) {
		   outputArray[k++] = first_arr[f++];
		}
		while (s < second_arr.length) {
		   outputArray[k++] = second_arr[s++];
		}
		
		// NEED TO IMPLEMENT

	}
}


