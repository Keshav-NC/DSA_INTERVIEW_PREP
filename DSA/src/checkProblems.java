public class checkProblems {
    public static void main(String[] args) {
//        rangeOfTwoThreeFour();
        kthBit(3);
    }

    static void rangeOfTwoThreeFour () {
        long n = (long) Math.pow (2, 31) - 1;
        long x = 1;
        long i = 0;
//        // for power of 3
//        while (x <= n) {
//            System.out.println(i);
//            i+=1;
//            x = (long) Math.pow (3, i);
//        }

//        // for power of 2
//        while (x <= n) {
//            System.out.println(i);
//            i += 1;
//            x = (long) Math.pow (2, i);
//        }

        // for power of 4
        while (x <= n) {
            System.out.println(i);;
            i += 1;
            x = (int) Math.pow (4, i);
        }
    }

    static void kthBit (int num) {
        System.out.println(Integer.toBinaryString(num));
    }


    static void decimalToBinary () {
        int n = 11;
        int t = n;
        String b = "";
        while (t > 0) {
            b = (t % 2) + b;
            t /= 2;
        }
        int count = 0;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '1') {
                count++;
            }
        }
        System.out.println(count);
    }

    static void reverseBinary () {
        String n = "00000010100101000001111010011100";
        String rev = "";
        for (int i=0;i<n.length();i++) {
            rev = n.charAt(i) + rev;
        }
    }


}
