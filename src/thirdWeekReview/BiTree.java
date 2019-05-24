package thirdWeekReview;

public class BiTree {

    private Node root;

    public void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return;
        }
        insert(root, newNode);
    }

    private void insert(Node rootNode, Node newNode) {
        if (!root.bigger(newNode)) {
            rightInsert(rootNode, newNode);
            return;
        }
        leftInsert(rootNode, newNode);
        return;
    }

    private void leftInsert(Node rootNode, Node newNode) {
        if (rootNode.isLeftNodeNull()) {
            rootNode.setLeftNode(newNode);
            return;
        }
        insert(root.getLeftNode(), newNode);
        return;
    }

    private void rightInsert(Node rootNode, Node newNode) {
        if (rootNode.isRightNodeNull()) {
            rootNode.setRightNode(newNode);
            return;
        }
        insert(root.getRightNode(), newNode);
        return;
    }

    public int height() {
        if (root == null) {
            return 0;
        }
        return height(root);
    }

    private int height(Node rootNode) {
        if (rootNode == null) {
            return 0;
        }
        if (rootNode.hasNoChild()) {
            return 1;
        }
        return childHeight(rootNode) + 1;
    }

    private int childHeight(Node rootNode) {
        int leftNodeHeight = height(rootNode.getLeftNode());
        int rightNodeHeight = height(rootNode.getRightNode());
        return Math.max(leftNodeHeight, rightNodeHeight);
    }

    public void delete(int key) {
        Node deleteNode = findNode(key);
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
            return findRightMinNode(node);
        }
        return findLeftMaxNode(node);
    }

    private Node findNode(int key) {
        return findNode(root, key);
    }

    private Node findNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (isRootNode(root, key)) {
            return root;
        }
        if (key > root.getKey()) {
            return findNode(root.getRightNode(), key);
        }
        return findNode(root.getLeftNode(), key);
    }

    private void replaceDeleteNode(Node deleteNode, Node maxNode) {
        Node parentDeleteNode = findParentNode(deleteNode);

        if (isRootNode(root, deleteNode.getKey())) {
            rootNodeChange(maxNode);
            return;
        }
        if (maxNode == null) {
            lastLevelChange(deleteNode, parentDeleteNode);
            return;
        }
        middleLevelChange(deleteNode, maxNode);
    }

    private void middleLevelChange(Node deleteNode, Node maxNode) {
        Node maxNodeDeleteNode = findParentNode(maxNode);
        Node parentDeleteNode = findParentNode(deleteNode);
        placeNewNode(deleteNode, maxNode, parentDeleteNode);
        removeNode(maxNode, maxNodeDeleteNode);
    }

    private void removeNode(Node maxNode, Node maxNodeDeleteNode) {
        if (maxNodeDeleteNode.getKey() > maxNode.getKey()) {
            maxNodeDeleteNode.setRightNode(null);
            return;
        }
        maxNodeDeleteNode.setLeftNode(null);
    }

    private void placeNewNode(Node deleteNode, Node maxNode, Node parentDeleteNode) {
        if (parentDeleteNode.getKey() > deleteNode.getKey()) {
            parentDeleteNode.setLeftNode(maxNode);
            return;
        }
        parentDeleteNode.setRightNode(maxNode);
    }

    private void lastLevelChange(Node deleteNode, Node parentDeleteNode) {
        if (parentDeleteNode.getKey() < deleteNode.getKey()) {
            parentDeleteNode.setRightNode(null);
            return;
        }
        parentDeleteNode.setLeftNode(null);
    }

    private void rootNodeChange(Node maxNode) {
        if (root.getRightNode().getKey() != maxNode.getKey()) {
            maxNode.setRightNode(root.getRightNode());
        }
        if (root.getLeftNode().getKey() != maxNode.getKey()) {
            maxNode.setLeftNode(root.getLeftNode());
        }
        root = maxNode;
    }

    private boolean isRootNode(Node root, int key) {
        return root.getKey() == key;
    }

    private Node findParentNode(Node deleteNode) {
        if (isRootNode(root, deleteNode.getKey())) {
            return root;
        }
        Node currentNode = root;
        while (true) {
            if (hasChildNode(root)) {
                break;
            }
            if (root.containChild(deleteNode)) {
                break;
            }
            currentNode = nextChildNode(deleteNode, currentNode);
        }
        return currentNode;
    }

    private Node nextChildNode(Node deleteNode, Node currentNode) {
        if (deleteNode.getKey() > currentNode.getKey()) {
            return currentNode.getRightNode();
        }
        return currentNode.getLeftNode();
    }

    private boolean hasChildNode(Node root) {
        return root.getLeftNode() != null || root.getRightNode() != null;
    }

    private Node findLeftMaxNode(Node node) {
        if (node.getLeftNode() == null) {
            return null;
        }
        Node currentNode = node.getLeftNode();
        while (currentNode.getRightNode() != null) {
            currentNode = currentNode.getRightNode();
        }
        return currentNode;
    }

    private Node findRightMinNode(Node node) {
        if (node.getRightNode() == null) {
            return null;
        }
        Node currentNode = node.getRightNode();
        while (currentNode.getLeftNode() != null) {
            currentNode = currentNode.getLeftNode();
        }
        return currentNode;
    }

}
