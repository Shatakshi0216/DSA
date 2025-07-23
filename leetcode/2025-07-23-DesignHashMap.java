class Node
{
    int k;
    int v;
    Node next;
    Node(int k,int v)
    {
        this.k = k;
        this.v = v;
    }
    
}
class MyHashMap { 
    Node head;
    Node tail;
    public MyHashMap() {
        head = null;
        tail = null;
    }
    public void removeNode(Node temp)
    {   if(temp==head && temp==tail)
        {
            head = null;
            tail = null;
            return;
        }
        if(temp==head)
        {
            head = head.next;
            return;
        } 
        Node curr = head;
        while(curr!=null && curr.next!=null)
        {
            if(curr.next == temp)
            {
                curr.next = temp.next;
                if(temp==tail)
                {
                    tail = curr;
                }
                return;
            }
            curr = curr.next;
        }
        

    }
    public void put(int key, int value) {
        if(head==null)
        {   
            Node n = new Node(key,value);
            head = n;
            tail = n;
        } 
        else 
        {
            Node temp = head;
            while(temp!=null) 
            {
                if(temp.k == key)
                {
                    temp.v = value;
                    return;
                }
                temp = temp.next;
            }
            Node n = new Node(key,value); 
            tail.next = n;
            tail = tail.next;  
                
            
        }
    }
    
    public int get(int key) {
        if(head==null) return -1;
        Node temp = head;
        while(temp!=null)
        {
            if(temp.k==key) return temp.v;
            temp = temp.next;
        }
        return -1;

    }
    
    public void remove(int key) {
        if(head==null) return;
        Node temp = head;
        while(temp!=null)
        {
            if(temp.k==key)
            {
                removeNode(temp);
            }
            temp = temp.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
