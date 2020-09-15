/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package org.algorithm.explore.tree;

/**
 * @author shiwenxiang
 * @version : TreeMaps.java, v0.1 2020/9/15 shiwenxiang Exp $$
 */
public class TreeMaps<K extends Comparable, V> {

    private static final boolean RED = true;

    private static final boolean BLACK = false;

    private TreeNode h;

    public TreeNode put(K k, V v) {
        if (h == null) {
            return new TreeNode(k, v, RED, 1);
        }
        int cmp = k.compareTo(h.key);
        if (cmp > 0) {
            h.right = put(k, v);
        } else if (cmp < 0) {
            h.left = put(k, v);
        } else {
            h.value = v;
        }
        if (isRed(h.right) && !isRed(h.left)) {
            rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        h.N = size(h.left) + size(h.right) + 1;
        return null;
    }

    private int size(TreeNode left) {
        return 0;
    }

    private void flipColors(TreeNode h) {

    }

    private void rotateRight(TreeNode h) {

    }

    private void rotateLeft(TreeNode h) {
    }


    public static class TreeNode<K extends Comparable, V> {
        K key;
        V value;
        TreeNode left;
        TreeNode right;
        Boolean color;
        int N;

        public TreeNode(K key, V value, Boolean color, int n) {
            this.key = key;
            this.value = value;
            this.color = color;
            N = n;
        }
    }

    public boolean isRed(TreeNode x) {
        if (x == null) return false;
        return x.color;
    }


}
