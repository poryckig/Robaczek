package StrukturyDanych;

public class DrzewoZRobakiem {

    //robak[0] - tyl, robak[2] - przod
    private int[] robak = new int[3];
    private int docelowyPrzod, docelowyTyl;
    private Drzewo drzewo;

    public DrzewoZRobakiem(Drzewo drzewo, int[] abcd) {
        this.drzewo = drzewo;
        robak[0] = abcd[0];
        robak[2] = abcd[1];
        docelowyPrzod = abcd[2];
        docelowyTyl = abcd[3];
    }

    public Drzewo getDrzewo() {
        return drzewo;
    }

    public int getDocelowyPrzod() { return docelowyPrzod; }

    public int getDocelowyTyl() { return docelowyTyl;  }

    public int getPrzod() { return robak[2]; }

    public int getTyl() { return robak[0]; }

    public void zmienKierunekRobaka() {
        int tmp = robak[0];
        robak[0] = robak[1];
        robak[1] = tmp;
    }

    public void zmienDocelowyKierunekRobaka() {
        int tmp = docelowyPrzod;
        docelowyPrzod = docelowyTyl;
        docelowyTyl = tmp;
    }

    public boolean czyTylemDotarlDoCelu() { return robak[0] == docelowyTyl ? true : false; }

    public boolean czyDotarlPrzodemDoCelu() { return robak[2] == docelowyPrzod ? true : false; }

    public boolean czyDotarlDoCelu() { return czyTylemDotarlDoCelu() && czyDotarlPrzodemDoCelu(); }

    public void ruszSieDoTylu(int nowyWierzcholek) {
        for (int i = 2; i > 0; i--)
            robak[i] = robak[i-1];
        robak[0] = nowyWierzcholek;
    }

    public void ruszSieDoPrzodu(int nowyWierzcholek) {
        for (int i = 1; i < 3; i++)
            robak[i-1] = robak[i];
        robak[2] = nowyWierzcholek;
    }

    public int[] getRobak() { return robak; }
}
