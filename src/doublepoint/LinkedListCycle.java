package doublepoint;

public class LinkedListCycle {

    public static void main(String[] args) {
        hasCycle(new ListNode());
        hasCycle(new ListNode(1));
    }

    /**
     * return true when head has cycle, or return false if not.
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode node1 = head;
        ListNode node2 = head.next;
        while (node1 != null && node2 != null && node2.next != null) {
            if (node1 == node2)
                return true;

            node1 = node1.next;
            node2 = node2.next.next;
        }

        return false;
    }

    private static class ListNode {
        public int value;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int value) {
            this.value = value;
        }
    }

}
