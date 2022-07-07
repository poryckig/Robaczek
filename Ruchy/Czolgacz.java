package Ruchy;

import StrukturyDanych.DrzewoZRobakiem;

import java.util.ArrayList;

public class Czolgacz {

    private DrzewoZRobakiem drzewoZRobakiem;
    private ArrayList<Integer> ruchy = new ArrayList<>();
    private Ruch zwyklyRuch, ruchDoOdgalezienia, ruchDoDopasowaniaNaKoniec;

    public Czolgacz(DrzewoZRobakiem drzewoZRobakiem) {
        this.drzewoZRobakiem = drzewoZRobakiem;
        zwyklyRuch = new ZwyklyRuch(drzewoZRobakiem);
        ruchDoOdgalezienia = new RuchDoOdgalezienia(drzewoZRobakiem);
        ruchDoDopasowaniaNaKoniec = new RuchDopasowanieNaKoniec(drzewoZRobakiem);
    }

    public void czolgajSie() {
        ArrayList<Integer> droga = new ArrayList<>(); // metoda
        boolean czyZmienionoStrony = false;

        while (!drzewoZRobakiem.czyDotarlDoCelu()) {
            if (zwyklyRuch.czyRuchMozliwy())
                zwyklyRuch.ruszSie(ruchy);
            else if (ruchDoOdgalezienia.czyRuchMozliwy())
                ruchDoOdgalezienia.ruszSie(ruchy);
            else
                break;
            if (!czyZmienionoStrony && drzewoZRobakiem.czyDotarlZADoCelu()) {
                czyZmienionoStrony = true;
                drzewoZRobakiem.zamienAZB();
            }
        }
    }
}
