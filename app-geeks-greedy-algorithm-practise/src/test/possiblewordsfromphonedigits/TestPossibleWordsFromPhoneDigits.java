package test.possiblewordsfromphonedigits;

import java.util.ArrayList;
import java.util.Collections;

public class TestPossibleWordsFromPhoneDigits {

	public static void main(String[] args) {

		int a[] = {5,8,8,9,8};
		int N = a.length;
		ArrayList<String> result =   possibleWords(a,N);
		System.out.println(result);
	}
	static ArrayList<String> result = new ArrayList<String>();

    static ArrayList<String> possibleWords(int a[], int N)
    {
    	result.clear();
    	String arr[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz",""};
    	possibleWordsRec(arr,a,N,"",0);
    	Collections.sort(result);
    	return result;
    }
	private static void possibleWordsRec(String[] arr, int[] a, int N,String curr,int wordCount) 
	{
		if(curr.length()==N)
		{
			result.add(curr);
			return;
		}
		
		for(int i = 0;i<arr[a[wordCount]].length();i++)
		{
			possibleWordsRec(arr, a, N, curr+ arr[a[wordCount]].charAt(i), wordCount + 1);
		}

	}
}
