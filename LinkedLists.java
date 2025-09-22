// class of Node 

public class Node {
    
    int data ; 
    Node next ; 
    
    Node(int data ){
        
        this.data  = data ; 
        this.next = null ; 
    }
    
    // Function to insert a Node at the front 
    
    public static  Node InsertAtFront (Node head , int x ){

    Node newNode = new Node(x);
    newNode.next = head ; 
    return newNode ; 
    }
    
    // Function Display LinkedList 
    
    public static void DisplayLL(Node head ){
        
        Node curr = head ; 
    
        while (curr != null){
            
            System.out.print(curr.data);
            
            if (curr.next != null){
                
                System.out.print("-->");
            }
                curr = curr.next ; 
           
        }
        
    }
    
    // Function to insert at the End 
    public static Node InsertAtEnd (Node head , int x ){
        
        Node curr = head ; 
        Node NewNode = new Node(x); 
        while (curr.next != null){
            curr = curr.next ; 
        }
        curr.next = NewNode ; 
        NewNode.next = null ; 
        return head;
        
    }
    
    
    // Function to reverse list 
    // Function to reverse the list using an array
public static Node Reverse(Node head) {
    if (head == null || head.next == null) {
        return head;
    }

    // Step 1: Count length
    int leng = 0;
    Node curr = head;
    while (curr != null) {
        curr = curr.next;
        leng++;
    }

    // Step 2: Copy values into array
    int[] a = new int[leng];
    curr = head;
    int i = 0;
    while (curr != null) {
        a[i] = curr.data;
        curr = curr.next;
        i++;
    }

    // Step 3: Refill list with reversed values
    curr = head;
    int j = leng - 1;
    while (curr != null) {
        curr.data = a[j];
        j--;
        curr = curr.next;
    }

    return head;
}



/* Function to practice this concept : Given a Singly linked list. The task is to modify the value of the first half of nodes such that 1st node's new value is equal to the value of the last node minus the first node's current value, 2nd node's new value is equal to the second last node's value minus 2nd nodes current value, likewise for first half nodes, then replace the second half of nodes with the initial values of the first half of nodes (values before modifying the nodes).

Note: If the size of it is odd then the value of the middle node remains unchanged.

Examples:

Input: head: 10 -> 4 -> 5 -> 3 -> 6
Output: -4 -> -1 -> 5 -> 4 -> 10 */

public static Node updating(Node head) {
    if (head == null || head.next == null) return head;

    // Step 1: Count length
    int leng = 0;
    Node temp = head;
    while (temp != null) {
        temp = temp.next;
        leng++;
    }

    // Step 2: Copy values into array
    int[] a = new int[leng];
    temp = head;
    int i = 0;
    while (temp != null) {
        a[i] = temp.data;
        temp = temp.next;
        i++;
    }

    // Step 3: Modify first half
    int k = leng / 2;
    int j = leng - 1;
    Node curr = head;
    i = 0;
    while (i < k) {
        curr.data = a[j] - a[i];
        j--;
        curr = curr.next;
        i++;
    }

    // Step 4: Skip middle if odd
    if (leng % 2 != 0) {
        curr = curr.next;
    }

    // Step 5: Replace second half with original first half (reversed)
    j = k - 1;
    while (curr != null) {
        curr.data = a[j];
        j--;
        curr = curr.next;
    }

    return head;
}



// Function to delete the kth node 
/*Given a singly linked list, the task is to remove every kth node of the linked list. Assume that k is always less than or equal to the length of the Linked List.

Examples : 

Input: LinkedList: 1 -> 2 -> 3 -> 4 -> 5 -> 6, k = 2
Output: 1 -> 3 -> 5 
Explanation: After removing every 2nd node of the linked list, the resultant linked list will be: 1 -> 3 -> 5 .

Input: LinkedList: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10, k = 3
Output: 1 -> 2 -> 4 -> 5 -> 7 -> 8 -> 10
Explanation: After removing every 3rd node of the linked list, the resultant linked list will be: 1 -> 2 -> 4 -> 5 -> 7 -> 8 -> 10*/

public static Node removeK(Node head, int k) {
    Node temp = head;
    Node prev = null;
    int j = 1, leng = 0;


    if (head == null || head.next == null) {
        return head;
    }

    // Count length of the list
    while (temp != null) {
        leng++;
        temp = temp.next;
    }

    
    temp = head;

    // Handle special cases
    if (k == 1) {
        return null; 
    }
    if (k > leng) {
        return head; 
    }


    while (temp != null) {
        if (j == k) {
    
            prev.next = temp.next;
            j = 1;
        } else {
            prev = temp;
            j++;
        }
        temp = temp.next; 
    }

    return head;
}

    
    // Function to returnn the middle node 
    /* if it's odd return the middle one 
    if it's even return the middle + one (second middle )*/
    
    public static int  Middle (Node head ){
        
        int leng = 0 , i = 0 , j = 0  ; 
        
        Node temp = head ; 
        if( temp == null || temp.next == null){
            return -1 ;
        }
        
        
        
        while ( temp != null){
            temp = temp.next ; 
            leng++; 
        }
        
        if( leng == 1 ){
            return head.data ; 
        }
        // REINTIALSE THE pointer
        temp = head; 
        j = leng ;
       
            
          for ( i = 0 ; i < j/2 ; i++ ){
               temp = temp.next ;  
            }
            return temp.data ; 
        }
        
        
    // Function to Calculate the number of occurances of a key in Linked list
    
    public static int FindKey (Node head , int key ){
        
        Node temp = head ; 
        int occ = 0 ; 
        while (temp != null){
            if(temp.data == key){
                occ++ ; 
            }
            temp = temp.next ; 
        }
        return occ ; 
    }
        
    //Function to swap nodes in pairs 
    
    public static Node  SwapPairs  (Node head ){
        Node prev = null  ; 
        Node temp = head ; 
        while (temp != null ){
            
            prev = temp;
            temp = temp.next ; 
            if(temp != null){
                int med = temp.data ; 
                temp.data = prev.data;
                prev.data = med;
               prev = temp ;
               temp = temp.next ;
            }
            
        }
        return head ; 
    }
    
    
    public static void main(String[] args) {
        Node head = new Node(2);
        Node A = new Node(3);
        Node B = new Node(4);
        Node D = new Node(5);
        Node E = new Node(6);
       // Node F = new Node(7);
        head.next = A;
        A.next = B;
        B.next = D;
        D.next = null;

        head = InsertAtFront(head, 1);
        DisplayLL(head);
        System.out.println("");
        head = InsertAtEnd(head , 6);
        DisplayLL(head);
        Reverse(head);
        System.out.println("");
         DisplayLL(head);
         head = removeK(head , 2);
         System.out.println("");
         DisplayLL(head);
         int mid = Middle(head);
         System.out.println("");
         System.out.println(mid);
        int f =  FindKey(head , 2);
         System.out.println(f);
         // test for  even list length
         
         Node h = new Node(2);
        Node AA = new Node(3);
        Node BB = new Node(4);
        Node DD = new Node(5);
        head.next = AA;
        AA.next = BB;
        BB.next = DD;
        DD.next = null;
        int m = Middle(head);
         System.out.println("");
         System.out.println(m);
         System.out.println("");
         h= SwapPairs(h);
         DisplayLL(head);
         System.out.println("");
         head = SwapPairs(head);
         DisplayLL(head);
         
        
         
         
         
    }
    
}