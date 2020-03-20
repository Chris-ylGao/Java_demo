package interview.Tree;

public class RebuildTree {

    public static TreeNode rebuild(int[] preorder, int[] inorder){
        if (preorder == null || inorder == null){
            return null;
        }

        TreeNode root = rebuild(preorder,0, preorder.length-1,inorder,0,inorder.length-1);
        return root;
    }
    private static TreeNode rebuild(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn){
        if (startIn > endIn || startPre > endPre) return null;
        TreeNode root = new TreeNode(preorder[startPre]);
        for(int i = startIn; i<= endIn; i++){
            // find the root node in the middle transversing.
            if (inorder[i] == preorder[startPre]){
                //the number of nodes in the left tree is i - startIn
                root.left = rebuild(preorder,startPre + 1,i - startIn + startPre, inorder,startIn,i-1);
                root.right = rebuild(preorder,startPre + i - startIn + 1, endPre, inorder, i+1, endIn);
                break;
            }
        }
        return root;
    }

    /**
     *          1
     *     2        3
     *   4      5       6
     *      7              8
     */

    public static void main(String[] args) {
        System.out.println(rebuild(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6}));
    }
}
