public class ReverseInteger {
    public static void main(String[] args) {
        int num = -2147483412;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverseInteger(num));
    }
    static int reverseInteger (int num) {
        long ans = 0;
        while (num != 0) {
            ans = ans * 10 + num % 10;
            num /= 10;
        }
        return (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) ? 0 : (int) ans;
    }

}
