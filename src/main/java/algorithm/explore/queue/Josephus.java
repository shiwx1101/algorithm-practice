package algorithm.explore.queue;
/**
 * Josephus问题。
 * 在这个古老的问题中，N个身陷绝境的人一致同意通过以下方式减少生存人数。
 * 他们围坐在一圈（位置记为0到N-1）并从第一个人开始报数，报到M的人会被杀死，知道最后一个人留下来。
 * 传说中Josephus找到了不会被杀死的位置。编写一个Queue的用例Josephus，从命令行接受N和M并打印出人们被杀死的顺序（这也将显示Josephus在圈中的位置）。
 *
 * 思路 两个队列互相进出
 * */

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Josephus {

    public int count(int m, int n) {
        List<Integer> man = Stream.iterate(0, x -> x + 1).limit(m).collect(Collectors.toList());
        Queue<Integer> from = new Queue<>();
        Queue<Integer> to = new Queue<>();
        man.forEach(from::enqueue);
        int index = 1;
        while (from.size() + to.size() > 1) {
            Integer de = from.dequeue();
            if (index % n != 0) {
                to.enqueue(de);
            }
            index++;
            if (from.isEmpty()) {
                Queue<Integer> c = from;
                from = to;
                to = c;
            }
        }
        System.out.println(index);
        return from.dequeue();
    }


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int count = new Josephus().count(1000000, 500);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
        System.out.println(count);
    }
}
