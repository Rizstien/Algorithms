package com.rizstiem.algos;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BFS {
	static HashMap<Integer, Node> nodeLookUp = new HashMap<Integer, Node>();
    static class Node{
        int id;
        List<Node> adjecent = new LinkedList<Node>();
        Node(int id){
            this.id=id;
        }
    }
    static Node getNode(int id){
    	if(nodeLookUp.containsKey(id)) return nodeLookUp.get(id);
    	return new Node(id);
    }
    static void addEdge(int node, int child){
        Node n = getNode(node);
        Node c = getNode(child);
        n.adjecent.add(c);
        nodeLookUp.put(n.id, n);
    }
    
    static void bfs(int n, int m, int[][] edges, int s) {
    	nodeLookUp = new HashMap<Integer, Node>();
        for(int i=0;i<edges.length;i++){
            addEdge(edges[i][0],edges[i][1]);
        }

        int k=0;
        for(int i=1;i<=n;i++){
            if(i!=s){ 
                System.out.print(pathLengthBFS(s,i)+" ");
            }
        }
    }

    static int pathLengthBFS(int source, int destination){
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited  = new HashSet<Integer>();
        HashMap<Integer, Integer> nodeDepth  = new HashMap<Integer, Integer>();
        LinkedList<Node> nextToVisit = new LinkedList<Node>();
        nextToVisit.add(s);
        while(!nextToVisit.isEmpty()){
            Node node=nextToVisit.remove();
            if(node.id==d.id){
                return nodeDepth.get(node.id);
            }
            
            if(visited.contains(node.id)){
                continue;
            }
            visited.add(node.id);

            for(Node child : node.adjecent){
                nextToVisit.add(getNode(child.id));
                if(nodeDepth.get(child.id)==null)
                	nodeDepth.put(child.id, nodeDepth.get(node.id)==null?6:nodeDepth.get(node.id)+6);
            }
        }
        return -1;
    }
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * int[] pathLen = bfs(5, 4, new int[][] {{1,2},{1,3},{3,4},{1,4}},1);
	 * 
	 * Arrays.stream(pathLen).forEach(e->System.out.println(e)); }
	 */
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            bfs(n, m, edges, s);

			/*
			 * for (int i = 0; i < result.length; i++) {
			 * System.out.print((String.valueOf(result[i]))); System.out.print(" "); }
			 */
        }

        scanner.close();
    }
    

}
