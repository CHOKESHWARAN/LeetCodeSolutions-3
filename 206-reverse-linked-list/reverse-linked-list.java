/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        Collections.reverse(list);

        ListNode dummy = new ListNode(0);
        temp = dummy;

        for (int value : list) {
            temp.next = new ListNode(value);
            temp = temp.next;
        }

        return dummy.next;
    }
}