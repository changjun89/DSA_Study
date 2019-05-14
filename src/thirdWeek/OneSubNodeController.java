package thirdWeek;

public class OneSubNodeController implements INodeController {
    @Override
    public void deleteNode(Node parent, Node deleteNode) {
        if (deleteNode.isLeftNodeNull()) {
            parent.setRightNode(deleteNode.getRightNode());
            return;
        }
        parent.setLeftNode(deleteNode.getLeftNode());
    }
}
