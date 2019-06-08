package dataStructures;

public class LinkedList {

	Node head;
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			next=null;
		}
	}
	void printList() {
		Node n=head;
		while(n!=null) {
			System.out.print(n.data+" ");
			n=n.next;
		}
	}
	//in the starting
	public void push(int x) {
		Node newnode= new  Node(x);
		newnode.next=head;
		head=newnode;
	}
	// general case
	public void append(int x) {
		Node newnode=new Node(x);
		if(head==null) {
			head=newnode;
			return;
		}
		newnode.next=null;
		//else traverse the list
		Node last=head;
		while(last.next!=null) {
			last=last.next;
		}
		last.next=newnode;
		
	}
	public void insertAt(int index,int x) {
		Node newnode=new Node(x);
		if(index==0) {
			push(x);
		}
		else {
			Node n=head;
			for(int i=0;i<index;i++) {
				n=n.next;
			}
			newnode.next=n.next;
			n.next=newnode;
		}
	}
	// delete the first  occurrence of the key
	public void delete(int x) {
		Node prev = null;
		Node n= head;
		if(head==null) {
			return;
		}
		if(head.data==x) {
			head=head.next;
			return;
			
		}
		while(n.data!=x && n!=null) {
			prev =n;
			n=n.next;
			
		}
		if(n==null) {return;}
		prev.next=n.next;
		
	
		
	}
	// delete at a specific position starting from zero;
	public void deleteAt(int index) {
		Node prev=null;
		Node n=head;
		if(head==null) {
			return;
			
		}
		if(index==0) {
			head=head.next;
			return;
		}
		for(int i=0;i<index;i++) {
			prev=n;
			n=n.next;
			if(n==null) {
				return;
			}
			
		}
		
		
		prev.next=n.next;
	}
	// by automatic  garbage collection in java
	public void deleteAll() {
		head=null;
	}
	//recursive length calculation 
	public int length(Node head) {
		if(head==null) {
			return 0;
		}
		return 1+length(head.next);
		
	}
	//recursive search
	public  boolean search(Node head,int x) {
		if(head==null) {
			return false;
		}
		if(head.data==x) {
			return true;
		}
		return search(head.next,x);
	}
	// get nth  elementh fromm starting
	public  int getNth(Node head,int index) {
		int count=1;
		
			if(count==index) {
				return head.data;
			}
			
			return getNth(head.next,index-1);
			
		
	}
	// get the middle elemennt of the linked list
	public  int getMiddle(Node head)
	   {
	         Node temp=head;
	         int len=0;
	         while(temp!=null){
	             temp=temp.next;
	             len++;
	         }
	        
	             int i=len/2;
	             for(int j=0;j<i;j++){
	                 head=head.next;
	             }
	             return head.data;
	             
	         
	         
	   }
	
	// Occurrence of a key
	static int count;
	public static int frequency(Node node, int search)
	{
	    if(node==null){
	        return count;
	    }
	    if(node.data==search){
	        count++;
	    }
	    return frequency(node.next,search);
	}
	
	
	
	public static void main(String[] args) {
		LinkedList list =new LinkedList();
		list.head=new Node(1);
		Node second=new Node(2);
		Node third=new Node(3);
		list.head.next=second;
		second.next=third;
		list.insertAt(1, 5);
		list.insertAt(3, 8);
		list.insertAt(0, 4);
		list.append(9);
		list.append(9);
		list.append(9);
		list.insertAt(0,9);
		list.printList();
		list.delete(5);
		list.delete(9);
		System.out.println();
		list.printList();
		list.deleteAt(1);
		list.deleteAt(10);
		System.out.println();
		list.printList();
		System.out.println();
		System.out.println(list.length(list.head));
		if(list.search(list.head, 9)) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
		System.out.println(list.getNth(list.head,3));
		System.out.println(frequency(list.head,9));

	}
	

}





//

