package thirdWeek;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeTest {

    @Test
    public void insertTest() {
        Object value = 5;
        Node headNode = new Node(7);
        assertEquals(true, headNode.setNode(5));
        assertEquals(5, headNode.getLeftNode().getValue());
        assertEquals(true, headNode.setNode(8));
        assertEquals(8, headNode.getRightNode().getValue());
        assertEquals(false, headNode.setNode(9));

    }

    @Test
    public void hasNoChild() {
        Node newNode = new Node(5);
        assertEquals(true, newNode.hasNoChild());
    }

    @Test
    public void getNextHeaderTest() {
        Node newNode = new Node(5);
        newNode.setRightNode(new Node(6));
        assertEquals(6, newNode.getNextHeader(7).getValue());
    }

}