package util;

import static java.lang.Math.max;

public class BinaryTree<T extends Comparable<T>> {

    private BiNode root;
    private int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public int depth() {
        return depth(root, 0);
    }

    private int depth(BiNode n, int current) {
        if (n == null || n.isLeaf()) return current;
        return max(depth(n.left, current+1), depth(n.right, current+1));
    }

    public boolean isFull() {
        if (((size+1) & size) != 0) return false; // only if size is one less than a power of two
        return isFullImpl(root);
    }

    private boolean isFullImpl(BiNode n) {
        if (n.isLeaf()) return true;
        if (n.right == null || n.left == null) return false;
        return isFullImpl(n.left) && isFullImpl(n.right);
    }

    private BiNode traverse(BiNode n, T val) {
        return (val.compareTo(n.val)) <= 0 ? n.left : n.right;
    }

    public void add(T t) {
        if (root == null) {
            root = new BiNode(t, null, null, null);
            size++;
        } else {
            BiNode n = root;
            while (true) {
                BiNode next = traverse(n, t);
                if (next == null) {
                    BiNode add = new BiNode(t, n, null, null);
                    if (t.compareTo(n.val) <= 0) n.left = add;
                    else n.right = add;
                    size++;
                    return;
                }
                n = next;
            }
        }
    }

    public boolean contains(T t) {
        BiNode n = root;
        while (n != null) {
            if (n.val.equals(t)) return true;
            n = traverse(n, t);
        }
        return false;
    }

    public boolean remove(T t) {
        BiNode n = root;
        while (n != null) {
            if (n.val.equals(t)) {
                if (n.isLeaf()) {
                    if (n.parent != null) {
                        if (n.parent.left == n) n.parent.left = null;
                        else n.parent.right = null;
                    } else {
                      root = null;
                    }
                    size--;
                    return true;
                } else if (n.right != null && n.left == null) {
                    if (n.parent != null) {
                        if (n.parent.left == n) {
                            n.parent.left = n.right;
                        } else {
                            n.parent.right = n.right;
                        }
                        size--;
                        return true;
                    }
                } else if (n.right == null && n.left != null) {
                    if (n.parent != null) {
                        if (n.parent.left == n) {
                            n.parent.left = n.left;
                        } else {
                            n.parent.right = n.left;
                        }
                        size--;
                        return true;
                    }
                } else {
                    return false; // cannot be deleted unambiguously
                }
            }
            n = traverse(n, t);
        }
        return false;
    }


    private class BiNode {
        T val;
        BiNode parent;
        BiNode left;
        BiNode right;

        BiNode(T val, BiNode parent, BiNode left, BiNode right) {
            this.val = val;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }
}
