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

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
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

    public boolean equalsKey(Node node) {
        return key == node.getKey();
    }

    public int height() {
        if (this.hasNoChild()) {
            return 1;
        }
        return childHeight() + 1;
    }

    private int childHeight() {
        int leftNodeHeight = leftNode == null ? 0 : leftNode.height();
        int rightNodeHeight = rightNode == null ? 0 : rightNode.height();
        return Math.max(leftNodeHeight, rightNodeHeight);
    }

    public void insert(Node newNode) {
        if (!this.bigger(newNode)) {
            rightInsert(newNode);
            return;
        }
        leftInsert(newNode);
    }

    private void leftInsert(Node newNode) {
        if (this.isLeftNodeNull()) {
            this.setLeftNode(newNode);
            return;
        }
        leftNode.insert(newNode);
        return;
    }

    private void rightInsert(Node newNode) {
        if (this.isRightNodeNull()) {
            this.setRightNode(newNode);
            return;
        }
        rightNode.insert(newNode);
        return;
    }

    public Node findNode(int key) {
        if (getKey() == key) {
            return this;
        }
        if (key > this.getKey()) {
            return isRightNodeNull() ? null : rightNode.findNode(key);
        }
        return isLeftNodeNull() ? null : leftNode.findNode(key);
    }

    public Node findRightMinNode() {
        if (isRightNodeNull()) {
            return null;
        }
        return rightNode.findRightMinNodeRecursive();
    }

    private Node findRightMinNodeRecursive() {
        if (isLeftNodeNull()) {
            return this;
        }
        return leftNode.findRightMinNodeRecursive();
    }

    public Node findLeftMaxNode() {
        if (isLeftNodeNull()) {
            return null;
        }
        return leftNode.findLeftMaxNodeRecursive();
    }

    private Node findLeftMaxNodeRecursive() {
        if (isRightNodeNull()) {
            return this;
        }
        return rightNode.findLeftMaxNodeRecursive();
    }

    public Node findParentNode(Node node) {
        if (equalsKey(node)) {
            return this;
        }
        return findParentNode(node, this);
    }

    private Node findParentNode(Node node, Node parentNode) {
        if (equalsKey(node)) {
            return parentNode;
        }
        if (!bigger(node)) {
            return isRightNodeNull() ? null : rightNode.findParentNode(node, this);
        }
        return isLeftNodeNull() ? null : leftNode.findParentNode(node, this);
    }

    public Node rootNodeChange(Node newRoot) {
        if (!rightNode.equalsKey(newRoot)) {
            newRoot.setRightNode(rightNode);
        }
        if (!leftNode.equalsKey(newRoot)) {
            newRoot.setLeftNode(leftNode);
        }
        return newRoot;
    }

    public void deleteNextLevelNode(Node deleteNode) {
        if (hasNoChild()) {
            return;
        }
        if ((!isRightNodeNull() && !rightNode.equalsKey(deleteNode))
                && (!isLeftNodeNull() && leftNode.equalsKey(deleteNode))) {

            return;
        }
        if (!bigger(deleteNode)) {
            setRightNode(null);
            return;
        }
        setLeftNode(null);
    }

    public void replaceChild(Node originNode, Node newNode) {
        if (bigger(originNode)) {
            setLeftNode(newNode);
        }
        setRightNode(newNode);
    }
}
