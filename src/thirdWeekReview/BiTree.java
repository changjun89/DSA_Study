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
      if (root.getKey() == key) {
        Node newRoot = root.findReplaceNodeForDelete();
        root = root.rootNodeChange(newRoot);
            return;
        }
      root.delete(key);
    }

}
