class Node
{
    int val,key;
    Node prev,next;
    Node(int key,int val)
    {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    int capacity;
    HashMap<Integer,Node> map = new HashMap<>();
    Node head,tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }

    public void deleteLRU(Node node)
    {
        Node beforeNode = node.prev;
        Node afterNode = node.next;
        beforeNode.next = afterNode;
        afterNode.prev = beforeNode;
    }
    public void insertLRU(Node node)
    {
        Node currNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = currNext;
        currNext.prev = node;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;   
        Node node =  map.get(key); 
        deleteLRU(node);
        insertLRU(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key))
        {   
            if(map.size()==capacity)
            {   
                Node lru = tail.prev;
                deleteLRU(tail.prev);
                map.remove(lru.key);
            }
            Node node = new Node(key,value);
            insertLRU(node);
            map.put(key,node);
        }
        else
        {   
            Node node = map.get(key);
            deleteLRU(node);
            insertLRU(node);
            node.val = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
