package leetCode;

public class ReSort {
    public static ListNode reorderList(ListNode head) {
        int currcount = 0;
        int count = 0;
        ListNode link = head;
        while(link!=null){
            link = link.next;
            count++;
        }

        int mid = count%2==0? count>>1:(count>>1)+1;


        ListNode lists = head;
        ListNode tail = null;
        ListNode pre = null;

        // 尾插后半段节点
        while(lists!=null){
            if(currcount<mid-1){
                lists = lists.next;
                currcount++;
            }else {
                ListNode next= lists.next;
                lists.next=null;
                lists.next = pre;
                pre = lists;
                lists=next;
                
            }
        }
        

        ListNode l1_tmp;
        ListNode l2_tmp;
        while (head != null && pre != null) {
            l1_tmp = head.next;
            l2_tmp = pre.next;

            head.next = pre;
            head = l1_tmp;

            pre.next = head;
            pre = l2_tmp;
        }
    

        return head;
        

    }

    public static void main(String[] args) {
        ListNode s = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        
        reorderList(s);

    }
}
class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
   class Solution {

       public void reorderList(ListNode head) {
           int currcount = 0;
           int count = 0;
           ListNode link = head;
           while(link!=null){
               link = link.next;
               count++;
           }
   
           int mid = count%2==0? count>>1:(count>>1)+1;
   
   
           ListNode lists = head;
           ListNode tail = null;
           ListNode pre = null;
   
           // 尾插后半段节点
           while(lists!=null){
               if(currcount<mid){
                   lists = lists.next;
                   currcount++;
   
               }else {
                   ListNode next= lists.next;
                   lists.next = pre;
                   pre = lists;
                   lists=next;
               }
           }
           ListNode mergeList = head;
           
           while(mergeList!=null && pre!=null){
               ListNode mergenext = mergeList.next;
               ListNode pnext = pre.next;
               mergeList.next = pre;
               mergeList = mergenext;
   
               pre.next=mergeList;
               pre = pnext;
               
           }
           
   
       }
   }