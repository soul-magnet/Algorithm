package dataStructure.hashTable;



public class Rehashing {
	/*
	 * @param hashTable: A list of the first node of linked list
	 * @return: A list of the first node of linked list which have twice size*/
	public ListNode[] rehashing(ListNode[] hashTable) {
		if (hashTable == null || hashTable.length == 0){
			return hashTable;
		}
		
		int size = hashTable.length * 2;
		ListNode[] newTable = new ListNode[size];
		
		for (int i = 0; i < hashTable.length; i++) {
			ListNode curNode = hashTable[i];
			while (curNode != null) {
				int val = curNode.val;
				if (val >= 0){
					insert(newTable, val % size, val);
				} else {
					insert(newTable, (val % size + size)% size, val);
				}
				curNode = curNode.next;
			}
			
		}
		
		return newTable;
	}
	
	private void insert(ListNode[] newTable, int i, int v) {
		if (newTable[i] == null) {
			newTable[i] = new ListNode(v);
		} else {
			ListNode head = newTable[i];
			while(head.next != null) {
				head = head.next;
			}
			head.next = new ListNode(v);
		}
	}
}
