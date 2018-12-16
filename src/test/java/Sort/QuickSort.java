package Sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new Random().nextInt(100);
        }
        qSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void qSort(int[] arr,int low,int high){

        if (low<high){
            int pivot  = partition(arr,low,high);//将数组通过一个轴枢划分为两部分
            qSort(arr,low,pivot-1);
            qSort(arr,pivot+1,high);
        }
    }

    public static int partition(int[] arr, int low ,int high){
        System.out.println(Arrays.toString(arr));
        int pivot = arr[low];

        while (low<high){

            while (low < high && arr[high]>pivot) high--;
            arr[low] = arr[high];
            while (low < high && pivot > arr[low]) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }



    public static void qqSort(int[] arr, int low, int high){
        if (low < high){
            int pivot = partition(arr,low,high);
            qqSort(arr,low,pivot-1);
            qqSort(arr,pivot+1,high);
        }
    }

    public static int partitions(int[] arr, int low, int high){
        int pivot = arr[low];
        while (low<high){
            while (low < high && arr[high]>= pivot) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

}
