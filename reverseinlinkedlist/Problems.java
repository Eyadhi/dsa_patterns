package reverseinlinkedlist;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Problems {

    // 206. Reverse Linked List
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // 92. Reverse Linked List II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode current = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }

    // 25. Reverse Nodes in k-Group
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode tail = head;

        for (int i = 0; i < k; i++) {
            if (tail == null)
                return head;
            tail = tail.next;
        }

        ListNode newHead = reverse1(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    public ListNode reverse1(ListNode curr, ListNode end) {
        ListNode prev = null;

        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;

        int n = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            n++;
        }

        k = k % n;

        if (k == 0)
            return head;

        ListNode curr = head;
        for (int i = 0; i < n - k - 1; i++) {
            curr = curr.next;
        }

        ListNode newHead = curr.next;
        curr.next = null;
        node.next = head;
        return newHead;
    }

    public static void main(String[] args) {

    }
}
