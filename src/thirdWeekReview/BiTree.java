package thirdWeekReview;

public class BiTree {

    private Node root;

    public void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return;
        }
        root.insert(newNode);
    }

    public int height() {
        if (root == null) {
            return 0;
        }
        return root.height();
    }

    public void delete(int key) {
        if (root == null) {
            return;
        }
        Node deleteNode = root.findNode(key);
        if (deleteNode == null) {
            System.out.println("값이 없어요");
            return;
        }
        Node maxNode = findReplaceDeleteNode(deleteNode);
        replaceDeleteNode(deleteNode, maxNode);
    }

    private Node findReplaceDeleteNode(Node node) {
        if (node.hasNoChild()) {
            return null;
        }
        if (node.isLeftNodeNull()) {
            return node.findRightMinNode();
        }
        return node.findLeftMaxNode();
    }


    private void replaceDeleteNode(Node deleteNode, Node maxNode) {
        Node parentDeleteNode = root.findParentNode(deleteNode);

        if (root.equalsKey(deleteNode)) {
            root = root.rootNodeChange(maxNode);
            return;
        }
        if (maxNode == null) {
            parentDeleteNode.deleteChild(deleteNode);
            return;
        }
        middleLevelChange(deleteNode, maxNode);
    }

    private void middleLevelChange(Node deleteNode, Node maxNode) {
        Node maxNodeDeleteNode = root.findParentNode(maxNode);
        Node parentDeleteNode = root.findParentNode(deleteNode);
        parentDeleteNode.replaceChild(deleteNode, maxNode);
        maxNodeDeleteNode.deleteChild(maxNode);
    }

}
