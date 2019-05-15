package thirdWeek;

public class DeleteNode {

    Node parentNode;
    Node selectedNode;
    int deleteNodeKey;

    private ISubNodeTypeDelete iSubNodeTypeDelete;

    public DeleteNode(Node head) {
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
        iSubNodeTypeDelete.deleteNode(parentNode, selectedNode);
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
            iSubNodeTypeDelete = new ZeroSubNodeTypeDelete();
            return;
        }
        if (selectedNode.hasTwoChildren()) {
            iSubNodeTypeDelete = new TwoSubNodeTypeDelete();
            return;
        }
        iSubNodeTypeDelete = new OneSubNodeTypeDelete();
    }

}
