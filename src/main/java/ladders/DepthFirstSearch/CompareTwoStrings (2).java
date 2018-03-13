package main.java.ladders.LinkedList;

import java.util.LinkedList;

/** GeeksfirGeeks - LinkedList Basics
 * Given two linked-list, represented as linkedList every character is a node in linked list. Write a function 
 * compare() that works similar to strcmp(), i.e., it return 0 if both strings are the same, 1 if first linked list
 * is lexicographically greater, and -1 if second string is lexicographically greater.
 * 
 * Examples:

Input: list1 = g->e->e->k->s->a
       list2 = g->e->e->k->s->b
Output: -1

Input: list1 = g->e->e->k->s->a
       list2 = g->e->e->k->s
Output: 1

Input: list1 = g->e->e->k->s
       list2 = g->e->e->k->s
Output: 0
 * 
 * */
public class CompareTwoStrings {
	Node head; //head of list
	static Node a, b;
	
	static class Node {
		char data;
		Node next;
		
		//constructor to create a new node
		Node(char n){
			data = n;
			next = null;
		}
	}
	
	int compare(Node node1, Node node2){
		if(node1 == null && node2 == null) return -1;
		
		while (node1 != null && node2 != null && node1.data == node2.data) { //for the integer same thing put into the tempList
			node1 = node1.next;
			node2 = node2.next;
        }
		
		//if the list are different in size
		if(node1 != null && node2 != null){
			return(node1.data > node2.data ? 1 : -1);
		}
		
		//f either of the list has reached end
		if(node1 != null && node2 == null) return 1;
		
		if(node1 == null && node2 != null) return -1;
		
		return 0;
	}
	
	public static void main(String[] args) {
		 
        LinkedList<Character> list = new LinkedList();
        Node result = null;
 
        list.a = new Node('g');
        list.a.next = new Node('e');
        list.a.next.next = new Node('e');
        list.a.next.next.next = new Node('k');
        list.a.next.next.next.next = new Node('s');
        list.a.next.next.next.next.next = new Node('b');
 
        list.b = new Node('g');
        list.b.next = new Node('e');
        list.b.next.next = new Node('e');
        list.b.next.next.next = new Node('k');
        list.b.next.next.next.next = new Node('s');
        list.b.next.next.next.next.next = new Node('a');
 
        int value;
        value = list.compare(a, b);
        System.out.println(value);
 
    }

}
