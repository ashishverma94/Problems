class Sorting {
    
    // function to get middle element 
   ListNode mergeList ( ListNode l1 , ListNode l2 )
   {
       if ( l1==null ) 
           return l2 ;
       if ( l2==null )
           return l1 ;
       
       // we make l1 always minimum 
       if ( l1.val > l2.val )
       {
           ListNode temp = l1 ;
           l1 = l2 ;
           l2 = temp ;
           // swap(l1,l2);
       }
       // final sorted result
       ListNode result = l1 ;
       while ( l1 != null && l2 != null )
       {
           ListNode temp = null ;
           while ( l1 != null && l1.val <= l2.val )
           {
               temp = l1 ;
               l1 = l1.next ;
           }
           temp.next = l2  ;
           
           ListNode x = l1 ;
           l1 = l2 ;
           l2 = x ;
       }
       return result ;
   }
    // function to get middle element 
    ListNode findMiddle ( ListNode head )
    {
        ListNode slow = head , fast = head.next ;
        
        if ( slow.next == null )
            return slow ;
        
        while ( fast != null && fast.next!=null )
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
         return mid ;
    }
    
    // function to merge sort 
    public ListNode sortList(ListNode head) {
        if ( head == null || head.next == null )
            return head ;
        
        ListNode mid = findMiddle(head);
        
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return ( mergeList(left,right));
    }
}