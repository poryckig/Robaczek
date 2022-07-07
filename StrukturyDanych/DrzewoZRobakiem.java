package StrukturyDanych;

public class DrzewoZRobakiem {
    /*
    a - przód robaka
    b - tył robaka
    c - docelowy przód robaka
    d - docelowy tył robaka
     */
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
/*
    public int getWierzcholek(char litera) {
        switch (litera) {
            case 'a': return getA();
            case 'b': return getB();
            case 'c': return getC();
            case 'd': return getD();
            default: return -1;
        }
    }
 */

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

    public void zamienAZB() {
        int tmp = a;
        a = b;
        b = tmp;
    }

    public void zamienCZD() {
        int tmp = c;
        c = d;
        d = tmp;
    }

    public boolean czyDotarlZADoCelu() { return a == c ? true : false; }

    public boolean czyDotarlZBDoCelu() { return b == d ? true : false; }

    public boolean czyDotarlDoCelu() { return czyDotarlZADoCelu() && czyDotarlZBDoCelu(); }
/*
    public void setWierzcholek(char litera, int nowyWierzcholek) {
        switch (litera) {
            case 'a':
                setA(nowyWierzcholek);
                break;
            case 'b':
                setB(nowyWierzcholek);
                break;
            case 'c':
                setC(nowyWierzcholek);
                break;
            case 'd':
                setD(nowyWierzcholek);
                break;
            default:
                throw new IllegalArgumentException("Nie ma takiego wierzchołka o literze: " + litera + ".");
        }
    }
 */
}
