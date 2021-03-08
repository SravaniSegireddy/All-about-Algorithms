class MyHashMap {
    ArrayList<ArrayList<Node>> hm;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hm = new ArrayList<ArrayList<Node>>(Collections.nCopies(10,null));
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {       
        
        ArrayList<Node> valList = hm.get(key%10) == null ? new ArrayList<Node>() :hm.get(key%10) ;
        
        for(int i = 0 ; i < valList.size() ; i++){
            if(valList.get(i).key == key){
                valList.get(i).value = value;
                return;
            }
        }
        valList.add(new Node(key, value));
        hm.set(key%10, valList);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        if(hm.get(key%10) == null) return -1;
        ArrayList<Node> valList = hm.get(key%10) ;
        
        for(Node n : valList){
            if(n.key == key) return n.value;
        }
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(hm.get(key%10) == null) return;
        ArrayList<Node> valList = hm.get(key%10) ;
        
        for(int i = 0 ; i < valList.size() ; i++){
            if(valList.get(i).key == key){
                valList.remove(i);
                return;
            }
        }
        
    }
}

class Node{
    int key;
    int value;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
