// Lab 007	: Disjoint Sets
// Name :
// Student ID :

import java.util.*;


class DisjointSets {
	int numofelements;  // the total number of elements in all the disjoint sets
	private int[] parent; // maintains the parent pointer of each element in the disjoint sets
	private int[] weight; // maintains the weight of each set


	DisjointSets() { 
		// DisjointSets constructor. 
	}

	public String toString() { // Show all the element in sequence
		String str = new String();
	    // Show the array elements in parent[]

		str = "parent[]: - ";
		for(int i = 1; i <= numofelements; i++)
			str += parent[i] + " ";
		return str;
	}

	void InitSet(int n) { 
		// Initialize the array parent[] and weight[]
		numofelements = n;
		
		parent = new int[n + 1];
		weight = new int[n + 1];
		
		for (int k = 1; k <= n; k++) {
			parent[k] = 0;
		}
		for (int k = 1; k <= n; k++) {
			weight[k] = 0;
		}
	}

	boolean Union(int i, int j) { 
	// Union the set that contains i and the set that contains j
	// the set that has larger weight is the new root of the unioned set
	// when the weights are the same, choose the root of smaller value

		// first find the root of i and j
		
		if (SimpleFind(i) == i && SimpleFind(j) == j) {
			if (weight[j] == weight[i]) {
				if (j > i) {
					parent[i] = j;
					weight[j] = weight[j] + weight[i] + 1;
				}
				else {
					parent[j] = i;
					weight[i] = weight[j] + weight[i] + 1;
				}
			}
			else if (weight[i] < weight[j]) {
				parent[i] = j;
				weight[j] = weight[j] + weight[i] + 1;
			}
			else {
				parent[j] = i;
				weight[i] = weight[j] + weight[i] + 1;
			}
		}
		else if ((SimpleFind(i) != i || SimpleFind(j) != j) && SimpleFind(i) > SimpleFind(j)) {
			int m = SimpleFind(j);
			int n = SimpleFind(i);
			if (weight[m] == weight[n]) {
				if (m > n) {
					parent[n] = m;
					weight[m] = weight[m] + weight[n] + 1;
				}
				else {
					parent[m] = n;
					weight[n] = weight[m] + weight[n] + 1;
				}
			}
			else if (weight[n] < weight[m]) {
				parent[n] = m;
				weight[m] = weight[m] + weight[n] + 1;
			}
			else {
				parent[m] = n;
				weight[n] = weight[m] + weight[n] + 1;
			}
		}
		else if ((SimpleFind(i) != i || SimpleFind(j) != j) && SimpleFind(i) < SimpleFind(j)) {
			int m = SimpleFind(j);
			int n = SimpleFind(i);
			if (weight[m] == weight[n]) {
				if (m > n) {
					parent[n] = m;
					weight[m] = weight[m] + weight[n] + 1;
				}
				else {
					parent[m] = n;
					weight[n] = weight[m] + weight[n] + 1;
				}
			}
			else if (weight[n] < weight[m]) {
				parent[n] = m;
				weight[m] = weight[m] + weight[n] + 1;
			}
			else {
				parent[m] = n;
				weight[n] = weight[m] + weight[n] + 1;
			}
		}
		else if (SimpleFind(i) == SimpleFind(j)) { return false; }

		return true;
	}

	int SimpleFind(int i) { 
	// return the root node that contains the element i

		int root = i;
		
		while(true) {
			if (parent[root] != 0) {
				root = parent[root];
			}
			else { break; }
		}
	
		return root;
	}
}

