package Daily_Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//有重叠部分的区间都是连续的
//我们需要排序: 把每个数组的第一个element按照升序进行排列(下面有两种排序方法 1-使用comparator  2-使用mergeSort)
//我们把最终消除重叠后的结果存储在result中
//
//第一种情况：
//如果result最后一个数组的最后一个element 大于 当前数组的第一个element
//那么 int a = Max(result最后一个数组的最后一个element, 当前数组的第二个element),
//把 result最后一个数组的最后一个element 更新为 a
//
//第二种情况:
//如果result最后一个数组的最后一个element 小于 当前数组的第一个element
//那么把当前数组 add 进入 result 末尾
public class mergeIntervals
{

    public int[][] merge_1(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }



    public int[][] merge_2(int[][] intervals)
    {
        List<int[]> result = new ArrayList<int[]>();
        int[] tem = new int[2];

        mergeSort(intervals, intervals.length);

        for(int i=0; i<intervals.length; i++)
        {
            tem[0] = intervals[i][0];
            tem[1] = intervals[i][1];
            if(result.size()==0 || result.get(result.size()-1)[1]<tem[0])
            {
                result.add(new int[]{tem[0], tem[1]});
            }
            else
            {
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], tem[1]);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
    public static void mergeSort(int[][] a, int n)
    {
        if(n<2)
        {
            return;
        }
        int mid = n/2;
        int[][] l = new int[mid][2];
        int[][] r = new int[n-mid][2];
        for(int i=0; i<mid; i++)
        {
            l[i][0] = a[i][0];
            l[i][1] = a[i][1];
        }
        for(int i=mid; i<n; i++)
        {
            r[i-mid][0] = a[i][0];
            r[i-mid][1] = a[i][1];
        }
        mergeSort(l, mid);
        mergeSort(r, n-mid);

        mergeRecursive(a, l, r, mid, n-mid);
    }
    public static void mergeRecursive(int[][] a, int[][] l, int[][] r, int left, int right)
    {
        int i=0, j=0, k=0;
        while(i<left && j<right)
        {
            if(l[i][0]<=r[j][0])
            {
                a[k++] = l[i++];
            }
            else
            {
                a[k++] = r[j++];
            }
        }
        while(i<left)
        {
            a[k++] = l[i++];
        }
        while(j<right)
        {
            a[k++] = r[j++];
        }
    }
    public static void main(String[] args) {
        mergeIntervals first = new mergeIntervals();
//        int[][] firstResult_1 = first.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
//        for(int[] i: firstResult_1)
//        {
//            System.out.println(i[0]+", "+i[1]);
//        }
//
//        int[][] firstResult_2 = first.merge(new int[][]{{1,4},{4,5}});
//        for(int[] i: firstResult_2)
//        {
//            System.out.println(i[0]+", "+i[1]);
//        }
//
//        int[][] firstResult_3 = first.merge(new int[][]{{1,4}});
//        for(int[] i: firstResult_3)
//        {
//            System.out.println(i[0]+", "+i[1]);
//        }

//        int[][] firstResult_4 = first.merge(new int[][]{{1,4}, {1, 5}});
//        for(int[] i: firstResult_4)
//        {
//            System.out.println(i[0]+", "+i[1]);
//        }

        int[][] firstResult_5 = first.merge_2(new int[][]{{1,4}, {2, 3}});
        for(int[] i: firstResult_5)
        {
            System.out.println(i[0]+", "+i[1]);
        }
    }
}
