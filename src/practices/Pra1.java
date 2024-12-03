package practices;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

public class Pra1 {
    public static void mergeSort(int[] a, int n)
    {
        if(n<2)
        {
            return;
        }
        int mid = n/2;
        int[] I = new int[mid];
        int[] r = new int[n-mid];

        for(int i = 0; i<mid; i++)
        {
            I[i] = a[i];
        }
        for (int i = mid; i<n; i++)
        {
            r[i-mid] = a[i];
        }
        mergeSort(I, mid);
        mergeSort(r, n-mid);

        merge(a, I, r, mid, n-mid);
    }
    public static void merge(int[] a, int[] I, int[] r, int left, int right)
    {
        int i=0, j=0, k=0;
        while (i<left && j<right)
        {
            if(I[i] <= r[j])
            {
                a[k++] = I[i++];
            }
            else
            {
                a[k++] = r[j++];
            }
        }
        while (i<left)
        {
            a[k++] = I[i++];
        }
        while (j < right)
        {
            a[k++] = r[j++];
        }
    }
    public static int findInt(int[] array)
    {
        int index = 0;
        int update = array[index];
        while (search(array, update))
        {
            System.out.println("update = "+update);
            if(index<array.length)
            {
                update += 1;
            }
            else
            {
                break;
            }
            index++;
        }
        if(update>0)
        {
            return update;
        }
        else
        {
            while (update<=0)
            {
                update ++;
            }
            return update;
        }


    }
    public static boolean search(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left<=right)
        {
            mid = left+(right-left)/2;
            if(nums[mid]>target)
            {
                right = mid-1;
            }
            else if(nums[mid]<target)
            {
                left = mid+1;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] array = {-1, -3};//-1, -3, -6, -4, -1, -2
        Pra1.mergeSort(array, array.length);
        for(int a: array)
        {
            System.out.println(a);
        }
        System.out.println();
        int a = Pra1.findInt(array);
        System.out.println(a);

    }
}
