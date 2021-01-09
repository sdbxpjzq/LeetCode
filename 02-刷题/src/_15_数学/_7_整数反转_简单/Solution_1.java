package _15_数学._7_整数反转_简单;

public class Solution_1 {

    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;

        String xStr = Integer.toString(x);
        StringBuilder xStrBuilder = new StringBuilder();
        if (sign == -1) {
            xStrBuilder.append(xStr.substring(1));
        } else {
            xStrBuilder.append(xStr);
        }
        // 字符串反转
        xStrBuilder.reverse();
        if (sign==-1) {
            xStrBuilder.insert(0, "-");
        }
        // 防止溢出
        long l = Long.parseLong(xStrBuilder.toString());
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)l;
    }
}
