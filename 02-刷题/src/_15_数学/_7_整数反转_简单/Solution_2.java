package _15_数学._7_整数反转_简单;

public class Solution_2 {

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) res;
    }
}
