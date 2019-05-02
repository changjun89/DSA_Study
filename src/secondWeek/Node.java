package secondWeek;

public class Node {
    private Object value;
    private Node preNode = null;
    private Node nextNode = null;

    public Node(Object value) {
        this.value = value;
    }

    public Node(Object value, Node preNode, Node nextNode) {
        this.value = value;
        this.preNode = preNode;
        this.nextNode = nextNode;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPreNode() {
        return preNode;
    }

    public void setPreNode(Node preNode) {
        this.preNode = preNode;
    }
}
