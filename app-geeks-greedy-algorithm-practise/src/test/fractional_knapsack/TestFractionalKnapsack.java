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
//		int values[] = { 60, 100, 120 };
//		int weight[] = { 10, 20, 30 };
//		int n = 3;
//		int w = 50;
//
//		Item[] arr = getItemArray(values, weight, n);
//		double result = fractionalKnapsack(w, arr, n);
//		System.out.println(result);
		
		
		
		int x = 60;
		int y = 20;
		int z = 13;
		double res;
		res = x/(double)z ;
		res = (double) Math.round(res * 100) / 100;
		System.out.println(res);
		
		
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
				res = res + (arr[i].value / arr[i].weight) * W;
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
