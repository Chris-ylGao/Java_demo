package interview.Tree;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    public TreeNode(int value){
        this.value = value;
        left = null;
        right = null;
        parent = null;
    }
    public String toString(){
        return value + ", left = " + left + ", right = " + right;
    }
}
