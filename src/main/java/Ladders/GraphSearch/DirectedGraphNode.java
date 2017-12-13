package GraphSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class DirectedGraphNode {
	 public int label;
	 public ArrayList<DirectedGraphNode> neighbors;
	 public ArrayDeque<DirectedGraphNode> allVetex;
	 DirectedGraphNode(int x) {
	 label = x;
	 neighbors = new ArrayList<DirectedGraphNode>();
	 allVetex = new ArrayDeque<DirectedGraphNode>();
	}

};
