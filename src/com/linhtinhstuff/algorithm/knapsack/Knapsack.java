package com.linhtinhstuff.algorithm.knapsack;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Knapsack {
	
	public List<Item> knapsackRecursive(List<Item> list, int capacity) {
		return knapsackRecursive(list, list.size() - 1, capacity);
	}
	
	public List<Item> knapsackRecursive(List<Item> list, int position, int capacity) {
		if (position == -1 || capacity == 0) {
			return new ArrayList<Item>();
		}
		else if (list.get(position).getWeight() > capacity) {
			return knapsackRecursive(list, position - 1, capacity);
		}
		else {
			List<Item> tmp1 = knapsackRecursive(list, position - 1, capacity);
			
			Item item = list.get(position);
			List<Item> tmp2 = knapsackRecursive(list, position - 1, capacity - item.getWeight());
			tmp2.add(item);
			
			if(sumValue(tmp1) > sumValue(tmp2)) {
				return tmp1;
			}
			else {
				return tmp2;
			}
		}
	}
	
	public List<Item> knapsackDynamicPro(List<Item> list, int capacity) {
		List<Item> arr[][] = new ArrayList[list.size()][capacity + 1];
		return knapsackDynamicPro(list, list.size() - 1, capacity, arr);
	}
	
	public List<Item> knapsackDynamicPro(List<Item> list, int position, int capacity, List<Item> arr[][]) {
		if (position == -1 || capacity == 0) {
			return new ArrayList<Item>();
		}
		
		// If the array contains value -> return this value
		if (arr[position][capacity] != null) {
			return arr[position][capacity];
		}
		
		List<Item> result;
		if (list.get(position).getWeight() > capacity) {
			result = knapsackRecursive(list, position - 1, capacity);
		}
		else {
			List<Item> tmp1 = knapsackRecursive(list, position - 1, capacity);
			
			Item item = list.get(position);
			List<Item> tmp2 = knapsackRecursive(list, position - 1, capacity - item.getWeight());
			tmp2.add(item);
			
			if(sumValue(tmp1) > sumValue(tmp2)) {
				result = tmp1;
			}
			else {
				result = tmp2;
			}
		}
		
		// Cache the result into array
		arr[position][capacity] = result;
		return result;
	}
	
	private int sumValue(List<Item> items) {
		int sum = 0;
		for(Item item : items) {
			sum += item.getValue();
		}
		return sum;
	}
	
	@Test
	public void test() {
		List<Item> list = new ArrayList<>();
		list.add(new Item(1, 5));
		list.add(new Item(2, 3));
		list.add(new Item(4, 5));
		list.add(new Item(2, 3));
		list.add(new Item(5, 2));
		
		System.out.println(knapsackRecursive(list, 10).toString());
		System.out.println(knapsackDynamicPro(list, 10).toString());
	}

}
