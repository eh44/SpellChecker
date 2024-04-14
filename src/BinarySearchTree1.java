public class BinarySearchTree1 {

    private class TreeNode {

        int value;

        TreeNode lchild;

        TreeNode rchild;


        public TreeNode(int v) {

            value = v;

        }

    }


    private TreeNode root;


    public boolean search(int value) {

        return recursiveSearch(value, root);

    }


    private boolean recursiveSearch(int value, TreeNode subRoot) {

        if (subRoot == null) return false;

        if (subRoot.value == value) return true;

        if (subRoot.value < value) return recursiveSearch(value, subRoot.rchild);

        return recursiveSearch(value, subRoot.lchild);

    }


    public void insert(int value) {

        root = recursiveInsert(value, root);

    }


    private TreeNode recursiveInsert(int value, TreeNode subRoot) {

        if (subRoot == null) {

            TreeNode node = new TreeNode(value);

            return node;

        }

        if (subRoot.value < value) {

            subRoot.rchild = recursiveInsert(value, subRoot.rchild);

        } else {

            subRoot.lchild = recursiveInsert(value, subRoot.lchild);

        }

        return subRoot;

    }


    public void display() {

        recursiveDisplay(root);

    }


    private void recursiveDisplay(TreeNode subRoot) {

        if (subRoot == null) return;

        recursiveDisplay(subRoot.lchild);

        System.out.print(subRoot.value + " ");

        recursiveDisplay(subRoot.rchild);

    }


}
