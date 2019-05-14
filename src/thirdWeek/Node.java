package thirdWeek;

public class Node {

    private int value;
    private Node leftNode;
    private Node rightNode;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public boolean isBigger(int value) {
        return value > this.value;
    }

    public boolean setNode(int value) {
        Node newNode = new Node(value);
        if (!isBigger(value)) {
            return isSetLeftNode(newNode);
        }
        return isSetRightNode(newNode);
    }

    private boolean isSetLeftNode(Node newNode) {
        if (leftNode == null) {
            leftNode = newNode;
            return true;
        }
        return false;
    }

    private boolean isSetRightNode(Node newNode) {
        if (rightNode == null) {
            rightNode = newNode;
            return true;
        }
        return false;
    }

    public boolean hasNoChild() {
        return leftNode == null && rightNode == null;
    }

    public boolean hasTwoChildren() {
        return leftNode != null && rightNode != null;
    }

    public Node getNextHeader(int value) {
        return isBigger(value) ? getRightNode() : getLeftNode();
    }

    public boolean isLeftNodeNull() {
        return getLeftNode() == null;
    }

    public boolean isRightNodeNull() {
        return getRightNode() == null;
    }

    public void delete(Node head, int value) {
        NodeManager nm = new NodeManager(head);
        nm.delete(value);
    }


}
