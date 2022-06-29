package test.ratnmaze;

public class TestRatNMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 6;
		int maze[][] = {{2,2,2,1,0,3},{2,3,3,0,3,2},
				{3,0,4,3,2,2},{4,1,2,0,2,1},{1,1,1,3,0,3},{3,4,2,0,1,4}};
		solve(maze, N);
	}
	
    public static void solve(int[][] maze, int N)
    {
    	int sol[][] = new int[N][N];
        if(solveMazeRec(maze,0,0,sol,N)==false)
        {
        	System.out.println("-1");
        }
        else
        {
        	printMatrix(sol,N);
        }
    }

	private static boolean solveMazeRec(int[][] maze, int i, int j, int[][] sol,int N) 
	{
		if(i==N-1 && j==N-1)
		{
			sol[i][j]=1;
			return true;
		}
		
		if(isSafe(maze,i,j, N))
		{
			sol[i][j]=1;
			int maxSteps = maze[i][j];
			for(int s = 1;s<=maxSteps;s++)
			{
				if(solveMazeRec(maze, i, j+s, sol, N) == true)
					return true;
				if(solveMazeRec(maze, i+s, j, sol, N)==true)
					return true;
			}
			sol[i][j]=0;
		}
		
		return false;
	}

	private static boolean isSafe(int[][] maze, int i, int j, int N) 
	{
		if(i<N && j<N && maze[i][j]>0)
			return true;
		return false;
	}

	private static void printMatrix(int[][] sol, int N) {
		for(int i = 0;i<N;i++)
		{
			for(int j = 0;j<N;j++)
			{
				System.out.print(sol[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

}
