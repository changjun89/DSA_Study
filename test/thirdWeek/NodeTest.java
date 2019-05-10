package thirdWeek;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeTest {

    @Test
    public void insertTest() {
        Object value = 5;
        Node headNode = new Node(7);
        headNode.insert(new Node(5));
        headNode.insert(new Node(8));
        assertEquals(5, headNode.getLeftNode().getValue());
        assertEquals(8, headNode.getRightNode().getValue());
    }

}