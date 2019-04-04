public class Solution {

    public static ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode meetingNode = MeetingNode(pHead);
        if(meetingNode == null){
            return null;
        }
        //找入口
        //环中的节点个数
        int num = 1;
        ListNode cntNode = meetingNode;
        while (cntNode.next != meetingNode){
            cntNode = cntNode.next;
            num++;
        }

        //先移动pNode1(cntNode),num次
        cntNode = pHead;
        for(int i = 0; i < num; i++){
           cntNode  = cntNode.next;
        }
        ListNode pNode2 = pHead;
        //在同时移动pNode1(cntNode)，pNode2直到相遇
        while (cntNode != pNode2){
            cntNode = cntNode.next;
            pNode2 = pNode2.next;
        }
        return cntNode;
    }

    public static ListNode MeetingNode(ListNode pHead){
        if(pHead == null){
            return null;
        }
        //判断是否成环
        ListNode slow = pHead.next;
        if(slow == null){
            return null;
        }
        ListNode fast = slow.next;

        while (slow != null && fast != null){
            if(slow == fast){
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l3;
        System.out.println(EntryNodeOfLoop(l1));



    }

}