package test.string_permutations;

public class TestStringPermutations {

	public static void main(String[] args) {
		String str1 = "abcd";
		permute(str1,0);
	}

	private static void permute(String s, int i) 
	{
		if(i==s.length()-1)
		{
			System.out.println(s);
			return;
		}
		for(int j = i;j<s.length();j++)
		{
			s = swap(s,i,j);
			permute(s, i+1);
			s = swap(s,i,j);
		}
	}

	private static String swap(String s, int i, int j) 
	{
		char [] charr = s.toCharArray();
		char temp = charr[i];
		charr[i] = charr[j];
		charr[j] = temp;
		return String.valueOf(charr);
	}

}
