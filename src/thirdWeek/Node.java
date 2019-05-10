package thirdWeek;

public class Node {
    private Object value;
    private Node LeftNode;
    private Node rightNode;

    public Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public Node getLeftNode() {
        return LeftNode;
    }

    public void setLeftNode(Node leftNode) {
        LeftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public void insert(Node newNode) {


    }
}
