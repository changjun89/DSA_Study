package homeStudy;


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
    System.out.println(position + "-" + key);
    table[position] = value;
  }

  public Object get(Object key) {
    return table[loseHashCode(key)];
  }

  public void remove(Object key) {
    table[loseHashCode(key)] = null;
  }

}
