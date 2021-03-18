package _01_数组._11_盛最多水的容器_中等;

public class Solution_1 {
    public int maxArea(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        int max = 0;
        while (left < right) {
            int h = Math.min(arr[left], arr[right]);
            max = Math.max(max, (right - left) * h);
            if (arr[left] < arr[right]) {
                left++;
            } else if (arr[left] > arr[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return max;
    }
}
