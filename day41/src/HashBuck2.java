import java.util.Objects;

class Person {
    public int id;
    public Person(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
public class HashBuck2<K,V> {
static class Node<K,V> {
    public K key;
    public V val;
    public Node<K,V> next;
    public Node(K key,V val) {
        this.key = key;
        this.val = val;
    }
}
public Node<K,V>[] array = (Node<K,V>[])new Node[10];
public int usdSize;
public void put(K key,V val) {
    int index = key.hashCode() % array.length;
    for(Node<K,V> cur = array[index];cur != null;cur = cur.next) {
        if(cur.key.equals(key)) {
            cur.val = val;
            return;
        }
    }
    Node<K,V> node = new Node<>(key,val);
    node.next = array[index];
    array[index] = node;
    this.usdSize++;
}
public V get(K key) {
    int index = key.hashCode() % array.length;
    Node<K,V> cur = array[index];
    while(cur != null) {
        if(cur.key.equals(key)) {
            return cur.val;
        }
        cur = cur.next;
    }
    return null;
}
}

