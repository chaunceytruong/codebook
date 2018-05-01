public class IntersectionLinkedList {
    public static void main(String[] args) {
//        Node a = new Node(1, new Node(2, new Node (3)));
//        Node b = new Node(1, new Node(2, new Node (3)));
//        System.out.println(intersection(a, b));

        Node common = new Node(2, new Node(3));
        Node a = new Node(1, common);
        Node b = common;
        System.out.println(intersection(a, b));
    }

    private static Node intersection(Node a, Node b) {
        int aSize = size(a);
        int bSize = size(b);
        if (aSize == 0 || bSize == 0) {
            return null;
        }
        Node aCurrent = a;
        Node bCurrent = b;
        if (aSize > bSize) {
            aCurrent = aCurrent.next;
        } else if (bSize > aSize) {
            bCurrent = bCurrent.next;
        }
        while (aCurrent != null && bCurrent != null) {
            if (aCurrent == bCurrent) {
                return aCurrent;
            }
            aCurrent = aCurrent.next;
            bCurrent = bCurrent.next;
        }
        return null;
    }

    private static int size(Node root) {
        int size = 0;
        Node current = root;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
}
