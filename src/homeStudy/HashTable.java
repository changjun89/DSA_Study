package homeStudy;


import java.util.LinkedList;

public class HashTable {

  private Object[] table = new Object[100];

  public static void main(String[] args) {
    HashTable table = new HashTable();
    table.put("leechangjun", "leechangjun@naver.com");
    table.put("changjun", "changjun@naver.com");

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


  public void remove(Object key) {
    table[loseHashCode(key)] = null;
  }

}
