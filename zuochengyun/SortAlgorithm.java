package zuochengyun;

// 排序算法
// selectionSort 选择排序：每次从剩余元素中选择最小的元素，放在正确的位置
// bubbleSort    冒泡排序：从前向后遍历，将较大的元素向后移动
// insertionSort 插入排序：从前向后遍历，将当前元素放在前面有序序列的正确位置

// Java API: import java.util.Arrays; \ Arrays.sort(arr);

public class SortAlgorithm {
    // 工具函数：交换数组中 i 和 j 位置的元素
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    // 选择排序
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int minIndex = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }
    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) swap(arr, i, i + 1);
            }
        }
    }
    // 插入排序
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) swap(arr, j, j + 1);
        }
    }
    // 归并排序
    // https://www.luogu.com.cn/problem/P1177
    public static int MAXN = 1000;
    public static int arr[] = new int[MAXN];
    public static int help[] = new int[MAXN];
    public static int n = 0;
    
    public static void merge(int left, int mid, int right) {
        int i = left;
        int a = left;
        int b = mid + 1;

        while (a <= mid && b <= right) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= mid) help[i++] = arr[a++];
        while (b <= right) help[i++] = arr[b++];

        for (i = left; i <= right; i++) arr[i] = help[i];
    }
    public static void mergeSortRecursion(int left, int right) {
        if (left == right) return;
        int mid = left + ((right - left) >> 1);
        mergeSortRecursion(left, mid);
        mergeSortRecursion(mid + 1, right);
        merge(left, mid, right);
    }
    public static void mergeSortIteration() {
        int n = arr.length;
        for (int currSize = 1; currSize < n; currSize *= 2) {
            // 从左到右合并子数组
            for (int leftStart = 0; leftStart < n - 1; leftStart += 2 * currSize) {
                int mid = Math.min(leftStart + currSize - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * currSize - 1, n - 1);
                merge(leftStart, mid, rightEnd);
            }
        }
    }
}