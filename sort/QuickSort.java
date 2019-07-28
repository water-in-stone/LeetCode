package leetcode.sort;

/**
 * @author baikal on 2019-03-07
 * @project Algorithm
 * 原地快速排序
 */
public class QuickSort {
    public static void quickSortHelp(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        // 保存一开始的pivot的索引
        int i = low;

        while (low < high) {
            //从后往前比较
            while (pivot <= arr[high] && low < high) {
                // 如果没有比关键值小的，比较下一个，直到有比pivot小的
                high--;
            }
            while (arr[low] <= pivot && low < high) {
                //如果没有比关键值大的，比较下一个，直到有比pivot大
                low++;
            }

            if (low < high) {
                swap(arr, high, low);
            }
        }
        // 最后将一开始的low处的值与两个哨兵的相遇处的值进行交换，确保左侧的数均小于pivot，右侧的值均大于pivot
        swap(arr, i, high);

        // 返回pivot节点
        return low;
    }

    public static void swap(int[] arr, int high, int low) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    public static void main(String[] args) {
        int[] array = {2, 8, 5, 6, 10, 5, 4, 6, 11, 15, 3};

        quickSortHelp(array);

        for (int s : array) {
            System.out.println(s);
        }
    }
}
