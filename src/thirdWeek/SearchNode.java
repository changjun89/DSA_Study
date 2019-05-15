package thirdWeek;

public class SearchNode {
    private Node searchNode;
    private int searchValue;

    public Node searchNode(Node head, int value) {
        searchValue = value;
        searchNode(head);
        return searchNode;
    }

    private void searchNode(Node head) {
        if (head == null) {
            return;
        }
        if (!head.isLeftNodeNull()) {
            searchNode(head.getLeftNode());
        }
        if (head.getValue() == searchValue) {
            searchNode = head;
            return;
        }
        if (!head.isRightNodeNull()) {
            searchNode(head.getRightNode());
        }
    }
}
