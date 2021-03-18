package _15_数学._大整数相加;

public class Solution_1 {
    public static void main(String[] args) {
        //   324+ 57

        String a = jisuan("999", "99");
        System.out.println(a);
    }

    private static String jisuan(String str1, String str2) {
        int maxLen = Math.max(str1.length(), str2.length());
        // 构建数组
        //zz 将数字放入数组中, 倒序存放,
        // 数组长度 = 较大数的位数 + 1
        int[] arr1 = new int[maxLen + 1];
        int[] arr2 = new int[maxLen + 1];
        for (int i = 0; i < str1.length(); i++) {
            // ASC码48就是'0'，也就是说'0'的值是48，而后依次是'1'到'9'。 这样正好是char型减去48就是它对应的int值。
            arr1[i] = str1.charAt(str1.length() - 1 - i) - '0';
        }
        for (int i = 0; i < str2.length(); i++) {
            // ASC码48就是'0'，也就是说'0'的值是48，而后依次是'1'到'9'。 这样正好是char型减去48就是它对应的int值。
            arr2[i] = str2.charAt(str2.length() - 1 - i) - '0';
        }

        // 进位
        int carry = 0;


        int[] res = new int[maxLen + 1];
        for (int i = 0; i < res.length; i++) {
            int tmp = arr1[i] + arr2[i] + carry;
            res[i] = tmp % 10;
            carry = tmp / 10;
        }

        //zz 再次倒序 输出, 去掉首部0
        StringBuilder str = new StringBuilder();
        for (int i = res.length - 1; i >= 0; i--) {
            // if (res[i] != 0) {
                str.append(res[i]);
            // }
        }
        return str.toString();
    }
}
