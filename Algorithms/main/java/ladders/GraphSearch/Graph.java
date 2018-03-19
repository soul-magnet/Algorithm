package GraphSearch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// DFS and BFS are two different strategies to accomplish a similar task
// Therefore there should be implemented in two classes with a shared interface.
// I suggest an Iterator<String>
public class Graph<T> {
	// Alternatively, use a Multimap:
    // http://google-collections.googlecode.com/svn/trunk/javadoc/com/google/common/collect/Multimap.html
	
	/*private Map<String,List<String>> edges = new HashMap<String, List<String>>();
	
	public void addEdge(String src, String dest) {
		List<String> srcNeighbors = this.edges.get(src);
		if (srcNeighbors == null){
			this.edges.put(src, srcNeighbors = new ArrayList<String>()
					);
		}
		srcNeighbors.add(dest);
	}
	
	// With Iterator Caller can decide what to do with each node
	public Iterable<String> getNeighbors(String vertex) {
		List<String> neighbors = this.edges.get(vertex);
		if (neighbors == null) {
			return Collections.emptyList();
		} else {
			return Collections.unmodifiableList(neighbors);
		}
	}*/
	
	private List <Edge<T>> allEdges;
	private Map<Long, Vertex<T>> allVertex;
	boolean isDirected = false;
	
	public Graph (boolean isDirected){
		allEdges = new ArrayList<Edge<T>>();
		allVertex = new HashMap<Long, Vertex<T>>();
		this.isDirected = isDirected;
	}
	
	public void addEdge(long id1, long id2){
		addEdge(id1, id2, 0);
	}
	
	// This works only for directed graph because for undirected graph 
	// we can end up adding edges two times to allEdges
	public void addVertex(Vertex<T> vertex) {
		if(allVertex.containsKey(vertex.getId())) {
			return;
		}
		allVertex.put(vertex.getId(), vertex);
		for(Edge<T> edge : vertex.getEdges()){
			allEdges.add(edge);
		}
	}
	
	public Vertex<T> addSingleVertex(long id) {
		if (allVertex.containsKey(id)){
			return allVertex.get(id);
		}
		
		Vertex<T> v = new Vertex<T>(id);
		allVertex.put(id, v);
		return v;
	}
	
	public Vertex<T> getVertex(long id){
		return allVertex.get(id);
	}
	
	public void addEdge(long id1, long id2, int weight){
		Vertex<T> vertex1 = null;
		if (allVertex.containsKey(id1)){
			vertex1 = new Vertex<T>(id1);
		} else {
			vertex1 = new Vertex<T>(id1);
			allVertex.put(id1, vertex1);
		}
		
		Vertex<T> vertex2 = null;
		if(allVertex.containsKey(id2)){
			vertex2 = allVertex.get(id2);
		} else{
			vertex2 = new Vertex<T>(id2);
			allVertex.put(id2, vertex2);
		}
		
		Edge<T> edge = new Edge<T>(vertex1, vertex2, isDirected, weight);
		allEdges.add(edge);
		vertex1.addAdjacentVertex(edge, vertex2);
		if (!isDirected){
			vertex2.addAdjacentVertex(edge, vertex1);}
		}
		
		public List<Edge<T>> getAllEdges(){
	        return allEdges;
	    }
	    
	    public Collection<Vertex<T>> getAllVertex(){
	        return allVertex.values();
	    }
	    public void setDataForVertex(long id, T data){
	        if(allVertex.containsKey(id)){
	            Vertex<T> vertex = allVertex.get(id);
	            vertex.setData(data);
	        }
	}

}

class Vertex<T> {
	long id;
	private T data;
	private List<Edge<T>> edges = new ArrayList<Edge<T>>();
	private List<Vertex<T>> adjacentVertex = new ArrayList<Vertex<T>>();
	
	Vertex(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
		edges.add(e);
		adjacentVertex.add(v);
	}
	
	 public List<Vertex<T>> getAdjacentVertexes(){
	        return adjacentVertex;
	        
	 }
	 
	@Override
	public String toString() {
		return String.valueOf(id);
	}
	
	public List<Edge<T>> getEdges() {
		return edges;
	}
	
	public int getDegree() {
		return edges.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}

class Edge<T> {
	private boolean isDirected = false;
	private Vertex<T> vertex1;
	private Vertex<T> vertex2;
	private int weight;
	
	Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}
	
	Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected,int weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.isDirected = isDirected;
    }
	
	Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.isDirected = isDirected;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public Vertex<T> getVertex1() {
		return vertex1;
	}

	public Vertex<T> getVertex2() {
		return vertex2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
		result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (vertex1 == null) {
			if (other.vertex1 != null)
				return false;
		} else if (!vertex1.equals(other.vertex1))
			return false;
		if (vertex2 == null) {
			if (other.vertex2 != null)
				return false;
		} else if (!vertex2.equals(other.vertex2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1 + ", vertex2=" + vertex2 + ", weight=" + weight
				+ "]";
	}
	
}
