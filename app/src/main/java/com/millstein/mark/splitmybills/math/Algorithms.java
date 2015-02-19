package com.millstein.mark.splitmybills.math;

/**
 * Created by Mark on 2/12/15.
 */
public class Algorithms {

    public static int[] extendedEuclid(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0};
        }

        int[] result = extendedEuclid(b, a % b);
        int d = result[0];
        int x = result[2];
        int y = result[1] - (a / b) * result[2];
        return new int[] {d, x, y};
    }
}
