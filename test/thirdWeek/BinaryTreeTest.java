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
    public void 아무것도없는tree에_하나의_값만_insert() {
        tree.insert(7);
        assertEquals(7, tree.getHead().getValue());
        assertEquals(1, tree.getHeight());
    }

    @Test
    public void 여러값이있는tree에_insert() {
        tree.insert(7);
        assertEquals(1, tree.getHeight());
        tree.insert(6);
        assertEquals(2, tree.getHeight());
        assertEquals(true, tree.hasNode(6));
    }

    @Test
    public void 일반삭제테스트() {
        tree.insert(7);
        tree.insert(6);
        assertEquals(true, tree.hasNode(7));
        tree.delete(6);
        assertEquals(false, tree.hasNode(6));
    }

    @Test
    public void 헤드삭제테스트() {
        tree.insert(7);
        assertEquals(true, tree.hasNode(7));
        tree.delete(7);
        assertEquals(false, tree.hasNode(7));
    }

    @Test
    public void 헤드삭제후_헤드노드가_바뀌는지_테스트() {
        tree.insert(7);
        tree.insert(6);
        assertEquals(true, tree.hasNode(7));
        tree.delete(7);
        assertEquals(false, tree.hasNode(7));
        assertEquals(6, tree.getHead().getValue());
    }


}