package GraphSearch;

import java.util.ArrayList;

public class UndirectedGraphNode {
	int label;
	public ArrayList<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { 
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
		
	}
}
