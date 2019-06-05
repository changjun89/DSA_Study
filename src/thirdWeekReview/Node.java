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
            this.leftNode = newNode;
            return;
        }
        leftNode.insert(newNode);
        return;
    }

    private void rightInsert(Node node) {
        if (this.isRightNodeNull()) {
            this.rightNode = node;
            return;
        }
        rightNode.insert(node);
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

    private Node findRightMinNode() {
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

    private Node findLeftMaxNode() {
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

    private Node findParentNode(Node node) {
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

    public Node rootNodeChange(Node node) {
        if (!rightNode.equalsKey(node)) {
            node.rightNode = rightNode;
        }
        if (!leftNode.equalsKey(node)) {
            node.leftNode = leftNode;
        }
        return node;
    }

    private void deleteNextLevelNode(Node node) {
        if (hasNoChild()) {
            return;
        }
        if (!bigger(node)) {
            this.rightNode = null;
            return;
        }
        this.leftNode = null;
    }

    public void replaceChild(Node originNode, Node node) {
        if (bigger(originNode)) {
            this.leftNode = node;
        }
        this.rightNode = node;
    }

    public void insert(int i) {
        insert(new Node(i));
    }

    public void delete(int key) {
        Node deleteNode = findNode(key);
        if (deleteNode == null) {
            System.out.println("값이 없어요");
            return;
        }
        Node maxNode = deleteNode.findReplaceNodeForDelete();
        replaceDeleteToNewNode(deleteNode, maxNode);
    }

    public Node findReplaceNodeForDelete() {
        if (hasNoChild()) {
            return null;
        }
        return isLeftNodeNull() == true ? findRightMinNode() : findLeftMaxNode();
    }

    private void replaceDeleteToNewNode(Node deleteNode, Node node) {
        Node parentDeleteNode = findParentNode(deleteNode);
        if (node == null) {
            parentDeleteNode.deleteNextLevelNode(deleteNode);
            return;
        }
        middleLevelChange(deleteNode, node);
    }

    private void middleLevelChange(Node deleteNode, Node node) {
        Node maxNodeDeleteNode = findParentNode(node);
        Node parentDeleteNode = findParentNode(deleteNode);
        parentDeleteNode.replaceChild(deleteNode, node);
        maxNodeDeleteNode.deleteNextLevelNode(node);
    }

    public void replaceChild(int originKey, int newKey) {
        Node originNode = findNode(originKey);
        replaceChild(originNode, new Node(newKey));
    }
}
