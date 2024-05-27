package com.keshav.Maths.BitwiseOperator;

public class SieveOfEratostheness_Primes {
    public static void main(String[] args) {
        int num = 37;
        boolean[] primes = new boolean[num+1];
        sieve(num, primes);
    }

    private static void sieve(int num, boolean[] primes) {
        for (int i = 2; i <= num/i; i++) {
            if (!primes[i]) {
                for (int j = i*2; j <= num; j += i) {
                    primes[j] = true;
                }
            }
        }
        for (int i = 2; i <= num; i++) {
            if (!primes[i]) {
                System.out.println(i + " ");
            }
        }
    }
}
