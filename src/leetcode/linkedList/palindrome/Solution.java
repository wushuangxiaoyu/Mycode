package leetcode.linkedList.palindrome;

/**
 * 请判断一个链表是否为回文链表。
 *
 * @author Yu
 * @create 2018-05-23 20:43
 **/
public class Solution {
    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null)
            return true;
        if (head.val == head.next.val && head.next.next == null)
            return true;
        //到这时，链表的长度为3
        ListNode slow = head;
        ListNode cur = head.next;
        while(cur.next != null){
            if(cur.next.val == slow.val){
                if(cur.next.next != null)
                    return false;
                cur.next = null;
                slow = slow.next;
                cur = slow.next;
                if (cur == null || slow.val == cur.val)
                    return true;
            }else{
                cur = cur.next;
            }
        }
        return false;

    }
    public static boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode q = head.next,s=head;
        ListNode mid;
        while(q.next!=null&&q.next.next!=null){
            s=s.next;
            q=q.next.next;
        }
        ListNode end = q.next==null?q:q.next;

        ListNode p=s,m=s.next,n;
        while(m!=null){
            n=m.next;
            m.next=p;
            p=m;m=n;
        }

        ListNode start = head;
        while(start!=s.next){
            if(start.val!=end.val){
                return false;
            }
            start=start.next;
            end=end.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(1);
        ListNode a3=new ListNode(1);
        ListNode a4=new ListNode(5);
        ListNode a5=new ListNode(1);
        ListNode a6=new ListNode(1);
        ListNode a7=new ListNode(1);
        a1.next=a2;a2.next=a3;a3.next=a4;
        a4.next=a5;
        a5.next=a6;
        a6.next=a7;

        System.out.println(isPalindrome2(a1));
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
