package thirdWeekReview;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NodeTest {

  Node node;

  @Before
  public void setup() {
    node = new Node(5);
  }

  @Test
  public void heightTest() {
    assertEquals(1, node.height());
    node.insert(6);
    assertEquals(2, node.height());
  }

  @Test
  public void insertTest() {
    assertEquals(null, node.findNode(6));
    node.insert(6);
    assertEquals(6, node.findNode(6).getKey());
  }

  @Test
  public void deleteTest() {
    node.insert(6);
    assertEquals(6, node.findNode(6).getKey());
    node.delete(6);
    assertEquals(null, node.findNode(6));
  }

  @Test
  public void replaceChildTest() {
    node.insert(6);
    assertEquals(6, node.findNode(6).getKey());
    node.replaceChild(6, 7);
    assertEquals(null, node.findNode(6));
    assertEquals(7, node.findNode(7).getKey());
  }


}