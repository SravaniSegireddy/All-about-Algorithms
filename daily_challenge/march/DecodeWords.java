class Solution {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        int res = 0;
        Arrays.sort(words, (a,b)-> b.length()-a.length());
        
        for(int i = 0 ; i < words.length; i++){
            
            String revString = new StringBuilder(words[i]).reverse().toString();
            
            if(!isSubString(root,revString )){
                res += words[i].length()+1;
                root.insert(revString);
            }
        }
        
        return res;
    }
    
    boolean isSubString(TrieNode root, String s){
        
        for(int i = 0 ;i < s.length(); i++){
            int index = s.charAt(i)-'a';
            if(root.arr[index] == null) return false;
            else root = root.arr[index];
        }
        return true;
    }
}



public class TrieNode{
    public TrieNode[] arr;
    public boolean isLast;

    public TrieNode(){
        this.arr = new TrieNode[26];
        isLast = false;
    }

    public void insert(String s){
        TrieNode tmp = this;

        for(int i = 0 ; i < s.length(); i++){
            int index = s.charAt(i)-'a';
            if(tmp.arr[index] == null){
                tmp.arr[index] = new TrieNode();
            }
            tmp = tmp.arr[index];
        }
        tmp.isLast = true;

    }

    public boolean search(String s){
        TrieNode tmp = this;

        for(int i = 0 ; i < s.length(); i++){
            int index = s.charAt(i)-'a';
            if(tmp.arr[index] == null){
                return false;
            }
            tmp = tmp.arr[index];
        }

        return tmp.isLast;
    }

    public void delete(String s){
        if(!this.search(s)) return;
        deleteUtil(s, 0, this);
    }

    public TrieNode deleteUtil(String s, int i, TrieNode root){
        if(i == s.length()){
            root.isLast = false;
            if(isEmpty(root))
                root = null;
            return root;
        }
        int index = s.charAt(i)-'a';

        root.arr[index] = deleteUtil(s, i+1, root.arr[index]);

        if(isEmpty(root) && root.isLast == false){
            root = null;
        }
        return root;
    }

    public boolean isEmpty(TrieNode root){
        for(int i = 0 ; i < 26; i++){
            if(root.arr[i] != null) return false;
        }
        return true;
    }
}
