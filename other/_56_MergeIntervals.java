package leetcode.other;

import java.util.*;

/**
 * @author baikal on 2019-03-08
 * @project Algorithm
 * 思路
 * 1. 先排序
 * 2. 排序后对list进行遍历，判断前后2个interval的start和end的关系
 */
public class _56_MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) {
            throw new Error("error");
        }
        // 按照start值进行排序
        intervals.sort((Interval o1, Interval o2) -> {
            if (o1.start < o2.start) {
                // -1代表false，表示不需要挪动位置
                return -1;
            } else if (o1.start == o2.start) {
                return 0;
            } else {
                // 1代表true，表示需要挪动位置
                return 1;
            }
        });
        List<Interval> res = new ArrayList<>();
        intervals.forEach(item -> {
            int size = res.size();
            if (size == 0) {
                // 第1次时直接
                res.add(item);
            } else {
                Interval last = res.get(size - 1);
                if (last.end >= item.start) {
                    // 进行合并
                    Interval newLast = new Interval(last.start, Math.max(last.end, item.end));
                    res.remove(size - 1);
                    res.add(newLast);
                } else {
                    // 不存在重合，直接添加
                    res.add(item);
                }
            }
        });

        return res;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(15, 18));
        intervals.add(new Interval(8, 10));

        List<Interval> res = merge(intervals);
        System.out.println(res);
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
