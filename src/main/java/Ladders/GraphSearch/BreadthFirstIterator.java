package GraphSearch;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
/*
 * DFS and BFS are two different strategies for accomplishing a similar task.
 * Therefore, they should be implemented in two classes with a shared interface.
 * I suggest an Iterator<String>.
 * The breadth-first iterator is a pretty straightforward translation of your original code,
 * with the main difference being that 
 * the iterator is now responsible for keeping track of which vertices have been visited
 * */


public class BreadthFirstIterator implements Iterator<String>{
	private Set<String> visited = new HashSet<String>();
	private Queue<String> queue = new LinkedList<String>();
	private Graph grap;
	public BreadthFirstIterator(Graph g, String startingVertex) {
		
		this.visited.add(startingVertex);
		this.queue.add(startingVertex); 
		this.grap = g;
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean hasNext() {
		return !this.queue.isEmpty();
	}
	
	@Override
	public String next() {
		// removes from front of queue
		String next = queue.remove();
		for (String neighbour : this.grap.getNeighbors(next)) {
			if (!this.visited.contains(neighbour)){
				this.queue.add(neighbour);
				this.visited.add(neighbour);
			}
		}
		
		return next;
	}
	
	

}
