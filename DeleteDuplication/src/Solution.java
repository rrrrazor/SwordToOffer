public class Solution {
    public static ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null){
            return null;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = pHead;
        ListNode left = preHead;
        ListNode right = pHead;
        while (right != null){
            while (right.next != null && right.val == right.next.val){
                right = right.next;
            }
            if(left.next == right){
                left = right;
            }else {
                left.next = right.next;
            }
            right = right.next;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        System.out.println(deleteDuplication(l1));

    }
}