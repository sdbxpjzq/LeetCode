package 异或运算;

/**
 * 1. 相同的数异或为0: n ^ n => 0
 *
 * 2. 任何数于0异或为任何数 0 ^ n => n
 *
 * 3. 满足交换律:  a ^ b ^ c <=> a ^ c ^ b
 */
public class 异或运算规则 {
    public static void main(String[] args) {
        System.out.println(2 ^ 2); // 0 , 相同的数异或为0: n ^ n => 0
        // System.out.println(0 ^ 24); // 24,任何数于0异或为任何数 0 ^ n => n
        // System.out.println(2 ^ 4 ^ 2); // a ^ b ^ c <=> a ^ c ^ b
        // System.out.println(2 ^ 2 ^ 4); // a ^ b ^ c <=> a ^ c ^ b
    }
}
