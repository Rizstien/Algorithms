	/*		
	 * 
	 * Find Avg of node values at each level of tree
		 *  6
		   / \
		  4	  7
		 / \   \
		5   8   9
	       / \  /    
	      3   2 1
	      		 \
	      		  8
	      		  
	 {0:6, 1:5, 2:7, 3:2, 4:8}
	 |
	*/ 





import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node{
	
	Node(Integer val, Node left, Node right){
		this.val=val;
		this.left=left;
		this.right=right;
	}
	
	Integer val;
	Node left;
	Node right;
}


public class TreeLevelAvg {
	
	static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	private static void collect(Node node, int level) {
		if(node==null) return;
		
		List arrList;
		if(map.containsKey(level)) {
			map.get(level).add(node.val);
		}else {
			arrList = new ArrayList<Integer>();
			arrList.add(node.val);
			map.put(level, arrList);
		}
		
		collect(node.left, level+1);
		collect(node.right, level+1);
	}
	
	private static void printAvgLevel() {
		for(int i=0;i<map.size();i++) {
			System.out.println("Avg at level "+i+" : "+sum(map.get(i))/map.get(i).size());
		}
	}
	
	private static Integer sum(List<Integer> list) {
		Integer sum=0;
		for(int i=0;i<list.size();i++) {
			sum+=list.get(i);
		}
		return sum;
	}
	
	public static void main(String[] args) {

		Node tree = new Node(6, 
				new Node(4, 
						new Node(5, null, null), 
						new Node(8, 
								new Node(3, null, null), 
								new Node(2, null, null))),
				new Node(7, 
						null, 
						new Node(9, 
								new Node(1, 
										null, 
										new Node(8, null, null)), 
								null)));
		
		
		collect(tree, 0);
		printAvgLevel();
	}

}
