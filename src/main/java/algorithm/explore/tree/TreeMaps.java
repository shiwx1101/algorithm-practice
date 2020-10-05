/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.explore.tree;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author shiwenxiang
 * @version : TreeMaps.java, v0.1 2020/9/15 shiwenxiang Exp $$
 */
public class TreeMaps<K extends Comparable, V> {

    private static final boolean RED = true;

    private static final boolean BLACK = false;

    private TreeNode root;

    public void put(K k, V v) {
        root = put(root, k, v);
        root.color = BLACK;
    }

    public TreeNode put(TreeNode h, K k, V v) {
        if (h == null) {
            return new TreeNode(k, v, RED, 1);
        }
        int cmp = k.compareTo(h.key);
        if (cmp > 0) {
            h.right = put(h.right, k, v);
        } else if (cmp < 0) {
            h.left = put(h.left, k, v);
        } else {
            h.value = v;
        }
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    private int size(TreeNode left) {
        if (left == null) return 0;
        return size(left.right) + size(left.left) + 1;
    }

    private void flipColors(TreeNode h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private TreeNode rotateRight(TreeNode h) {
        TreeNode x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;

    }

    private TreeNode rotateLeft(TreeNode h) {

        TreeNode x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
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

    public static void main(String[] args) {
        TreeMaps<Integer, Integer> maps = new TreeMaps<>();
        Stream.of(1,2,3,4,5).collect(Collectors.toList()).forEach(it->{
            maps.put(it,it);
        });
        System.out.println("------------");
        System.out.println(maps.toString());
    }

}
