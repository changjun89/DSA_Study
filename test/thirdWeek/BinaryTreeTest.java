package thirdWeek;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {
    BinaryTree tree;

    @Before
    public void setup() {
        tree = new BinaryTree();
    }

    @Test
    public void insertTest() {
        tree.insert(7);
        assertEquals(7, tree.getHead().getValue());
        tree.insert(6);
        assertEquals(6, tree.getHead().getLeftNode().getValue());
        tree.insert(8);
        assertEquals(8, tree.getHead().getRightNode().getValue());
        tree.insert(9);
        assertEquals(9, tree.getHead().getRightNode().getRightNode().getValue());
        tree.insert(10);
        assertEquals(10, tree.getHead().getRightNode().getRightNode().getRightNode().getValue());
        //assertEquals(1, tree.getHeight());
//        tree.insert(8);
//        tree.insert(5);
//        tree.insert(6);
//        tree.insert(9);
//        tree.insert(3);
//        tree.insert(2);
        //assertEquals(4,tree.getHeight());

        //tree.delete(5);
        //assertEquals(3,tree.getHeight());
    }

    @Test
    public void heightTest() {
        assertEquals(0, tree.getHeight());
        tree.insert(7);
        assertEquals(1, tree.getHeight());
        tree.insert(8);
        assertEquals(2, tree.getHeight());
        tree.insert(9);
        assertEquals(3, tree.getHeight());
        tree.insert(10);
        assertEquals(4, tree.getHeight());
        tree.insert(2);
        assertEquals(4, tree.getHeight());
    }

    @Test
    public void searchTest() {
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        tree.insert(2);

        tree.searchNode(7);
        assertEquals(7, tree.searchNode(7).getValue());
        assertEquals(8, tree.searchNode(8).getValue());
        assertEquals(9, tree.searchNode(9).getValue());
        assertEquals(10, tree.searchNode(10).getValue());
        assertEquals(2, tree.searchNode(2).getValue());

    }

    @Test(expected = IllegalArgumentException.class)
    public void searchExceptionTest() throws Exception {
        tree.insert(7);
        tree.insert(8);

        tree.searchNode(3);

    }

    @Test
    public void deleteTest() {
        tree.insert(7);
        tree.insert(6);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        assertEquals(4, tree.getHeight());
        tree.delete(10);
        //assertEquals(3,tree.getHeight());
        //tree.getHeight(4)
        //tree.delete(10);
    }


}