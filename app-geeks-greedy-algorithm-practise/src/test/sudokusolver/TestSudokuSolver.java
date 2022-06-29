package test.sudokusolver;

public class TestSudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{3,0,6,5,0,8,4,0,0},
		               {5,2,0,0,0,0,0,0,0},
		               {0,8,7,0,0,0,0,3,1,},
		               {0,0,3,0,1,0,0,8,0},
		               {9,0,0,8,6,3,0,0,5},
		               {0,5,0,0,9,0,6,0,0},
		               {1,3,0,0,0,0,2,5,0},
		               {0,0,0,0,0,0,0,7,4},
		               {0,0,5,2,0,6,3,0,0}};
		if(SolveSudoku(grid)==true)
		{
			printGrid(grid);
		}
		else
		{
			System.out.println("NO,solution exists");
		}
	}
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
    	//loop untill the zero value is reached
    	int i = 0;
    	int j = 0;
    	outerloop:
    	for(i = 0;i<9;i++)
    	{
    		for(j = 0;j<9;j++)
    		{
    			if(grid[i][j]==0)
    			{
    				break outerloop;
    			}
    		}
    	}
    	if(i==9 && j==9)
    	{
    		return true;
    	}
    	
    	for(int n = 1;n<=9;n++)
    	{
    		if(isCorrectFit(grid, i, j, n)==true)
    		{
    			grid[i][j] = n;
    			if (SolveSudoku(grid)==true)
    			{
    				return true;
    			}
    			else
    			{
    				grid[i][j] = 0;
    			}
    		}
    	}
        return false;
    }
    
    
    static boolean isCorrectFit(int grid[][],int i,int j,int n)
    {
    	for(int x = 0;x<9;x++)
    	{
    		if(grid[i][x]==n)
    		{
    			return false;
    		}
    		
    		if(grid[x][j]==n)
    		{
    			return false;
    		}
    	}
    	
    	int miniSquarex = (i/3)*3;
    	int miniSquarey = (j/3)*3;
    	for(int p = 0;p<3;p++)
    	{
    		for(int q = 0;q<3;q++)
    		{
    			if(grid[miniSquarex + p][miniSquarey + q]==n)
    			{
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int i = 0;i<9;i++)
        {
        	for(int j = 0;j<9;j++)
        	{
        		System.out.print(grid[i][j]);
        		System.out.print(" ");
        	}
        }
    }
}
