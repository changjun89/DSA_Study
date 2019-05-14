package thirdWeek;

public class TwoSubNodeController implements INodeController {
    @Override
    public void deleteNode(Node parent, Node deleteNode) {
        Node minNode = minNode(deleteNode, deleteNode);
        minNode.setRightNode(deleteNode.getRightNode());
        parent.setLeftNode(minNode);
    }

    private Node minNode(Node focus, Node parent) {
        parent = focus;
        if (focus.getLeftNode() == null) {
            parent.setLeftNode(null);
            return focus;
        }
        return minNode(focus.getLeftNode(), parent);
    }

}
