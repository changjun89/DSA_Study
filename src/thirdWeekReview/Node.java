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

    public int height() {
        if (this.hasNoChild()) {
            return 1;
        }
        return childHeight() + 1;
    }

    private int childHeight() {
        int leftNodeHeight = getLeftNode() == null ? 0 : getLeftNode().height();
        int rightNodeHeight = getRightNode() == null ? 0 : getRightNode().height();
        return Math.max(leftNodeHeight, rightNodeHeight);
    }


    public void insert(Node newNode) {
        if (!this.bigger(newNode)) {
            rightInsert(newNode);
            return;
        }
        leftInsert(newNode);
        return;
    }

    private void leftInsert(Node newNode) {
        if (this.isLeftNodeNull()) {
            this.setLeftNode(newNode);
            return;
        }
        getLeftNode().insert(newNode);
        return;
    }

    private void rightInsert(Node newNode) {
        if (this.isRightNodeNull()) {
            this.setRightNode(newNode);
            return;
        }
        getRightNode().insert(newNode);
        return;
    }


    public Node findNode(int key) {
        if (getKey() == key) {
            return this;
        }
        if (key > this.getKey()) {
            return getRightNode() == null ? null : getRightNode().findNode(key);
        }
        return getLeftNode() == null ? null : getLeftNode().findNode(key);
    }

    public Node findRightMinNode() {
        if (getRightNode() == null) {
            return null;
        }
        Node currentNode = getRightNode();
        while (currentNode.getLeftNode() != null) {
            currentNode = currentNode.getLeftNode();
        }
        return currentNode;
    }

    public Node findLeftMaxNode() {
        if (getLeftNode() == null) {
            return null;
        }
        Node currentNode = getLeftNode();
        while (currentNode.getRightNode() != null) {
            currentNode = currentNode.getRightNode();
        }
        return currentNode;
    }

    public boolean hasChildNode() {
        return getLeftNode() != null || getRightNode() != null;
    }

    public Node findParentNode(Node node) {
        if (getKey() == node.getKey()) {
            return this;
        }
        Node currentNode = this;
        while (true) {
            if (currentNode.hasChildNode() || currentNode.containChild(node)) {
                break;
            }
            currentNode = currentNode.bigger(node) ? currentNode.getRightNode() : currentNode.getLeftNode();
        }
        return currentNode;
    }

    public boolean equalsKey(Node node) {
        return key == node.getKey();
    }

    public Node rootNodeChange(Node newRoot) {
        if (getRightNode().getKey() != newRoot.getKey()) {
            newRoot.setRightNode(getRightNode());
        }
        if (getLeftNode().getKey() != newRoot.getKey()) {
            newRoot.setLeftNode(getLeftNode());
        }
        return newRoot;
    }

    public void deleteChild(Node deleteNode) {
        if (getKey() < deleteNode.getKey()) {
            setRightNode(null);
            return;
        }
        setLeftNode(null);
    }

    public void replaceChild(Node originNode, Node newNode) {
        if (getKey() > originNode.getKey()) {
            setLeftNode(newNode);
        }
        setRightNode(newNode);
    }
}
