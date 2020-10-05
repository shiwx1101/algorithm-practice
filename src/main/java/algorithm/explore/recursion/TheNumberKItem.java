package algorithm.explore.recursion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.swap;

/**
 * O(n)复杂度 找出第K大的元素
 *
 * @author A
 */
public class TheNumberKItem<T extends Comparable> {


    public T find(List<T> a, int k) {
        if (a == null || a.size() == 0 || k < 1 || k > a.size()) {
            throw new IllegalArgumentException();
        }
        int to = a.size();
        return findRecursion(a, 0, to - 1, to - k);


    }

    private T findRecursion(List<T> a, int from, int to, int k) {
        T pivot = a.get(to);
        int i = from;
        int j = from;
        for (; i < to; i++) {
            if (pivot.compareTo(a.get(i)) > 0) {
                swap(a, i, j);
                j++;
            }
        }
        swap(a, j, to);
        if (j == k) {
            return a.get(j);
        } else if (j > k) {
            return findRecursion(a, from, j - 1, k);
        } else {
            return findRecursion(a, j + 1, to, k);
        }

    }

    public static void main(String[] args) {
        List<Integer> collect = Stream.of(5, 4, 6, 2, 1, -3, 7).collect(Collectors.toList());
        System.out.print(new TheNumberKItem<Integer>().find(collect, 7));

    }


}
