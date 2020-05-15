package amazon;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int test_cases = input.nextInt();
        for (int i = 1; i <= test_cases; i++) {
            System.out.println(String.format("Case #%d: %s", i, getPeakNos(input)));
        }

    }

    public static int getPeakNos(Scanner input) {
        int size = input.nextInt();
        if (size == 2 || size == 1) {
            return 0;
        }
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        int peaks = 0;
        int index = 1;
        while (index < size - 1) {
            if (arr[index] > arr[index - 1] && arr[index] > arr[index + 1]) {
                peaks ++;
                index+=2;
            } else {
                index++;

            }

        }

        return peaks;

    }

}