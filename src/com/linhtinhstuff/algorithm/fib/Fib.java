package com.linhtinhstuff.algorithm.fib;

import static org.junit.Assert.*;

import org.junit.Test;

public class Fib {
	
	private int[] memo = new int[100];
	
	public int recurFib(int n) {
		if (n < 3) {
			return 1;
		}
		return recurFib(n - 1) + recurFib(n - 2);
	}
	
	public int dynamicFib(int n) {
		if (memo[n] != 0) {
			return memo[n];
		}
		
		int result;
		if (n < 3) {
			result = 1;
		}
		else {
			result = dynamicFib(n - 1) + dynamicFib(n - 2);
		}
		memo[n] = result;
		return result;
	}
	
	public int bottomUpFib(int n) {
		if (n < 3) {
			return 1;
		}
		
		memo[1] = 1;
		memo[2] = 1;
		for (int i = 3; i <= n; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		return memo[n];
	}
	
	@Test
	public void testRecurFib() throws Exception {
		long startTime = System.nanoTime();
		assertEquals(102334155, dynamicFib(40));
		long endTime = System.nanoTime();
		
		System.out.println("Recursive fibonaci");
		System.out.println(endTime - startTime);
	}
	
	@Test
	public void testDynamicFib() throws Exception {
		long startTime = System.nanoTime();
		assertEquals(102334155, dynamicFib(40));
		long endTime = System.nanoTime();
		
		System.out.println("Dynamic fibonaci");
		System.out.println(endTime - startTime);
	}
	
	@Test
	public void testBottomUpFib() throws Exception {
		long startTime = System.nanoTime();
		assertEquals(102334155, dynamicFib(40));
		long endTime = System.nanoTime();
		
		System.out.println("Bottom up fibonaci");
		System.out.println(endTime - startTime);
	}

}
