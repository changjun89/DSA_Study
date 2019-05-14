package thirdWeek;

public class BinaryTree {

    private Node head = null;

    public Node getHead() {
        return head;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        insert(value, head);
    }

    private void insert(int value, Node head) {
        if (head.setNode(value)) {
            return;
        }
        insert(value, head.getNextHeader(value));
    }

    public int getHeight() {
        if (head == null) {
            return 0;
        }
        return getHeight(head);
    }

    private int getHeight(Node rootNode) {
        if (rootNode == null) {
            return 0;
        }
        if (rootNode.hasNoChild()) {
            return 1;
        }
        int leftNodeHeight = getHeight(rootNode.getLeftNode());
        int rightNodeHeight = getHeight(rootNode.getRightNode());
        return Math.max(leftNodeHeight, rightNodeHeight) + 1;
    }

    public Node searchNode(int value) {
        if (head == null) {
            throw new IllegalArgumentException(value + "값은 없습니다.");
        }
        return searchNode(value, head);
    }

    private Node searchNode(int value, Node head) {
        if (head == null) {
            throw new IllegalArgumentException(value + "값은 없습니다.");
        }
        if (head.getValue() == value) {
            return head;
        }
        return searchNode(value, head.getNextHeader(value));
    }

    public void delete(int value) {
        if (head == null) {
            return;
        }
        head.delete(head, value);
    }

    public Node minNode(Node focus, Node parent) {
        parent = focus;
        if (focus.getLeftNode() == null) {
            parent.setLeftNode(null);
            return focus;
        }
        return minNode(focus.getLeftNode(), parent);
    }


}
