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
        if (newNode.getKey() > root.getKey()) {
            if (rightNodeSet(rootNode, newNode)) return;
            insert(root.getRightNode(), newNode);
            return;
        }
        if (leftNodeSet(rootNode, newNode)) return;
        insert(root.getLeftNode(), newNode);
        return;
    }

    private boolean leftNodeSet(Node rootNode, Node newNode) {
        if (rootNode.getLeftNode() == null) {
            rootNode.setLeftNode(newNode);
            return true;
        }
        return false;
    }

    private boolean rightNodeSet(Node rootNode, Node newNode) {
        if (rootNode.getRightNode() == null) {
            rootNode.setRightNode(newNode);
            return true;
        }
        return false;
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
        if (rootNode.getLeftNode() == null && rootNode.getRightNode() == null) {
            return 1;
        }
        int leftNodeHeight = height(rootNode.getLeftNode());
        int rightNodeHeight = height(rootNode.getRightNode());
        return Math.max(leftNodeHeight, rightNodeHeight) + 1;
    }

    public void delete(int key) {
        //(1) 해당 key의 노드를 찾는다.
        Node deleteNode = findNode(key);
        if (deleteNode == null) {
            System.out.println("값이 없어요");
            return;
        }
        //(2) 그 노드를 기준으로 왼쪽에서 가장 큰 key를 가진 노드나 오른쪽에서 가장 작은 key를 가진 노드를 찾는다.
        Node maxNode = findChangeNode(deleteNode);
        //(3) 2번에서 찾은 노드를 부모와 분리하고(사실상 삭제), 1번에서 찾은 노드를 2번에서 찾은 노드(또는 속성)로 대체한다.
        changeNode(deleteNode, maxNode);

    }

    private Node findChangeNode(Node node) {
        if (node.getLeftNode() == null && node.getRightNode() == null) {
            return null;
        }
        if (node.getLeftNode() == null) {
            return findeRightMinNode(node);
        }
        return findeLeftMaxNode(node);
    }

    protected Node findNode(int key) {
        return findNode(root, key);
    }

    private Node findNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.getKey() == key) {
            return root;
        }
        if (key > root.getKey()) {
            return findNode(root.getRightNode(), key);
        }
        return findNode(root.getLeftNode(), key);
    }

    private void changeNode(Node deleteNode, Node maxNode) {
        if (root.getKey() == deleteNode.getKey()) {
            maxNode.setLeftNode(root.getLeftNode());
            root = maxNode;
            return;
        }

        Node parentDeleteNode = findParentNode(deleteNode);
        if (maxNode == null) {
            if (parentDeleteNode.getKey() < deleteNode.getKey()) {
                parentDeleteNode.setRightNode(null);
            } else {
                parentDeleteNode.setLeftNode(null);
            }
            return;
        }

        Node maxNodeDeleteNode = findParentNode(maxNode);
        //max노드로 위치를 대처한다.
        if (parentDeleteNode.getKey() > deleteNode.getKey()) {
            parentDeleteNode.setRightNode(maxNode);
        } else {
            parentDeleteNode.setLeftNode(maxNode);
        }
        //maxnode의 parent에서 maxNode를 지운다.
        if (maxNodeDeleteNode.getKey() > maxNode.getKey()) {
            maxNodeDeleteNode.setRightNode(null);
        } else {
            maxNodeDeleteNode.setLeftNode(null);
        }

    }

    private Node findParentNode(Node node) {
        if (root.getKey() == node.getKey()) {
            return root;
        }
        Node currentNode = root;

        while (!hasDeleteChildNode(node, currentNode)) {
            if (currentNode == null) {
                break;
            }
            if (node.getKey() > currentNode.getKey()) {
                currentNode = currentNode.getRightNode();
                continue;
            }
            currentNode = currentNode.getLeftNode();
        }
        return currentNode;
    }

    private boolean hasDeleteChildNode(Node deleteNode, Node currentNode) {
        if (currentNode == null) {
            return false;
        }
        if (currentNode.getRightNode() != null && currentNode.getRightNode().getKey() == deleteNode.getKey()) {
            return true;
        }
        if (currentNode.getLeftNode() != null && currentNode.getLeftNode().getKey() == deleteNode.getKey()) {
            return true;
        }
        return false;
    }

    protected Node findeLeftMaxNode(Node node) {
        if (node.getLeftNode() == null) {
            return null;
        }
        Node currentNode = node.getLeftNode();
        while (currentNode.getRightNode() != null) {
            currentNode = currentNode.getRightNode();
        }
        return currentNode.getRightNode();
    }

    protected Node findeRightMinNode(Node node) {
        if (node.getRightNode() == null) {
            return null;
        }
        Node currentNode = node.getRightNode();
        while (currentNode.getLeftNode() != null) {
            currentNode = currentNode.getLeftNode();
        }
        return currentNode.getLeftNode();
    }

}
