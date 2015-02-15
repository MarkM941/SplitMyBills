package com.millstein.mark.splitmybills.math;

/**
 * Created by mark on 
 * 2/15/15.
 */
public class Algorithms {

    public static Triple extendedEuclid(int a, int b) {
        if (b == 0)
            return new Triple(0, 1, a);

        Triple result = extendedEuclid(b, a % b);
        int d = result.getD();
        int m = result.getY();
        int n = result.getX() - (a / b) * result.getY();
        return new Triple(m, n, d);
    }
    
    public static Triple generateNewGCDSolution(int a, int b, int k, Triple pSolution) {
        int m = pSolution.getX();
        int n = pSolution.getY();
        int d = pSolution.getD();
        int newX = m + ((k * b) / d);
        int newY = n - ((k * a) / d);
        return new Triple(newX, newY, d);
    }
}
