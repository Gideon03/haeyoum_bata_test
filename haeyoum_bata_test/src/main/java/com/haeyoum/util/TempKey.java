package com.haeyoum.util;

public class TempKey {
	private char[] codeSet = new char[] { 
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z',
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z'};

	public String getKeyCode(int codeLength) {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0 ; i < codeLength ; i++) {
			// 62 * 생성된 난수를 Int로 추출 (소숫점제거)
			int idx = (int) (codeSet.length * Math.random());
			sb.append(codeSet[idx]);
		}
		return sb.toString();
	}
}
