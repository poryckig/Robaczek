package StrukturyDanych;

public class RuchyInfo {

    private final int liczbaRuchow;
    private final String kolejnoscRuchow;

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
