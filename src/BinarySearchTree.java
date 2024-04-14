import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> {

    private class TreeNode {
        E value;
        TreeNode lchild;
        TreeNode rchild;

        public TreeNode(E v) {
            value = v;
        }
    }

    private TreeNode root;

    public boolean search(E value) {
        return recursiveSearch(value, root);
    }

    private boolean recursiveSearch(E value, TreeNode subRoot) {
        if (subRoot == null)
            return false;
        if (subRoot.value.compareTo(value) == 0)
            return true;
        if (subRoot.value.compareTo(value) < 0)
            return recursiveSearch(value, subRoot.rchild);
        return recursiveSearch(value, subRoot.lchild);
    }

    public boolean insert(E value) {
        if (root == null) {
            root = new TreeNode(value);
            return true;
        }
        TreeNode parent = null;
        TreeNode current = root;
        while (current != null) {
            parent = current;
            if (value.compareTo(current.value) < 0) {
                current = current.lchild;
            } else if (value.compareTo(current.value) > 0) {
                current = current.rchild;
            } else {
                return false; // value already exists in the tree
            }
        }
        if (value.compareTo(parent.value) < 0) {
            parent.lchild = new TreeNode(value);
        } else {
            parent.rchild = new TreeNode(value);
        }
        return true;
    }

    public boolean remove(E value) {

        root = recursiveRemoval(value, root);
        try {
            return value != root.value;
        } catch (NullPointerException e) {
            return true;
        }
    }

    private TreeNode recursiveRemoval(E value, TreeNode subRoot) {
        if (subRoot == null) {
            return null;
        }
        if (value.compareTo(subRoot.value) < 0) {
            subRoot.lchild = recursiveRemoval(value, subRoot.lchild);
        } else if (value.compareTo(subRoot.value) > 0) {
            subRoot.rchild = recursiveRemoval(value, subRoot.rchild);
        } else {
            if (subRoot.lchild == null) {
                return subRoot.rchild;
            } else if (subRoot.rchild == null) {
                return subRoot.lchild;
            } else {
                TreeNode minNode = findMinNode(subRoot.rchild);
                subRoot.value = minNode.value;
                subRoot.rchild = recursiveRemoval(minNode.value, subRoot.rchild);
            }
        }
        return subRoot;
    }

    private TreeNode findMinNode(TreeNode node) {
        if (node.lchild == null) {
            return node;
        }
        return findMinNode(node.lchild);
    }


    private TreeNode findMin(TreeNode subRoot) {
        while (subRoot.lchild != null) {
            subRoot = subRoot.lchild;
        }
        return subRoot;
    }

    public void display(String message) {
        System.out.println(message);
        recursiveDisplay(root);
    }

    private void recursiveDisplay(TreeNode subRoot) {
        if (subRoot == null) return;
        recursiveDisplay(subRoot.lchild);
        System.out.print(subRoot.value + " ");
        recursiveDisplay(subRoot.rchild);
    }

    public int numberNodes() {
        return countNodes(root);
    }

    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.lchild) + countNodes(node.rchild);
    }


    public int numberLeafNodes() {
        return recursiveLeafNodes(0, root);
    }

    private int recursiveLeafNodes(int nodes, TreeNode subRoot) {
        if (subRoot == null) {
            return nodes;
        }
        if (subRoot.lchild == null && subRoot.rchild == null) {
            return nodes + 1;
        }
        return recursiveLeafNodes(nodes, subRoot.lchild) + recursiveLeafNodes(nodes, subRoot.rchild);
    }

    public int height() {
        return recursiveHeight(root);
    }

    private int recursiveHeight(TreeNode subRoot) {
        if (subRoot == null) {
            return -1;
        }
        int leftHeight = recursiveHeight(subRoot.lchild);
        int rightHeight = recursiveHeight(subRoot.rchild);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}



