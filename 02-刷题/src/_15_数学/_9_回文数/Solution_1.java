package _15_数学._9_回文数;

public class Solution_1 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] xChar = s.toCharArray();
        int left = 0;
        int right = xChar.length - 1;
        while (left < right) {
            if (xChar[left] == xChar[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return  true;
    }
}
