/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.classic.dynamicProgramming;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Jimmy老鼠在时刻0从高于所有平台的某处开始下落，
 * 它的下落速度始终为1米/秒。当Jimmy落到某个平台上
 * 时，游戏者选择让它向左还是向右跑，它跑动的速度
 * 也是1米/秒。当Jimmy跑到平台的边缘时，开始继续下
 * 落。Jimmy每次下落的高度不能超过MAX米，不然就
 * 会摔死，游戏也会结束。
 *
 * 即Jimmy所在位置下方第一块板左
 * 端为起点到地面的最短时间，和右端为起点到地面的最短时间
 *
 * @author shiwenxiang
 * @version : HelpJimmy.java, v0.1 2020/12/4 shiwenxiang Exp $$
 */
public class HelpJimmy {


    private static int GAP;//最大跳跃高度超过死亡

    private static List<Position> positions = new ArrayList<>();

    public static void initData() {
        GAP = 20;
        positions.add(new Position(8, 8, 17));
        positions.add(new Position(0, 10, 13));
        positions.add(new Position(0, 10, 8));
        positions.add(new Position(4, 14, 3));
        positions.add(new Position(-20000, 20000, 0));
//        positions = positions.stream().sorted(Comparator.comparing(x -> x.H).reversed()).collect(Collectors.toList());
    }

    public static int findLeft(int index) {
        //找板子
        int i = index + 1;
        int lx = positions.get(index).LX;
        for (; i < positions.size(); i++) {
            if (positions.get(i).RX >= lx && lx >= positions.get(i).LX && positions.get(index).H - positions.get(i).H < GAP) {
                break;
            }
        }
        if (i == positions.size() - 1) {//找到的是地面
            if (positions.get(index).H - positions.get(i).H > GAP) {
                return Integer.MAX_VALUE;
            } else {
                return positions.get(index).H;
            }
        } else {
            int h = positions.get(index).H - positions.get(i).H;
            return h + Math.min(
                    findLeft(i) + positions.get(index).LX - positions.get(i).LX,
                    findRight(i) + positions.get(i).RX - positions.get(index).LX
            );
        }
    }

    public static int findRight(int index) {
        //找板子
        int i = index + 1;
        int rx = positions.get(index).RX;
        for (; i < positions.size(); i++) {
            if (positions.get(i).RX >= rx && rx >= positions.get(i).LX) {
                break;
            }
        }
        if (i == positions.size() - 1) {//找到的是地面
            if (positions.get(index).H - positions.get(i).H > GAP) {
                return Integer.MAX_VALUE;
            } else {
                return positions.get(index).H;
            }
        } else {
            int h = positions.get(index).H - positions.get(i).H;
            return h + Math.min(
                    findLeft(i) + positions.get(index).RX - positions.get(i).LX,
                    findRight(i) + positions.get(i).RX - positions.get(index).RX
            );
        }
    }

    public static void main(String[] args) {
        initData();
        StdOut.println(findLeft(0));
    }

    private static class Position {
        //左边缘
        int LX;
        //右边缘
        int RX;
        //高度
        int H;

        public Position(int LX, int RX, int H) {
            this.LX = LX;
            this.RX = RX;
            this.H = H;
        }
    }
}
