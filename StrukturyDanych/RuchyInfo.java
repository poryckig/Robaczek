package StrukturyDanych;

public class RuchyInfo {

    private int liczbaRuchow;
    private String kolejnoscRuchow;

    public RuchyInfo (int liczbaRuchow, String kolejnoscRuchow) {
        this.liczbaRuchow = liczbaRuchow;
        this.kolejnoscRuchow = kolejnoscRuchow;
    }

    public int getLiczbaRuchow() {
        return liczbaRuchow;
    }

    public String getKolejnoscRuchow() {
        return kolejnoscRuchow;
    }
}
