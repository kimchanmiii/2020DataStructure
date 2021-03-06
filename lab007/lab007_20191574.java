import java.util.*;

// ---------- Graph class -------------

class Graph {
    int numofnodes;  // the number of nodes in the graph
    private int[][] AdjMatrix; // Adjacency matrix
    private int[] visited; // mark the visitied node


    Graph() {
        // Graph constructor. 
        numofnodes = 0;
    }

    void Init(int n) {
        numofnodes = n;
        // now create 2 dimensional array of numofnodes * numofnodes
        AdjMatrix = new int[numofnodes][numofnodes];
        for(int i = 0; i < numofnodes; i++) {
            // initialize all entries to 0
            for(int j = 0; j < numofnodes; j++)
                AdjMatrix[i][j] = 0;  // initialize the adjacency matrix
        }

    }


	void Edge(int n1, int n2) { 
		this.AdjMatrix[n1][n2] = 1;
		this.AdjMatrix[n2][n1] = 1;

	}

	void Bfs(int v) { 
		Queue<Integer> q = new LinkedList<>();
				
		visited = new int[numofnodes];
		
		for (int i = 0; i < numofnodes; i++) {
			visited[i] = 0;
		}
		q.add(v);
		visited[v] = 1;
		
		while (!q.isEmpty()) {
			int pulled = q.poll();
			System.out.print(pulled + "-");
			
			for (int i = 0; i < numofnodes; i++) {
				if (AdjMatrix[pulled][i] == 1 && visited[i] != 1) {
					q.add(i);
					visited[i] = 1;
				}
			}
		}

	}

}

