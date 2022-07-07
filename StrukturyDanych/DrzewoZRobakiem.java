package StrukturyDanych;

import StrukturyDanych.Drzewo;

public class DrzewoZRobakiem {
    private int a, b, c, d;
    private Drzewo drzewo;

    public DrzewoZRobakiem(Drzewo drzewo, int[] abcd) {
        this.drzewo = drzewo;
        a = abcd[0];
        b = abcd[1];
        c = abcd[2];
        d = abcd[3];
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    public Drzewo getDrzewo() {
        return drzewo;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setD(int d) {
        this.d = d;
    }
}
