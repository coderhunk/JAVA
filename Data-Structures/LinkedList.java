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
	// detect loop using floyd cycle algo
	public int detectLoop(Node head) {
        if(head==null){
            return 0;
        }
        Node slow_p=head;
        Node fast_p=head;
        while(fast_p!=null && fast_p.next!=null && slow_p!=null){
            slow_p=slow_p.next;
            fast_p=fast_p.next.next;
            if(slow_p==fast_p){
                return 1;
            }
        }
        return 0;
    }
	//rotate a link list
	public void rotate(int k) 
    { 
        if (k == 0) return; 
        int len=length(head);
        if(k>len) {
        	k=k%len;
        }
  
         
        Node current  = head; 
  
        
        int count = 1; 
        while (count < k && current !=  null) 
        { 
            current = current.next; 
            count++; 
        } 
  
         
        if (current == null) 
            return; 
  
        
        Node kthNode = current; 
  
        
        while (current.next != null) 
            current = current.next; 
  
        
        current.next = head; 
  
        // Change head to (k+1)th node 
        
        head = kthNode.next; 
  
        // change next of kth node to null 
        kthNode.next = null; 
  
    }
	//reverse  link list
	public void reverse() {
		Node curr=head;
		Node prev=null;
		Node next=null;
		while(curr!=null) {
			next=curr.next;
			//reversing happens now
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;
	}
	//reverse a linked list in group of given size
	Node reverse(Node head, int k) 
    { 
       Node current = head; 
       Node next = null; 
       Node prev = null; 
         
       int count = 0; 
  
       /* Reverse first k nodes of linked list */
       while (count < k && current != null)  
       { 
           next = current.next; 
           current.next = prev; 
           prev = current; 
           current = next; 
           count++; 
       } 
  
       /* next is now a pointer to (k+1)th node  
          Recursively call for the list starting from current. 
          And make rest of the list as next of first node */
       if (next != null)  
          head.next = reverse(next, k); 
  
       // prev is now head of input list 
       return prev; 
    }  
	//check if palindrome  using stack
	boolean isPalindrome(Node head) 
    {
      
        Node temp=head;
        boolean flag=true;
        Stack<Integer> s=new Stack<Integer>();
        while(temp!=null){
            s.push(temp.data);
            temp=temp.next;
        }
        while(head!=null){
            int p=s.pop();
            if(head.data!=p){
                flag=false;
            }
            head=head.next;
        }
        return flag;
        
    }    
	//remove a loop in linked list
	public static void removeTheLoop(Node head)
    {
        Node slow=head;
        Node fast=head;
        while(slow!=null && fast!=null  && fast.next!=null){
         slow=slow.next;
         fast=fast.next.next;
         if(slow==fast){
             Node ptr1=slow;
             Node ptr2=slow;
             int k=1;
             while(ptr2.next!=ptr1){
                 ptr2=ptr2.next;
                 k++;
                 
             }
             ptr1=head;
             ptr2=head;
             for(int i=0;i<k;i++){
                 ptr2=ptr2.next;
             }
             while(ptr1!=ptr2){
                 ptr1=ptr1.next;
                 ptr2=ptr2.next;
             }
             while(ptr2.next!=ptr1){
                 ptr2=ptr2.next;
             }
             ptr2.next=null;
             return;
             
         }
        }
        
    
    }
	//intersection point of two linked list
	int intersectPoint(Node headA, Node headB)
	{
         Node temp1=headA;
         Node temp2=headB;
         int len1=0;
         int len2=0;
         while(temp1!=null){
             len1++;
             temp1=temp1.next;
         }
         while(temp2!=null){
             len2++;
             temp2=temp2.next;
         }
         int d=Math.abs(len1-len2);
         Node max=(len1>=len2)?headA:headB; 
         Node min=(len2<=len1)?headB:headA;
         for(int i=0;i<d;i++){
             max=max.next;
             
         }
         while(max!=min){
             max=max.next;
             min=min.next;
         }
         return max.data;
         
	}
	//merge 2 sorted list
	Node sortedMerge(Node headA, Node headB) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method
	     if(headA==null) return headB;
	     if(headB==null) return headA;
	     if(headA.data<headB.data){
	         headA.next=sortedMerge(headA.next,headB);
	         return headA;
	     }
	     else{
	         headB.next=sortedMerge(headA,headB.next);
	         return headB;
	     }
	     } 
	//seperate 1 . 0 and 2s
	static Node segregate(Node head)
    {
        if(head==null || head.next==null) 
        { 
            return head; 
        } 
         
        Node zeroD = new Node(0);  
        Node oneD = new Node(0);  
        Node twoD = new Node(0);  
  
        
        Node zero = zeroD, one = oneD, two = twoD;  
         
        Node curr = head;  
        while (curr!=null)  
        {  
            if (curr.data == 0)  
            {  
                zero.next = curr;  
                zero = zero.next;  
                curr = curr.next;  
            } 
            else if (curr.data == 1)  
            {  
                one.next = curr;  
                one = one.next;  
                curr = curr.next;  
            }  
            else 
            {  
                two.next = curr;  
                two = two.next;  
                curr = curr.next;  
            }  
        } 
        // Attach three lists  
        zero.next = (oneD.next!=null) ? (oneD.next) : (twoD.next);  
        one.next = twoD.next;  
        two.next = null; 
        // Updated head  
        head = zeroD.next; 
        return head; 
    }
	//swap pairwise data
	public static Node pairwise_swap(Node node)
    {
        // your code here
        Node temp1=node;
        Node temp2=node.next;
        int temp=0;
        
        while(temp1!=null && temp1.next!=null ){
        
            temp=temp1.data;
            temp1.data=temp1.next.data;
            temp1.next.data=temp;
            temp1=temp1.next.next;
            
            
            
        }
        return node;
    }
	//add two  linked list as numbers
	/* Adds contents of two linked lists and return the head node of resultant list */
	Node addTwoLists(Node first, Node second) { 
		Node res = null; // res is head node of the resultant list 
		Node prev = null; 
		Node temp = null; 
		int carry = 0, sum; 

		while (first != null || second != null) //while both lists exist 
		{ 
			// Calculate value of next digit in resultant list. 
			// The next digit is sum of following things 
			// (i) Carry 
			// (ii) Next digit of first list (if there is a next digit) 
			// (ii) Next digit of second list (if there is a next digit) 
			sum = carry + (first != null ? first.data : 0) 
					+ (second != null ? second.data : 0); 

			// update carry for next calulation 
			carry = (sum >= 10) ? 1 : 0; 

			// update sum if it is greater than 10 
			sum = sum % 10; 

			// Create a new node with sum as data 
			temp = new Node(sum); 

			// if this is the first node then set it as head of 
			// the resultant list 
			if (res == null) { 
				res = temp; 
			} else // If this is not the first node then connect it to the rest. 
			{ 
				prev.next = temp; 
			} 

			// Set prev for next insertion 
			prev = temp; 

			// Move first and second pointers to next nodes 
			if (first != null) { 
				first = first.next; 
			} 
			if (second != null) { 
				second = second.next; 
			} 
		} 

		if (carry > 0) { 
			temp.next = new Node(carry); 
		} 

		// return head of the resultant list 
		return res; 
	} 
	//delete a node without head pointer and only node reference
	public void deleteNode(Node node)
    {
         // Your code here
         Node temp=node;
         Node prev=node;
         
         while(temp.next!=null){
             temp.data=temp.next.data;
             prev=temp;
             temp=temp.next;
             
         }
         prev.next=null;
         
    }
	//Flattening a Linked List 
	Node flatten(Node root)
    {
	if(root==null || root.next==null){
	    return root;
	}
	root.next=flatten(root.next);
	root=sortedMerge(root,root.next);
	return root;
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
		list.rotate(3);
		list.printList();
		
		


	}
	

}






