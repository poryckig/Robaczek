package StrukturyDanych;

public class DrzewoZRobakiem {

    //robak[0] - tyl, robak[2] - przod
    private int[] robak;
    private int docelowyPrzod, docelowyTyl;
    private Drzewo drzewo;

    public DrzewoZRobakiem(Drzewo drzewo, int[] abcd) {
        this.drzewo = drzewo;
        //BFS.utworzRobaka(robak, new int[]{abcd[0], abcd[2]});
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
        for (int i = 0; i < robak.length; i++)
            robakTmp[--j] = robak[i];
        robak = robakTmp;
    }

    public void zmienDocelowyKierunekRobaka() {
        int tmp = docelowyPrzod;
        docelowyPrzod = docelowyTyl;
        docelowyTyl = tmp;
    }

    public boolean czyDotarlTylemDoCelu() { return robak[0] == docelowyTyl ? true : false; }

    public boolean czyDotarlPrzodemDoCelu() { return robak[robak.length-1] == docelowyPrzod ? true : false; }

    public boolean czyDotarlDoCelu() { return czyDotarlTylemDoCelu() && czyDotarlPrzodemDoCelu(); }

    public void ruszSieDoTylu(int nowyWierzcholek) {
        for (int i = robak.length-1; i > 0; i--)
            robak[i] = robak[i-1];
        robak[0] = nowyWierzcholek;
    }

    public void ruszSieDoPrzodu(int nowyWierzcholek) {
        for (int i = 1; i < robak.length; i++)
            robak[i-1] = robak[i];
        robak[robak.length-1] = nowyWierzcholek;
    }

    public int[] getRobak() { return robak; }
}
