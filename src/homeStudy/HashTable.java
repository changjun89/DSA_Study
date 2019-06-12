package homeStudy;


import java.util.Iterator;
import java.util.LinkedList;

public class HashTable {

  private Object[] table = new Object[100];

  public static void main(String[] args) {
    HashTable table = new HashTable();
    table.put("leechangjun", "leechangjun@naver.com");
    table.put("changjun", "changjun@naver.com");

    Object result = table.get("leechangjun");
    Object result2 = table.get("changjun");
    System.out.println(result.toString());
    System.out.println(result2.toString());
  }

  private int loseHashCode(Object key) {

    int hash = 0;
    for (int i = 0; i < key.toString().length(); i++) {
      hash += key.toString().charAt(i);
    }
    return hash % 37;
  }

  public void put(Object key, Object value) {
    int position = loseHashCode(key);

    if (table[position] == null) {
      LinkedList<Node> nodes = new LinkedList<>();
      nodes.add(new Node(key, value));
      table[position] = nodes;
      return;
    }
    LinkedList nodes = (LinkedList) table[position];
    nodes.add(new Node(key, value));
  }

  public Object get(Object key) {
    int position = loseHashCode(key);
    if (table[position] != null) {
      LinkedList<Node> nodes = (LinkedList) table[position];
      Iterator<Node> iterator = nodes.iterator();
      while (iterator.hasNext()) {
        Node node = iterator.next();
        if (node.getKey().equals(key)) {
          return node.getValue();
        }
      }
    }
    return null;
  }

  public void remove(Object key) {
    table[loseHashCode(key)] = null;
  }

}
