package test.fractional_knapsack;

import java.util.Arrays;

class Item {
	int value, weight;

	Item(int x, int y) {
		this.value = x;
		this.weight = y;
	}
}

public class TestFractionalKnapsack {
	public static void main(String[] args) {
		int values[] = {38,42,54,44,74,29,26,42,11,19,18,37,64,6,91,9,31,5,72,12,34,36,90,24,5,2,6,1,69,4,86,7,96,40,50,21,68,27,64,28,97,32,66,11,37,6,71};
		int weight[] = {19,12,43,33,47,80,22,71,35,73,28,35,41,84,23,99,31,64,48,51,31,74,15,60,23,48,25,83,36,33,5,55,44,99,37,41,29,60,13,63,34,42,49,24,25,73,23};
		int n = 47;
		int w = 36;

		Item[] arr = getItemArray(values, weight, n);
		double result = fractionalKnapsack(w, arr, n);
		System.out.println(result);
		
		
	}

	private static Item[] getItemArray(int[] values, int[] weight, int n) {
		Item[] arr = new Item[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Item(values[i], weight[i]);
		}
		return arr;
	}

	static double fractionalKnapsack(int W, Item arr[], int n) {
		arr = sortArrayByValueDensity(arr);
		double res = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i].weight <= W) {
				res = res + arr[i].value;
				W = W - arr[i].weight;
			} else {
				double remres = ((double)(arr[i].value * W)/ arr[i].weight) ;
				res = res + remres;
				return res;
		}
		}
		return res;
	}

	private static Item[] sortArrayByValueDensity(Item[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int base = arr[i].value / arr[i].weight;
			int swapIndex = -1;
			for (int j = i; j < arr.length; j++) {
				int curr = arr[j].value / arr[j].weight;
				if(curr>base)
				{
					swapIndex = j;
					base = curr;
				}
			}
			if(swapIndex>=0)
			{
				Item temp = arr[swapIndex];
				arr[swapIndex] = arr[i];
				arr[i] = temp;
			}
		}
		return arr;
	}
}
