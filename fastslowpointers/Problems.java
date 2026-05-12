package fastslowpointers;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Problems {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slowptr = head;
        ListNode fastptr = head;
        boolean hasCycle = false;

        while (fastptr != null && fastptr.next != null) {
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
            if (slowptr == fastptr) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle)
            return null;

        slowptr = head;
        while (slowptr != fastptr) {
            slowptr = slowptr.next;
            fastptr = fastptr.next;
        }
        return slowptr;
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow);
        while (rev != null) {
            if (head.val != rev.val) {
                return false;
            }
            head = head.next;
            rev = rev.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    static boolean isHappy(int n) {
        int slow = n, fast = sumOfSquaredDigits(n);
        while (fast != 1 && slow != fast) {
            slow = sumOfSquaredDigits(slow);
            fast = sumOfSquaredDigits(sumOfSquaredDigits(fast));
        }
        return fast == 1;
    }

    static int sumOfSquaredDigits(int n) {
        int sum = 0;
        while (n != 0) {
            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Problems p = new Problems();

        // ─── hasCycle ─────────────────────────────────────────────────────────────
        // List with cycle: 1 → 2 → 3 → 4 → 5 → (back to 2)
        ListNode cyclic = new ListNode(1);
        cyclic.next = new ListNode(2);
        cyclic.next.next = new ListNode(3);
        cyclic.next.next.next = new ListNode(4);
        cyclic.next.next.next.next = new ListNode(5);
        cyclic.next.next.next.next.next = cyclic.next; // 5 → 2
        System.out.println("hasCycle [1→2→3→4→5→2...]: " + p.hasCycle(cyclic)); // true

        // List without cycle: 1 → 2 → 3 → null
        ListNode linear = new ListNode(1);
        linear.next = new ListNode(2);
        linear.next.next = new ListNode(3);
        System.out.println("hasCycle [1→2→3]:           " + p.hasCycle(linear)); // false

        // ─── detectCycle ──────────────────────────────────────────────────────────
        // 3 → 2 → 0 → -4 → (back to 2), cycle starts at node with val=2
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2; // -4 → 2
        ListNode cycleStart = p.detectCycle(n1);
        System.out.println("detectCycle start val:      " + (cycleStart != null ? cycleStart.val : "null")); // 2

        ListNode noCycle = new ListNode(1);
        noCycle.next = new ListNode(2);
        System.out.println("detectCycle (no cycle):     " + p.detectCycle(noCycle)); // null

        // ─── middleNode ───────────────────────────────────────────────────────────
        // Odd length: 1 → 2 → 3 → 4 → 5, middle = 3
        ListNode odd = new ListNode(1);
        odd.next = new ListNode(2);
        odd.next.next = new ListNode(3);
        odd.next.next.next = new ListNode(4);
        odd.next.next.next.next = new ListNode(5);
        System.out.println("middleNode [1,2,3,4,5]:     " + p.middleNode(odd).val); // 3

        // Even length: 1 → 2 → 3 → 4, middle = 3 (second middle)
        ListNode even = new ListNode(1);
        even.next = new ListNode(2);
        even.next.next = new ListNode(3);
        even.next.next.next = new ListNode(4);
        System.out.println("middleNode [1,2,3,4]:       " + p.middleNode(even).val); // 3

        // ─── isPalindrome ─────────────────────────────────────────────────────────
        // 1 → 2 → 2 → 1 → null (palindrome)
        ListNode pal = new ListNode(1);
        pal.next = new ListNode(2);
        pal.next.next = new ListNode(2);
        pal.next.next.next = new ListNode(1);
        System.out.println("isPalindrome [1,2,2,1]:     " + p.isPalindrome(pal)); // true

        // 1 → 2 → 3 → null (not palindrome)
        ListNode notPal = new ListNode(1);
        notPal.next = new ListNode(2);
        notPal.next.next = new ListNode(3);
        System.out.println("isPalindrome [1,2,3]:       " + p.isPalindrome(notPal)); // false

        // ─── isHappy ──────────────────────────────────────────────────────────────
        System.out.println("isHappy(19):                " + isHappy(19)); // true
        System.out.println("isHappy(2):                 " + isHappy(2)); // false
    }
}
