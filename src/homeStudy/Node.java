package homeStudy;

public class Node {

  private Object key;
  private Object value;

  public Node(Object key, Object value) {
    this.key = key;
    this.value = value;
  }


  @Override
  public String toString() {
    return "Node{" +
        "key=" + key +
        ", value=" + value +
        '}';
  }
}
