
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {
    static int index = 0;

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(2, new Node(1), null);
        root.right = new Node(5, new Node (3), new Node(8));

        // Serialize test
        List<Integer> values = new ArrayList<>();
        serialize(root, values);
        System.out.println("Serialize");
        System.out.println(values);

        Node r = deserialize(values);
        System.out.println("Deserialize");
        List<Integer> deserializedValues = new ArrayList<>();

        System.out.println("Pre-order recursive");
        preOrderTraversalRecursive(r, deserializedValues);
        System.out.println(deserializedValues);

        System.out.println("Pre-order iterative");
        deserializedValues.clear();
        preOrderTraversalIterative(r, deserializedValues);
        System.out.println(deserializedValues);
    }

    /**
     * Given the root node, serialize the binary tree into a list (pre-order traversal).
     *
     * @param root root node
     * @param values list of values to serialize binary tree
     */
    public static void serialize(Node root, List<Integer> values) {
        if (root == null) {
            values.add(-1);
            return;
        }

        values.add(root.value);
        serialize(root.left, values);
        serialize(root.right, values);
    }

    public static Node deserialize(List<Integer> values) {
        if (index == values.size() || values.get(index) == -1) {
            index++;
            return null;
        }
        Node root = new Node(values.get(index));
        index++;
        root.left = deserialize(values);
        root.right = deserialize(values);
        return root;
    }

    public static void preOrderTraversalRecursive(Node root, List<Integer> values) {
        if (root != null) {
            values.add(root.value);
            preOrderTraversalRecursive(root.left, values);
            preOrderTraversalRecursive(root.right, values);
        }
    }

    public static void preOrderTraversalIterative(Node root, List<Integer> values) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            values.add(root.value);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }
}
