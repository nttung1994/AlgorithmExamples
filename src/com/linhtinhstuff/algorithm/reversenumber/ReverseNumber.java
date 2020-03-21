package com.linhtinhstuff.algorithm.reversenumber;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseNumber {
	
	public int reverse(int n) {
		int result = 0;
		int digit = 0;
		while(n != 0) {
			digit = n % 10;
			result = result * 10 + digit;
			n = n/10;
		}
		return result;
	}
	
	@Test
	public void testReverseNumber() throws Exception {
		assertEquals(4321, reverse(1234));
		assertEquals(-4321, reverse(-1234));
	}

}
