package thirdWeekReview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BiTreeTest {
    BiTree tree;

    @Before
    public void setup() {
        tree = new BiTree();
    }

    @Test
    public void noNodeTest() {
        assertEquals(0, tree.height());
    }

    @Test
    public void insertTest() {
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        assertEquals(2, tree.height());
        tree.insert(7);
        assertEquals(3, tree.height());
        tree.insert(8);
        assertEquals(4, tree.height());
    }

    @Test
    public void deleteLastNodeTest() {
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);
        assertEquals(3, tree.height());
        tree.delete(7);
        assertEquals(2, tree.height());
    }

    @Test
    public void deleteRoot() {
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        assertEquals(2, tree.height());
        tree.delete(5);
        assertEquals(2, tree.height());
    }


    @Test
    public void deleteMiddleNodeTest() {
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);
        assertEquals(3, tree.height());
        tree.delete(6);
        assertEquals(2, tree.height());
    }

    @Test
    public void deleteMiddleNodeTest2() {
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);
        assertEquals(3, tree.height());
        tree.delete(4);
        assertEquals(3, tree.height());
    }

}
