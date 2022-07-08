package Ruchy;

import StrukturyDanych.DrzewoZRobakiem;

import java.util.ArrayList;
import java.util.LinkedList;

public class Czolgacz {

    private DrzewoZRobakiem drzewoZRobakiem;
    private LinkedList<Integer> ruchy = new LinkedList<>();
    private Ruch zwyklyRuch, ruchDoOdgalezienia;

    public Czolgacz(DrzewoZRobakiem drzewoZRobakiem) {
        this.drzewoZRobakiem = drzewoZRobakiem;
        zwyklyRuch = new ZwyklyRuch(drzewoZRobakiem);
        ruchDoOdgalezienia = new RuchDoOdgalezienia(drzewoZRobakiem);
    }

    public void czolgajSie() {
        LinkedList<Integer> droga = new LinkedList<>(); // metoda BFS.getDroga()
        boolean czyZmienionoStrony = false;

        while (!drzewoZRobakiem.czyDotarlDoCelu()) {
            if (!zwyklyRuch.ruszSie(ruchy, droga) && !ruchDoOdgalezienia.ruszSie(ruchy, droga))
                break;
            if (!czyZmienionoStrony && drzewoZRobakiem.czyDotarlPrzodemDoCelu()) {
                czyZmienionoStrony = true;
                drzewoZRobakiem.zmienKierunekRobaka();
            }
        }
    }
}
