package Ruchy;

import StrukturyDanych.DrzewoZRobakiem;
import WyznaczanieDrogi.BFSNajkrotszaDroga;

import java.util.LinkedList;

public class Czolgacz {

    private final DrzewoZRobakiem drzewoZRobakiem;
    private final LinkedList<Integer> ruchy;
    private final Ruch zwyklyRuch, ruchDoOdgalezienia;

    public Czolgacz(DrzewoZRobakiem drzewoZRobakiem) {
        this.drzewoZRobakiem = drzewoZRobakiem;
        ruchy = new LinkedList<>();
        zwyklyRuch = new RuchDoPrzodu(drzewoZRobakiem);
        ruchDoOdgalezienia = new RuchDoOdgalezienia(drzewoZRobakiem);
    }

    public void czolgajSie(LinkedList<Integer> drogaDlaRobaka) {
        drogaDlaRobaka.remove(0);

        boolean czyZmienionoStrony = false;
        while (!drzewoZRobakiem.czyDotarlDoCelu()) {
            if (!zwyklyRuch.ruszSie(ruchy, drogaDlaRobaka) && !ruchDoOdgalezienia.ruszSie(ruchy, drogaDlaRobaka)) {
                ruchy.clear();
                break;
            }
            if (!czyZmienionoStrony && drzewoZRobakiem.czyDotarlPrzodemDoCelu()) {
                czyZmienionoStrony = true;
                drzewoZRobakiem.zmienKierunekRobaka();
                drzewoZRobakiem.zmienDocelowyKierunekRobaka();
                drogaDlaRobaka = new BFSNajkrotszaDroga(drzewoZRobakiem.getDrzewo(), drzewoZRobakiem.getPrzod()).wyznaczNajkrotszaDroge(drzewoZRobakiem.getDocelowyPrzod());
                drogaDlaRobaka.remove();
            }
        }
    }

    public LinkedList<Integer> getRuchy() { return ruchy; }

    public int getLiczbaRuchow() {
        return ruchy.size() == 0 ? -1 : ruchy.size();
    }

    public String getKolejnoscRuchow() {
        StringBuilder sb = new StringBuilder();
        if (getLiczbaRuchow() != -1)
            ruchy.forEach(r -> sb.append(r).append(" "));
        return sb.toString();
    }
}
