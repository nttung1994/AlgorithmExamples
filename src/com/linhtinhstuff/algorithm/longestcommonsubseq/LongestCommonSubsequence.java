package com.linhtinhstuff.algorithm.longestcommonsubseq;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonSubsequence {

	public String lcsRecursive(String p, String q) {
		return lcsRecursive(p, q, p.length() - 1, q.length() - 1);
	}

	public String lcsRecursive(String p, String q, int m, int n) {
		if (m < 0 || n < 0) {
			return "";
		} else if (p.charAt(m) == q.charAt(n)) {
			return lcsRecursive(p, q, m - 1, n - 1) + p.charAt(m);
		} else {
			String tmp1 = lcsRecursive(p, q, m - 1, n);
			String tmp2 = lcsRecursive(p, q, m, n - 1);
			if (tmp1.length() > tmp2.length()) {
				return tmp1;
			} else {
				return tmp2;
			}
		}
	}

	public String lcsDynamic(String p, String q) {
		String[][] arr = new String[p.length()][q.length()];
		return lcsDynamic(p, q, p.length() - 1, q.length() - 1, arr);
	}

	public String lcsDynamic(String p, String q, int m, int n, String[][] arr) {
		//If contain in array, return value
		if (arr[m][n] != null) {
			return arr[m][n];
		}

		String result = "";
		if (m >= 0 && n >= 0) {
			if (p.charAt(m) == q.charAt(n)) {
				result = lcsRecursive(p, q, m - 1, n - 1) + p.charAt(m);
			} else {
				String tmp1 = lcsRecursive(p, q, m - 1, n);
				String tmp2 = lcsRecursive(p, q, m, n - 1);
				if (tmp1.length() > tmp2.length()) {
					result = tmp1;
				} else {
					result = tmp2;
				}
			}
		}
		
		//Store result into array for using later 
		arr[m][n] = result;
		return result;
	}

	@Test
	public void testName() throws Exception {
		String s1 = "AABBCCAAAA";
		String s2 = "DDEEAAABB";
		assertEquals(lcsRecursive(s1, s2), "AABB");
		assertEquals(lcsDynamic(s1, s2), "AABB");
	}

}
