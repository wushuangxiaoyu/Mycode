package leetcode.linkedList.oddEvenLinkedList;

import leetcode.linkedList.LinkedListUtil;
import leetcode.linkedList.ListNode;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * @author Yu
 * @create 2018-07-18 13:24
 **/
public class Solution {
    public static ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode tmp = new ListNode(0);
        ListNode head2 = tmp;
        ListNode cur = head;
        while (cur != null&&cur.next!=null) {
            tmp.next = cur.next;
            cur.next = cur.next.next;
            if(cur.next==null){
                break;
            }
            cur = cur.next;
            tmp = tmp.next;
            tmp.next=null;
        }
        cur.next = head2.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = LinkedListUtil.makeLiskedList(new int[]{1, 2, 3, 4, 5});
        final ListNode listNode1 = oddEvenList(listNode);
    }
}
