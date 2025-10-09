

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
    
    
    // Function to detect wether there is a cycle or no in Linked List 
    // Explination 
    
    /*Given the head of a singly linked list, determine whether the list contains a cycle.

A cycle exists if, while traversing the list through next pointers, you encounter a node that has already been visited instead of eventually reaching nullptr.*/


    
   public static Boolean DetectCycle (Node head ){
    
    Node temp = head ; 
    Node curr = head ;
    
    if(curr == null || curr.next == null  ){
        
        return false ; 
      
    }
    while (temp  != null && temp.next != null){
        
        curr = curr.next;
        temp = temp.next.next ; 
        
        if(curr == temp ){
            return true ;
        }
        
        
        
   }
   return false ; 
   }
   
   
   // Function to detect the length of a cycle 
   
      public static int  CycleLength (Node head ){
    
    Node temp = head ; 
    Node curr = head ;
    
    if(curr == null || curr.next == null  ){
        
        return 0 ; 
      
    }
    while (temp != null && temp.next != null){
        
        curr = curr.next;
        temp = temp.next.next ; 
        
        if(curr == temp ){
             int i = 1 ; 
             temp = temp.next  ;
        while ( temp != curr ){
            
            temp = temp.next ; 
            i++ ; 
        }
        return i ; 
        }
        
    
    }
          return 0 ; 
      }

    
    // Function to Remove duplicates from a sorted linked list
    
    public static Node RemoveDuplicates(Node head){
       
       Node curr = head ; 
       while (curr != null &&  curr.next != null ) {
           
       if( curr.data == curr.next.data)
       {
           curr.next = curr.next.next ; 
       }
       else curr = curr.next ; 
       }
        return head ;
    }
    
    /*
    // Function to delete duplicanted from an insorted list 
    
    public static Node RemoverDuplicateUnsortedList(Node head ){
        
        Node temp  = head ; 
        int i = 0 ; j = 1  , leng = 0 ;
        
        if( temp != null || temp.next == null){
            return null ; 
        }
        // steps to count the linked list length 
        
        while(temp != null ){
            leng++ ; 
            temp = temp.next ; 
        }
        temp = head ; 
        
        
    // inside the while we will move curr and compare each time of temp == curr if it(s true there is always a supp pointer before curr that once we find curr == temp we get ride of the duplicate node which will be curr 
    
// here is the implementation fo the idea 
           curr = temp.next  ;
           
       while (temp != null ){
    
        
        for(i = 0 ; i < leng -1 ; i++ ){
            
           if(curr != null){
            
            if(temp.data == curr.data){
                curr = curr.next ; 
                supp.next = curr ;
                leng-- ; 
            }else {
                supp = curr ; 
                curr = curr.next ; 
            }
        }
        temp = temp.next ; 
        supp = temp ; 
        curr = temp.next ; 
        leng -- ; 
    }
    return head ; 
}
    }*/
    
// Function to remove duplicates from an unsorted linked list

public static Node removeDuplicateUnsorted(Node head) {
    if (head == null || head.next == null) {
        return head; 
    }

    Node temp = head;

    // Outer loop picks elements one by one
    while (temp != null) {
        Node supp = temp;
        Node curr = temp.next;

        // Inner loop checks for duplicates
        while (curr != null) {
            if (curr.data == temp.data) {
                // Duplicate found → remove node
                supp.next = curr.next;
                curr = curr.next;
            } else {
                supp = curr;
                curr = curr.next;
            }
        }

        temp = temp.next;
    }

    return head;
}


/*Given a linked list and a value x, partition it such that all nodes less than x come first, then all nodes with a value equal to x, and finally nodes with a value greater than x. The original relative order of the nodes in each of the three partitions should be preserved.

Examples: 

Input : 1 -> 4 -> 3 -> 2 -> 5 -> 2 -> 3, x = 3
Output: 1 -> 2 -> 2 -> 3 -> 3 -> 4 -> 5
Explanation: In the below linked list, all nodes with value less than 3 are on the left and rest of the nodes on the right by maintaining the relative order.

*/
  
  
  
     /*public static Node Interesect(Node head , int x ){
      
      Node temp = head ; 
      int i = 0  ;
       int[] a = new int[leng];
       int[] b = new int[leng];
       int[] c = new int[leng];
      // here we are going to see if the entered int exist in the linked list 
      
      while (tmep != null ){
          if(tem.data == x )
          i++;
          temp = temp.next ;
          leng++;
      
          
      }
      
      if(i == 0 ){
          return null ; 
      }else{
          
          temp = head ;
          i = 0 ; 
          int k = 0 , j = 0 ; 
          while(temp != null){
              if(temp.data == x){
                  
                  a[i] = x ; 
                  i++;
              }else (temp.data < x ){
                  b[j] = temp.data ;
                  temp = temp.next ;
                  j++;
              }else if(temp.data > x){
                  
                  c[k] = temp.data ; 
                  k++ ; 
              }
          }
          
          int min1 = b[0];
          int min2 = c[0];
          
          for ( i = 0 ; i  < b.length ; i++){
              
              for ( j = 0  ; j  < b.length ; j++ )
              if(b[j]  <  b[i]){
                  
                  int m = b[j];
                  b[j] = b[i];
                  b[j] = m ; 
                  
                  
              }
             
              for ( i = 0 ; i  < c.length ; i++){
              
              for ( j = 0  ; j  < c.length ; j++ )
              if(c[j]  <  c[i]){
                  
                  int m = c[j];
                  c[j] = c[i];
                  c[j] = m ; 
                  
                  
              
                  
              }
                  
              }
              
          }
              
              temp = head ; 
              j = 0 ; 
              while(leng != 0  ){
                  
                      
                      temp.data = b[j];
                      j++,
                      leng--;
                  
                  
              }
              temp = head ;
              i = 0 ; 
              while(leng != 0  ){
                 
                      
                      temp.data = a[i];
                      i++,
                      leng--;
                  
                  
              }
              temp = head ;
              k = 0 ; 
              while(leng != 0  ){
                 
                      
                      temp.data = c[k];
                      k++,
                      leng--;
                  
                  
              }
          
         
      }
  }   
     */ 
      
      
      
       public static Node partition(Node head, int x) {
        if (head == null) return null;

        // Dynamic arrays (ArrayLists)
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

       
        Node temp = head;
        while (temp != null) {
            if (temp.data < x) {
                less.add(temp.data);
            } else if (temp.data == x) {
                equal.add(temp.data);
            } else {
                greater.add(temp.data);
            }
            temp = temp.next;
        }

        
        temp = head;
        for (int val : less) {
            temp.data = val;
            temp = temp.next;
        }
        for (int val : equal) {
            temp.data = val;
            temp = temp.next;
        }
        for (int val : greater) {
            temp.data = val;
            temp = temp.next;
        }

        return head;
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
          System.out.println(DetectCycle(h));
          System.out.println(DetectCycle(head));
          
        System.out.println("");
        // trying the remove duplicates in the last linked list 
        head = RemoveDuplicates(head);
        DisplayLL(head);
        System.out.println();
         
        
         
         
         
    }
    
}


