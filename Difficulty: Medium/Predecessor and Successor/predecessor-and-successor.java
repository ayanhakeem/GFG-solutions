/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        Node curr=root;
        Node suc=null;
        Node pre=null;
        ArrayList<Node>ans=new ArrayList<>();
        
        while(curr!=null){
            if(key>=curr.data){
                curr=curr.right;
            }else{
                suc=curr;
                curr=curr.left;
            }
        }
        
        curr=root;
        while(curr!=null){
            if(key<=curr.data){
                curr=curr.left;
            }else{
                pre=curr;
                curr=curr.right;
            }
        }
        ans.add(pre);
        ans.add(suc);
        return ans;
        
    }
}