package main.java.ladders.UnionFind;
/**
 * Given a graph G = (V, E) we want to find a Minimum SPanning Tree in the graph(it may not be unique).
 * A minimum Spanning Tree is a subset of the edges which connects all vertices 
 * in the graph with the minimal total cost.
 * 
 * Thoughts: 
 * 1st Sort edges by ascending edge weight
 * 2nd Walk through the sorted edges and look at the two nodes the edge belongs to, 
 *     if the nodes are already unified we don't include this edge, otherwise we include it & unify the nodes
 *     
 * 3rd The algorithm terminates when every edge has been processed or all the vertices have been unified.
 * 
 *-- Creating Union Find --
 *1st - To begin using Union Find, first construct a bijection (a mapping) between your objects and 
 *  the integers in the range [0, n) - like assigning to each node an index and storing in hash table so we can do look up 
 *  Note: This step is not necessary in general, but it will allow us to construct an array-based union find
 *  
 * 2nd - create a corolation between the nodes, creating graph
 * 
 * Find Operation: To fin which component a particular element belongs to  find the root of that component
 * by following the parent nodes until a self loop is reached(a node who's parent is itself)
 * 
 * Union Operation: To unify two elements find which are the root nodes of each component and if the root nodes
 * are different make one of the root nodes be the parent of the other
 * 
 * Remarks: In this data structure, we do not "un-union" elements. In general, this would be very inefficient
 * to do since we could have to update all the children node.
 * 
 * The number of components is equal to the number of roots remainig, Also, remark that the number of root nodes
 * never increases.
 * 
 * Path Compression:
 *  
 *  Time Complexity: Amortized Time Complexity, with the help of path compression
 * */
public class KruskalMinimumSpanningTree {

}
