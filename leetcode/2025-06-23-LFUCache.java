import java.util.*;

class Node {
    int key, val, freq;
    Node prev, next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

class DLL {
    Node head, tail;
    int size;

    DLL() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    void add(Node node) {
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
        size++;
    }

    void remove(Node node) {
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
        size--;
    }

    Node removeLast() {
        if (size == 0) return null;
        Node last = tail.prev;
        remove(last);
        return last;
    }
}

public class LFUCache {

    int capacity, size, minFreq;
    HashMap<Integer, Node> map;
    HashMap<Integer, DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        DLL oldList = freqMap.get(freq);
        oldList.remove(node);

        if (freq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        DLL newList = freqMap.getOrDefault(node.freq, new DLL());
        newList.add(node);
        freqMap.put(node.freq, newList);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        updateFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            updateFreq(node);
        } else {
            if (size == capacity) {
                DLL minFreqDLL = freqMap.get(minFreq);
                Node lruNode = minFreqDLL.removeLast();
                map.remove(lruNode.key);
                size--;
            }

            Node node = new Node(key, value);
            minFreq = 1;
            DLL newList = freqMap.getOrDefault(1, new DLL());
            newList.add(node);
            freqMap.put(1, newList);
            map.put(key, node);
            size++;
        }
    }
}
