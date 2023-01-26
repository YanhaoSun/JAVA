package array;

public class sortedSquares {
    //做法一: 使用merge sort解决问题
    //1-先给每个数平方
    //2-然后再用merge sort进行排序
    public static int[] sortedSquares1(int[] nums) {
        for(int i=0; i<nums.length; i++)
        {
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        mergeSort(nums, nums.length);
        return nums;
    }
    public static void mergeSort(int[] array, int n)
    {
        int mid=n/2;
        int[] l = new int[mid];
        int[] r = new int[n-mid];
        if(n<2)
        {
            return;
        }
        for(int i=0; i<mid; i++)
        {
            l[i] = array[i];
        }
        for(int i=mid; i<n; i++)
        {
            r[i-mid] = array[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n-mid);
        merge(array, l, r, mid, n-mid);
    }
    public static void merge(int[] array, int[] l, int[] r, int left, int right)
    {
        int i = 0 , j = 0, k = 0;
        while(i<left && j<right)
        {
            if(l[i]<=r[j])
            {
                array[k++] = l[i++];
            }
            else
            {
                array[k++] = r[j++];
            }
        }
        while(i<left)
        {
            array[k++] = l[i++];
        }
        while(j<right)
        {
            array[k++] = r[j++];
        }
    }

    //做法二: 使用双指针
    //1-i指向开头, j指向末尾
    //2-创建一个新数组result, 比较 array[i]*array[i] 和 array[j]*array[j], 把较大的存入result, 从后往前给result赋值
    public static int[] sortedSquares2(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int[] result = new int[nums.length];
        int k = result.length-1;
        while(i<=j)
        {
            int front = (int)Math.pow(nums[i], 2);
            int back = (int)Math.pow(nums[j], 2);
            if(front>back)
            {
                result[k--] = front;
                i++;
            }
            else
            {
                result[k--] = back;
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {-4,-1,0,3,10};
        int[] array1 = {-7,-3,2,3,11};
        int[] array2 = {0};
        //int[] result = sortedSquares.sortedSquares1(array2);
        int[] result = sortedSquares.sortedSquares2(array1);
        for(int a: result)
        {
            System.out.print(a+" ");
        }
    }
}
