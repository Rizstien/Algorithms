package com.rizstiem.algos;

import java.util.HashSet;
import java.util.Set;

public class ColorFullNumbers {

	static boolean isColorFull(int number) {
		String numStr = String.valueOf(number);
		int length = numStr.length();
		Set set = new HashSet<Integer>();
		for(int cmb=1;cmb<length;cmb++) {
			for(int i=0;i<length-cmb+1;i++) {
				String num = numStr.substring(i, cmb+i);
				if(num.length()==1) {
					if(!set.contains(Integer.valueOf(num))) {
						set.add(Integer.valueOf(num));
					}else {
						return false;
					}
				}else {
					int sublength = num.length();
					int prod=1;
					for(int j=0;j<sublength;j++) {
						prod*=Character.getNumericValue(num.charAt(j));
					}
					if(!set.contains(prod)) {
						set.add(prod);
					}else {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isColorFull(3245));

	}

}
