package Ruchy;

import BFS.BFS;
import StrukturyDanych.DrzewoZRobakiem;

import java.util.LinkedList;

public class Czolgacz {

    private DrzewoZRobakiem drzewoZRobakiem;
    private LinkedList<Integer> ruchy = new LinkedList<>();
    private Ruch zwyklyRuch, ruchDoOdgalezienia;

    public Czolgacz(DrzewoZRobakiem drzewoZRobakiem) {
        this.drzewoZRobakiem = drzewoZRobakiem;
        zwyklyRuch = new RuchDoPrzodu(drzewoZRobakiem);
        ruchDoOdgalezienia = new RuchDoOdgalezienia(drzewoZRobakiem);
    }

    public void czolgajSie() {
        int poczatek = drzewoZRobakiem.getPrzod();
        int koniec = drzewoZRobakiem.getDocelowyPrzod();
        LinkedList<Integer> droga = new BFS(drzewoZRobakiem, poczatek).wyznaczNajkrotszaDroge(koniec);

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
