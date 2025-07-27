package zuochengyun;

// 搜索算法
// 二分搜索

public class SearchAlgorithm {
    // 判断有序数组中是否存在指定数字 num 
    public static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length == 0) return false;
        int left = 0, right = arr.length - 1; mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);  // 避免溢出
            if (arr[mid] == num) return true;
            else if (arr[mid] > num) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
    // 搜索有序数组中大于等于指定数字 num 的最左侧位置
    public static int findLeft(int[] arr, int num) {
        int left = 0, right = arr.length - 1; mid = 0, ans = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] >= num) {
                ans = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return ans;
    }
    // 搜索有序数组中小于等于指定数字 num 的最右侧位置
    public static int findRight(int[] arr, int num) {
        int left = 0, right = arr.length - 1; mid = 0, ans = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] <= num) {
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return ans;
    }
    // 搜索不重复序列中的峰值位置
    // https://leetcode.cn/problems/find-peak-element
    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 0 || arr[0] > arr[1]) return 0;
        if (arr[n - 1] > arr[n - 2]) return n - 1;
        int left = 1, right = n - 2, mid = 0; ans = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid - 1] > arr[mid]) right = mid - 1;
            else if (arr[mid] < arr[mid + 1]) left = mid + 1;
            else {
                ans = mid;
                break;
            }
        }
        return ans;
    }
}