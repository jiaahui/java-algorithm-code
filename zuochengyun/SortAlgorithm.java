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
}