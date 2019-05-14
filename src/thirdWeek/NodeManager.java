package thirdWeek;

public class NodeManager {

    private final String HAVE_TWO_SUB_NODE = "11";
    private final String HAVE_NO_SUB_NODE = "00";
    private final String HAVE_LEFT_SUB_NODE = "10";
    private final String HAVE_RIGHT_SUB_NODE = "01";
    Node parentNode;
    Node selectedNode;
    int deleteNodeKey;


    public NodeManager(Node head) {
        parentNode = head;
        selectedNode = head;
    }

    public void delete(int value) {
        deleteNodeKey = value;
        findDeleteNode();
        String subNodeType = subNodeType();
        nodeDelete(subNodeType);
    }

    private void nodeDelete(String subNodeType) {
        if (HAVE_TWO_SUB_NODE.equals(subNodeType)) {
            hasTwoSubNodeControl();
            return;
        }
        if (HAVE_NO_SUB_NODE.equals(subNodeType)) {
            hasNoSubNodeControl();
            return;
        }
        if (HAVE_LEFT_SUB_NODE.equals(subNodeType)) {
            hasLeftSubNodeControl();
            return;
        }
        if (HAVE_RIGHT_SUB_NODE.equals(subNodeType)) {
            hasRightSubNodeControl();
            return;
        }
    }

    private void hasTwoSubNodeControl() {
        Node minNode = minNode(selectedNode, selectedNode);
        minNode.setRightNode(selectedNode.getRightNode());
        parentNode.setLeftNode(minNode);
        return;
    }

    private void hasNoSubNodeControl() {
        if (parentNode.isBigger(selectedNode.getValue())) {
            parentNode.setRightNode(null);
            return;
        }
        parentNode.setLeftNode(null);
        return;
    }

    private void hasRightSubNodeControl() {
        parentNode.setRightNode(selectedNode.getRightNode());
        return;
    }

    private void hasLeftSubNodeControl() {
        parentNode.setLeftNode(selectedNode.getLeftNode());
        return;
    }

    private void findDeleteNode() {
        if (selectedNode.getValue() == deleteNodeKey) {
            return;
        }
        if (selectedNode == null) {
            return;
        }
        parentNode = selectedNode;
        selectedNode = selectedNode.getNextHeader(deleteNodeKey);
        findDeleteNode();
    }

    private String subNodeType() {
        if (selectedNode.hasNoChild()) {
            return HAVE_NO_SUB_NODE;
        }
        if (selectedNode.hasTwoChildren()) {
            return HAVE_TWO_SUB_NODE;
        }
        if (selectedNode.isLeftNodeNull()) {
            return HAVE_RIGHT_SUB_NODE;
        }
        if (selectedNode.isRightNodeNull()) {
            return HAVE_LEFT_SUB_NODE;
        }
        return null;
    }

    public Node minNode(Node focus, Node parent) {
        parent = focus;
        if (focus.getLeftNode() == null) {
            parent.setLeftNode(null);
            return focus;
        }
        return minNode(focus.getLeftNode(), parent);
    }


}
