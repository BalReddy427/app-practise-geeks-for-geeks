package test.activity_selection;

import java.util.Arrays;

public class TestActivitySelection {
	public static void main(String[] args) {
		int start[] = { 1, 3, 2, 5 };
		int end[] = { 2, 4, 3, 6 };
		int n = 4;
		int res = activitySelection(start, end, n);
		System.out.println(res);
	}

	public static int activitySelection(int start[], int end[], int n) {
		Activity arr[] = getActivityArray(start, end, n);
		int res = 1;
		Activity prev = arr[0];
		for(int i = 1;i<n;i++)
		{
			Activity curr = arr[i];
			if(curr.start>prev.finish)
			{
				res++;
				prev = curr;
			}
		}
		return res;
	}

	private static Activity[] getActivityArray(int[] start, int[] end, int n) {
		Activity[] arr = new Activity[n];
		for(int i= 0;i<n;i++)
		{
			arr[i] = new Activity(start[i], end[i]);
		}
		Arrays.sort(arr);
		return arr;
	}
}

class Activity implements Comparable<Activity> {
	int start;
	int finish;

	Activity(int s, int e) {
		start = s;
		finish = e;
	}

	@Override
	public int compareTo(Activity o) {
		return finish - o.finish;
	}
}
