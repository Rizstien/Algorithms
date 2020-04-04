/*
 * Question 3: Edit Distance
Write a function that returns whether two words are exactly "one edit" away using the following signature:
bool OneEditApart(string s1, string s2);
An edit is:

    Inserting one character anywhere in the word (including at the beginning and end)
    Removing one character
    Replacing one character

Examples:
OneEditApart("cat", "dog") = false
OneEditApart("cat", "cats") = true
OneEditApart("cat", "cut") = true
OneEditApart("cat", "cast") = true
OneEditApart("cat", "at") = true
OneEditApart("cat", "act") = false

*/


package com.rizstiem.algos;

public class OneEditApart {

	static boolean oneEditApart(String s1, String s2) {
		int edits=0;
		if(s1.length()==s2.length()) {
			for(int i=0;i<s1.length();i++) {
				if(s1.charAt(i)!=s2.charAt(i)) edits++;
			}
			if(edits<2) return true;
		}else if(s1.length()==(s2.length()-1)) {
			if(s2.contains(s1)) {
				return true;
			}else {
				for(int i=0;i<s1.length();i++) {
					if(s1.charAt(i)!=s2.charAt(i)) edits++;
				}
				if(edits<2) return true;
			}
		}else if((s1.length()-1)==s2.length()) {
			if(s1.contains(s2)){
				return true;
			}else {
				for(int i=0;i<s2.length();i++) {
					if(s2.charAt(i)!=s1.charAt(i)) edits++;
				}
				if(edits<2) return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(oneEditApart("cat", "dog"));
		System.out.println(oneEditApart("cat", "cats"));
		System.out.println(oneEditApart("cat", "cut"));
		System.out.println(oneEditApart("cat", "cast"));
		System.out.println(oneEditApart("cat", "at"));
		System.out.println(oneEditApart("cat", "act"));

	}

}
