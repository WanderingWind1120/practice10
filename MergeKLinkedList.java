package org.example;

public class MergeKLinkedList {
    public ListNode solution (ListNode[] lists){
        int minIndex = 0;
        ListNode head = new ListNode(0);
        ListNode h = head;

        while (true){
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i <= lists.length -1; i++){
                if (lists[i] != null){
                    if (lists[i].val < min) {
                        minIndex =i;
                        min = lists[i].val;
                    }
                }
                isBreak = false;
            }
            if (isBreak){
                break;
            }

            ListNode a = new ListNode(lists[minIndex].val);
            h.next = a;
            h = h.next;
            lists[minIndex] = lists[minIndex].next;
        }
        h.next = null;
        return head.next;
    }
}
