package test.sumofdigits;

import java.util.ArrayList;

public class TestSumOfDigits {

	public static void main(String[] args) {
//		int result = RecursivePower(2,0);
//		System.out.println(result);
		
		System.out.println(printAllSets("abcd"));
	}
	
    public static int sumOfDigits(int n)
    {
    	int sum = 0;
    	while(n>0)
    	{
    		sum = sum + (n % 10);
    		n = n /10;
    	}
        return sum;
    }
    
    public static int countDigits(int n)
    {
       int count = 0;
       while(n>0)
       {
    	   n = n /10;
    	   count++;
       }
       return count;
    }
    
    // complete the function
    public static int digitalRoot(int n)
    {
       if(n<10)
       {
    	   return n;
       }
      int sum =  n%10 + digitalRoot(n/10);
      return digitalRoot(sum);
    }
    
    static int RecursivePower(int n,int p)
    {
    	if(p==0)
    		return 1;
    	if(p==1)
    		return n;
    	return n * RecursivePower(n, p-1);
    }
    
    static ArrayList<String> printAllSets(String s)
    {
    	ArrayList<String> result = new ArrayList<String>();
    	StringBuilder str2 = new StringBuilder("");
    	int n = 0;
    	while(true)
    	{
    		int count = 0;
    		int i = n;
    		while(i>0)
    		{
    			if(i%2==1)
    			{
    				str2.append(s.charAt(count));
    			}
    			count++;
    			i = i /2;
    		}
    		result.add(str2.toString());
    		if(str2.toString().equals(s))
    		{
    			break;
    		}
    		str2 = new StringBuilder("");
    		n++;
    	}
    	return result;
    }
    
}
