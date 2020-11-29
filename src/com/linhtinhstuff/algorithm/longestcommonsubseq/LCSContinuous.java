package com.linhtinhstuff.algorithm.longestcommonsubseq;

import static org.junit.Assert.*;

import org.junit.Test;

public class LCSContinuous {

	public String LCSContinuousRecursive(String p, String q) {
		return LCSContinuousRecursive(p, q, p.length() - 1, q.length() - 1);
	}

	public String LCSContinuousRecursive(String p, String q, int n, int m) {
		if (n < 0 || m < 0) {
			return "";
		}

		if (p.charAt(n) == q.charAt(m)) {
			String remaining = LCSContinuousRecursive(p, q, n - 1, m - 1);
			if (!"".equals(remaining) && (remaining.charAt(remaining.length() - 1) == p.charAt(n - 1))
					&& (p.charAt(n - 1) == q.charAt(m - 1))) {
				return remaining + p.charAt(n);
			}
			else if (remaining.length() > 1) {
				return remaining;
			}
			else {
				return String.valueOf(p.charAt(n));
			}
		}
		else {
			String tmp1 = LCSContinuousRecursive(p, q, n, m - 1);
			String tmp2 = LCSContinuousRecursive(p, q, n - 1, m);
			if (tmp1.length() > tmp2.length()) {
				return tmp1;
			}
			return tmp2;
		}
	}
	
	@Test
	public void testName() throws Exception {
		String s1 = "TABCDEFG";
		String s2 = "HKLMABCTD";
		assertEquals(LCSContinuousRecursive(s1, s2), "ABC");
	}

}
