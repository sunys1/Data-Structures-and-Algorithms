public class IntersectionNodeTwoAcyclic {
    public static Node getAcyclicIntersectionNode(Node head1, Node head2) {
        int size1 = sizeOfList(head1);
        int size2 = sizeOfList(head2);
        int difference = size1 - size2;

        if (difference < 0) {
            for (int i = 0; i < -difference; i++) {
                head2 = head2.next;
            }
        } else {
            for (int i = 0; i < difference; i++) {
                head1 = head1.next;
            }
        }
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }

    private static int sizeOfList(Node head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getCycleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // for 3 scenarios of cyclic linked lists
    public static Node getCycleNodeOfCycleList(Node head1, Node head2) {
        Node cycleNode1 = getCycleNode(head1);
        Node cycleNode2 = getCycleNode(head2);

        if(cycleNode1 != cycleNode2){
            Node temp = cycleNode1;
            while(temp != cycleNode2){
                temp = temp.next;
                if(temp == cycleNode2) return null;
            }
        }

        return cycleNode1;
    }
}