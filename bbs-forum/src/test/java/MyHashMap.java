import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by gan on 2019/4/26 22:58.
 */
public class MyHashMap<K, V> {

    private int size = 0;
    private Entry[] tables = {};
    private int capacity = 8;


    public MyHashMap(int capacity) {
        this.capacity = capacity;
        tables = new Entry[capacity];
    }


    public V get(K k) {
        int hash = k.hashCode();
        int index = hash % capacity;
        Entry<K, V> oldEntry = tables[index];
        if (oldEntry == null) {
            return null;
        } else {
            for (; oldEntry != null; oldEntry = oldEntry.next) {
                if (oldEntry.getK().equals(k)) {
                    return oldEntry.getV();
                }
            }
        }
        return null;
    }

    public V put(K k, V v) {
        int hash = k.hashCode();
        int index = hash % capacity;
        Entry<K, V> oldEntry = tables[capacity];
        V oldV = null;
        if (oldEntry == null) {
            Entry<K, V> entry = createEntry(k, v, null, hash);
            tables[index] = entry;
        } else {
            oldV = oldEntry.getV();
            for (; oldEntry != null; oldEntry = oldEntry.next) {
                if (oldEntry.getK().equals(k)) {
                    oldEntry.setV(v);
                    return oldV;
                }
            }

            Entry<K, V> entry = createEntry(k, v, tables[index], hash);
            tables[index] = entry;
        }

        return oldV;
    }

    private Entry<K, V> createEntry(K k, V v, Entry next, int hash) {
        Entry<K, V> entry = new Entry<K, V>(k, v, next, hash);
        return entry;
    }


    public int getSize() {
        return size;
    }


    @Data
    @AllArgsConstructor
    static class Entry<K, V> {
        private K k;
        private V v;
        private Entry next;
        private int hash;
    }
}
