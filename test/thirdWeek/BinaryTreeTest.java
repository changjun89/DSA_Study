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
    public void heightTest() {
        tree.insert(7);
        assertEquals(1, tree.getHeight());
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
}