import java.util.*;

// offset
class offsets {
	int a, b;
	
	offsets(int x, int y) {
		a = x;
		b = y;
	}
};

/**
 * Maze Class
 * 
 */

class Maze {

	private int[][] maze;	// 2 dim array for maze
	private int[][] mark;	// 2 dim array for visit marking
	
	public Maze(int m, int p) {
		maze = new int[m + 2][p + 2];
		mark = new int[m + 2][p + 2];
		for(int i = 0; i < m + 2; i++) {
			for(int j = 0; j < p + 2; j++) {
				maze[i][j] = 1;
				mark[i][j] = 0;
			}
		}
	}

	// create the maze structure
	public void SetWall(int i, int j, int val) {
		maze[i][j] = val;
	}


	public void Path(int m, int p) {
		
		offsets[] move = {
				new offsets(1, 0), //S
				new offsets(1, -1), //SW
				new offsets(0, -1), //W
				new offsets(-1, -1), //NW
				new offsets(-1, 0), //N
				new offsets(-1, 1), //NE
				new offsets(0, 1), //E
				new offsets(1, 1) //SE
		};
		
		int x = 1;
		int y = 1;
		
		int[][] arr = new int[m*p+100][2];
		
		arr[0][0] = 1;
		arr[0][1] = 1;
		int point = 1;
		
		while(true) {
			int cnt = 0;
			
			for(int i = 0; i < 8; i++) {
				if(maze[x + move[i].a][y + move[i].b] == 0) {
					if(mark[x + move[i].a][y + move[i].b] == 0) {
						arr[point][0] = x + move[i].a;
						arr[point][1] = y + move[i].b;
						
						point++;
						mark[x + move[i].a][y + move[i].b] += 1;
						cnt = 1;
						break;
					}
				}
			}
			
			if (cnt == 0) {
				arr[point-1][0] = 0;
				arr[point-1][1] = 0;
				point--;
			}
			
			if(point == 0) {
				System.out.println("No path in the maze.");
				break;
			}
			
			if(point != 0) {
				x = arr[point-1][0];
				y = arr[point-1][1];
			}
			
			if(arr[point-1][0] == m && arr[point-1][1] == p) {
				break;
			}
		}
		
		for(int i = 0; i < point; i++) {
			System.out.println("(" + arr[i][0] + "," + arr[i][1] + ")");
		}
	}

}; 

