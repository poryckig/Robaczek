package Ruchy;

import WyznaczanieDrogi.BFS;
import StrukturyDanych.DrzewoZRobakiem;

import java.util.LinkedList;

public class Czolgacz {

    private DrzewoZRobakiem drzewoZRobakiem;
    private LinkedList<Integer> ruchy;
    private Ruch zwyklyRuch, ruchDoOdgalezienia;

    public Czolgacz(DrzewoZRobakiem drzewoZRobakiem) {
        this.drzewoZRobakiem = drzewoZRobakiem;
        ruchy = new LinkedList<>();
        zwyklyRuch = new RuchDoPrzodu(drzewoZRobakiem);
        ruchDoOdgalezienia = new RuchDoOdgalezienia(drzewoZRobakiem);
    }

    public void czolgajSie(LinkedList<Integer> drogaDlaRobaka) {

        boolean czyZmienionoStrony = false;
        while (!drzewoZRobakiem.czyDotarlDoCelu()) {
            if (zwyklyRuch.ruszSie(ruchy, drogaDlaRobaka) || ruchDoOdgalezienia.ruszSie(ruchy, drogaDlaRobaka)) {
                System.out.println(ruchy);
            }
            else {
                ruchy.clear();
                break;
            }
            if (!czyZmienionoStrony && drzewoZRobakiem.czyDotarlPrzodemDoCelu()) {
                czyZmienionoStrony = true;
                drzewoZRobakiem.zmienKierunekRobaka();
            }
        }
    }

    public LinkedList<Integer> getRuchy() { return ruchy; }

    public int getLiczbaRuchow() {
        return ruchy.size() == 0 ? -1 : ruchy.size();
    }
}
