package 线性表.链表.双指针技巧_强化;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 力扣373
 * medium
 */
public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> ((a[0]+a[1]) - (b[0]+b[1])));
        for (int i=0; i<nums1.length; i++){
            pq.add(new int[]{nums1[i], nums2[0], 0});
        }
        List<List<Integer>> res = new LinkedList<>();
        while (!pq.isEmpty() && k>0) {
            int[] cur = pq.poll();
            int index = cur[2];
            index++;
            if (index < nums2.length) {
                pq.add(new int[]{cur[0], nums2[index], index});
            }
            LinkedList<Integer> temp = new LinkedList<>();
            temp.addLast(cur[0]);
            temp.addLast(cur[1]);
            res.add(temp);
            k--;
        }
        return res;
    }
}
