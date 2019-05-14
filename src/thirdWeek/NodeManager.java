package thirdWeek;

public class NodeManager {

    Node parentNode;
    Node selectedNode;
    int deleteNodeKey;

    private INodeController iNodeController;

    public NodeManager(Node head) {
        parentNode = head;
        selectedNode = head;
    }

    public void delete(int value) {
        deleteNodeKey = value;
        findDeleteNode();
        subNodeType();
        nodeDelete();
    }

    private void nodeDelete() {
        iNodeController.deleteNode(parentNode, selectedNode);
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

    private void subNodeType() {
        if (selectedNode.hasNoChild()) {
            iNodeController = new ZeroSubNodeController();
            return;
        }
        if (selectedNode.hasTwoChildren()) {
            iNodeController = new TwoSubNodeController();
            return;
        }
        iNodeController = new OneSubNodeController();
    }

}
