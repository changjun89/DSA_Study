package thirdWeek;

public class OneSubNodeTypeDelete implements ISubNodeTypeDelete {
    @Override
    public void deleteNode(Node parent, Node deleteNode) {
        if (deleteNode.isLeftNodeNull()) {
            parent.setRightNode(deleteNode.getRightNode());
            return;
        }
        parent.setLeftNode(deleteNode.getLeftNode());
    }
}
