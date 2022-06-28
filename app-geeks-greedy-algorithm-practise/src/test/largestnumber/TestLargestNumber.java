package test.largestnumber;

public class TestLargestNumber
{
	public static void main(String[] args)
	{
		String result = largestNumber(5, 12);
		System.out.println(result);
	}
	
    static String largestNumber(int n, int sum)
    {
       StringBuilder result = new StringBuilder("");
       int maxNum = 9;
       while(n>0)
       {
    	   if(sum<maxNum)
    	   {
    		   maxNum--;
    		   continue;
    	   }
    	   else
    	   {
    		   result.append(maxNum);
    		   sum = sum - maxNum;
    		   n--;
    	   }
       }
       if(sum!=0)
    	   return "-1";
       return result.toString(); 
       
//       
//       for(int i=9;i>0 && n>0 ;i--)
//       {
//    	   int maxTimes = sum/i;
//    	   for(int j = 1;j<=maxTimes && n>0;j++)
//    	   {
//    		   result = result + String.valueOf(i);
//    		   sum = sum - i;
//    		   n--;
//    	   }
//       }
//       for(;n>0;n--)
//       {
//		   result = result + String.valueOf("0");
//       }
//       if(sum!=0)
//    	   return "-1";
//       return result;
    }
}
