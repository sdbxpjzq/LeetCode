package 递归和回溯;

public class 阶乘 {

    /**
     * 阶乘
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
