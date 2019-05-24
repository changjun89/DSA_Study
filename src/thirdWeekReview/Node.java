package thirdWeekReview;

public class Node {

    private int key;
    private Node leftNode;
    private Node rightNode;

    public Node(int value) {
        key = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
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

    public boolean containChild(Node deleteNode) {
        int key = deleteNode.getKey();
        if (isRightKey(key) || isLeftKey(key)) {
            return true;
        }
        return false;
    }

    private boolean isLeftKey(int key) {
        return leftNode != null && leftNode.getKey() == key;
    }

    private boolean isRightKey(int key) {
        return rightNode != null && rightNode.getKey() == key;
    }

    public boolean bigger(Node newNode) {
        return key > newNode.getKey();
    }

    public boolean isLeftNodeNull() {
        return leftNode == null;
    }

    public boolean isRightNodeNull() {
        return rightNode == null;
    }

    public boolean hasNoChild() {
        return isLeftNodeNull() && isRightNodeNull();
    }
}
