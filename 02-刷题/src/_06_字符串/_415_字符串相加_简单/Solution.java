package _06_字符串._415_字符串相加_简单;

public class Solution {
    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int i = arr1.length-1;
        int j = arr2.length-1;

        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (i>=0 || j>=0) {
            int n1  = i>=0? Character.getNumericValue(arr1[i]) : 0;
            int n2  = j>=0? Character.getNumericValue(arr2[j]) : 0;
            int sum = n1+n2+carry;
            carry = sum/10;
            int val = sum % 10;
            result.append(val);

            i--;
            j--;
        }
        if (carry>0) {
            result.append(carry);
        }
        // 反转
        return result.reverse().toString();
    }
}
