package amazon;

/**
 * 
 * Idea behind the sqrt is to do the binary search of sqrt of 2 between 0 and x.
 */

import java.util.*;

public class SQRTNby2 {
    public static void main(String[] args) {
        System.out.println(sqrt(4));
        System.out.println(sqrt(16));
        System.out.println(sqrt(8));


    }

    public static long sqrt(int n) {
        long start = 0;
        long end = n;

        long mid = 0;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;

            if (mid * mid == n) {
                return mid;
            }

            else if (mid * mid < n) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(end * end == n){
            return end;
        }

        return start;

    }

}