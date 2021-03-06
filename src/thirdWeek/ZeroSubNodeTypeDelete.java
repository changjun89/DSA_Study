package thirdWeek;

public class ZeroSubNodeTypeDelete implements ISubNodeTypeDelete {
    @Override
    public void deleteNode(Node parent, Node deleteNode) {
        if (parent.isBigger(deleteNode.getValue())) {
            parent.setRightNode(null);
            return;
        }
        parent.setLeftNode(null);
    }
}
