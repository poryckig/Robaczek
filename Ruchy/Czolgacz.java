package Ruchy;

import StrukturyDanych.DrzewoZRobakiem;

import java.util.ArrayList;
import java.util.LinkedList;

public class Czolgacz {

    private DrzewoZRobakiem drzewoZRobakiem;
    private ArrayList<Integer> ruchy = new ArrayList<>();
    private Ruch zwyklyRuch, ruchDoOdgalezienia;

    public Czolgacz(DrzewoZRobakiem drzewoZRobakiem) {
        this.drzewoZRobakiem = drzewoZRobakiem;
        zwyklyRuch = new ZwyklyRuch(drzewoZRobakiem);
        ruchDoOdgalezienia = new RuchDoOdgalezienia(drzewoZRobakiem);
    }

    public void czolgajSie() {
        LinkedList<Integer> droga = new LinkedList<>(); // metoda
        boolean czyZmienionoStrony = false;

        while (!drzewoZRobakiem.czyDotarlDoCelu()) {
            if (zwyklyRuch.czyRuchMozliwy(droga))
                zwyklyRuch.ruszSie(ruchy, droga);
            else if (ruchDoOdgalezienia.czyRuchMozliwy(droga))
                ruchDoOdgalezienia.ruszSie(ruchy, droga);
            else
                break;
            if (!czyZmienionoStrony && drzewoZRobakiem.czyTylemDotarlDoCelu()) {
                czyZmienionoStrony = true;
                drzewoZRobakiem.zmienKierunekRobaka();
            }
        }
    }
}
