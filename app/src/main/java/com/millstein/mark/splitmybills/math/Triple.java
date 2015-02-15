package com.millstein.mark.splitmybills.math;

/**
 * Created by mark on 2/15/15.
 */
public class Triple {
    private int x;
    private int y;
    private int d;

    public Triple(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getD() {
        return d;
    }

    @Override
    public String toString() {
        return "Triple{" +
                "x=" + x +
                ", y=" + y +
                ", d=" + d +
                '}';
    }
}
