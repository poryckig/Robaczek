package StrukturyDanych;

import WyznaczanieDrogi.BFSNajkrotszaDroga;

import java.util.Arrays;
import java.util.LinkedList;

public class DrzewoZRobakiem {

    //robak[0] - tyl, robak[2] - przod
    private int[] robak;
    private int docelowyPrzod, docelowyTyl;
    private final Drzewo drzewo;

    public DrzewoZRobakiem(Drzewo drzewo, int[] abcd) {
        this.drzewo = drzewo;
        LinkedList<Integer> wyznaczonyRobak = new BFSNajkrotszaDroga(drzewo, abcd[0]).wyznaczNajkrotszaDroge(abcd[1]);
        robak = wyznaczonyRobak.stream().mapToInt(e -> e).toArray();
        docelowyPrzod = abcd[2];
        docelowyTyl = abcd[3];
    }

    public Drzewo getDrzewo() {
        return drzewo;
    }

    public int getDocelowyPrzod() { return docelowyPrzod; }

    public int getDocelowyTyl() { return docelowyTyl;  }

    public int getPrzod() { return robak[robak.length-1]; }

    public int getWierzcholekRobakaPrzedPrzodem() { return robak[robak.length-2]; }

    public int getTyl() { return robak[0]; }

    public int getWierzcholekRobakaPrzedTylem() { return robak[1]; }

    public void zmienKierunekRobaka() {
        int[] robakTmp = new int[robak.length];
        int j = robak.length;
        for (int k : robak) robakTmp[--j] = k;
        robak = robakTmp;
    }

    public void zmienDocelowyKierunekRobaka() {
        int tmp = docelowyPrzod;
        docelowyPrzod = docelowyTyl;
        docelowyTyl = tmp;
    }

    public boolean czyDotarlTylemDoCelu() { return robak[0] == docelowyTyl; }

    public boolean czyDotarlPrzodemDoCelu() { return robak[robak.length-1] == docelowyPrzod; }

    public boolean czyDotarlDoCelu() { return czyDotarlTylemDoCelu() && czyDotarlPrzodemDoCelu(); }

    public void ruszSieDoTylu(int nowyWierzcholek) {
        if (robak.length - 1 >= 0) System.arraycopy(robak, 0, robak, 1, robak.length - 1);
        robak[0] = nowyWierzcholek;
    }

    public void ruszSieDoPrzodu(int nowyWierzcholek) {
        if (robak.length - 1 >= 0) System.arraycopy(robak, 1, robak, 0, robak.length - 1);
        robak[robak.length-1] = nowyWierzcholek;
    }

    public int[] getRobak() { return robak; }

    public void wypiszRobaka() {
        System.out.println("Robak: " + Arrays.toString(robak));
        System.out.println("Docelowy robak: " + docelowyTyl + "..." + docelowyPrzod);
    }

    public boolean czyRobakLezyNaWierzcholku(int wierzcholek) {
        return Arrays.stream(robak).anyMatch(w -> w == wierzcholek);
    }
}
