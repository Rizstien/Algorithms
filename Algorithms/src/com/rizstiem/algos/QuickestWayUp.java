package com.rizstiem.algos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class QuickestWayUp {

    static Map<Integer, Integer> snakes;
    static Map<Integer, Integer> ladders;
    static Map<Integer, Integer> visited;

    // Complete the quickestWayUp function below.
    static int quickestWayUp(Map<Integer, Integer> ladders, Map<Integer, Integer> snakes) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited = new HashMap<Integer, Integer>();
        visited.put(1,0);
        queue.add(1);
        while(!queue.isEmpty()){
            Integer element = queue.remove();
            if(element==100){
                return visited.get(100);
            }

            for(int i=1;i<=6;i++){
                Integer pos = i+element;
                if(ladders.containsKey(pos)){
                    pos=ladders.get(pos);
                }
                if(snakes.containsKey(pos)){
                    pos=snakes.get(pos);
                }

                if(visited.get(pos)==null){
                    visited.put(pos, visited.get(element)+1);
                    queue.add(pos);
                }else if(visited.get(element)+1 < visited.get(pos)){
                    visited.put(pos, visited.get(element+1));
                }
            }
        }

        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            ladders = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                String[] laddersRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                ladders.put(Integer.parseInt(laddersRowItems[0]), Integer.parseInt(laddersRowItems[1]));
            }

            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            snakes = new HashMap<Integer, Integer>();
            for (int i = 0; i < m; i++) {
                String[] snakesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                snakes.put(Integer.parseInt(snakesRowItems[0]), Integer.parseInt(snakesRowItems[1]));
            }

            int result = quickestWayUp(ladders, snakes);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}


