public class ATOI {
    public static void main(String[] args) {
        String string = "-321a";
        System.out.println(atoi(string));
    }

    static int atoi (String string) {
        int ans = 0;
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            int n = letter - '0';
            if (n >=0 && n <= 9 || n == 43 || n == 45) {
                ans = ans * 10 + n;
            }
        }
        return ans;
    }
}
