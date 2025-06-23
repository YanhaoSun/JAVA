package 线性表.链表.双指针技巧_强化;

import java.util.PriorityQueue;

/**
 * 力扣378
 * medium
 */
public class KthSmallestElementInASortedMatrix {
    public class Element{
        int val;
        int i;
        int j;
        public Element(int val, int i, int j){
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Element> pq = new PriorityQueue<>(m, (a, b)->(a.val-b.val));
        for (int i=0; i<m; i++){
            Element ele = new Element(matrix[i][0], i, 0);
            pq.add(ele);
        }
        int count = 0;
        int res = 0;
        while (!pq.isEmpty() && count<k){
            Element temp = pq.poll();
            res = temp.val;
            int x = temp.i;
            int y = temp.j;
            if (x<m && y+1<n){
                pq.add(new Element(matrix[x][y+1], x, y+1));
            }
            count++;
        }
        return res;
    }
}
