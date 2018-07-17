package leetcode.linkedList;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-17 16:14
 **/
public class LinkedListUtil {

    public static ListNode makeLiskedList(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode node = head;
        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
        return head;
    }
}
