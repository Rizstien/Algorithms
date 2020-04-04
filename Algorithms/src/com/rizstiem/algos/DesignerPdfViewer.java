package com.rizstiem.algos;

import java.io.IOException;
import java.util.Scanner;

public class DesignerPdfViewer {

	static int designerPdfViewer(int[] h, String word) {
        int charHeight;
        int maxHeight=Integer.MIN_VALUE;
        for(int i=0;i<word.length();i++){
            charHeight = h[word.codePointAt(i)-97];
            maxHeight = Math.max(maxHeight,charHeight);
        }
        return (word.length())*maxHeight;
    }
	
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int[] h = new int[]{1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        //int[] h = new int[26];

        //String[] hItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		/*
		 * for (int i = 0; i < 26; i++) { int hItem = Integer.parseInt(hItems[i]); h[i]
		 * = hItem; }
		 */

        //String word = scanner.nextLine();

        int result = designerPdfViewer(h, "abc");
        

		/*
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 */

        //scanner.close();
	}

}
