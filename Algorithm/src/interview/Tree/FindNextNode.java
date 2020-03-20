package interview.Tree;

/**
 * find the next node in inorder transversiong
 *
 * 1. if the node has right subtree, then the next node is the right subtree's leftest node.
 * 2. if the node doesn't have right subtree, then the next node is it's parent node;
 * 3. if the node doesn't have right subtree, and it is the right node of its parent node,
 * then we can transversing up until find the node
 */
public class FindNextNode {
    public static TreeNode getNext(TreeNode node){
        TreeNode next = null;
        if (node == null) return null;
        //1. if the node has right subtree, then the next node is the right subtree's leftest node.
        if (node.right != null){
            TreeNode temp = node.right;
            while (temp.left !=null){
                temp = temp.left;
            }
            return temp;
        }else if(node.parent.left == node){
            //if the node doesn't have right subtree, and is the left node of its parent, then the next node is it's parent node;
            return node.parent;
        }else{
            TreeNode temp = node.parent;
            while (temp.parent != null){
                // root.parent == null
                if (temp.parent.right !=null && temp.parent.left == temp) return temp.parent.right;
                temp = temp.parent;
            }
        }
            return null;
        }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node1.parent=node0;
        node4.parent = node1;
        node4.left=node5;
        node4.right=node6;
        node5.parent = node4;
        node6.parent=node4;
        node2.parent=node0;
        node2.left=node7;
        node2.right=node8;
        node7.parent=node2;
        node8.parent=node2;
        System.out.println(getNext(node4).value); //6
        System.out.println(getNext(node5).value); //4
        System.out.println(getNext(node2)); //8
        System.out.println(getNext(node7).value); //2
        System.out.println(getNext(node8));
    }
}
