package Ruchy;

import StrukturyDanych.DrzewoZRobakiem;

import java.util.ArrayList;
import java.util.LinkedList;

public class RuchDoOdgalezienia implements Ruch {

    private DrzewoZRobakiem drzewoZRobakiem;

    public RuchDoOdgalezienia(DrzewoZRobakiem drzewoZRobakiem) {
        this.drzewoZRobakiem = drzewoZRobakiem;
    }

    @Override
    public boolean ruszSie(LinkedList<Integer> ruchy, LinkedList<Integer> droga) {

        ArrayList<Integer> najdluzszeOdgalezienie = new ArrayList<>(); //BFS.getNajdluzszeOdgalezienie()

        if (najdluzszeOdgalezienie.size() == 0)
            return false;
        while (true) {
            int dlugosc = najdluzszeOdgalezienie.size();
            if (dlugosc == 0)
                break;

            // ruch do tylu
            int nastepnyWierzcholek = najdluzszeOdgalezienie.remove(dlugosc-1);
            drzewoZRobakiem.ruszSieDoTylu(nastepnyWierzcholek);
            ruchy.add(nastepnyWierzcholek);

            // sprawdz czy robak cofnal sie do kontynuowania drogi
            int pierwszyWierzcholekDrogi = droga.peek();
            int przod = drzewoZRobakiem.getPrzod();
            if (przod == pierwszyWierzcholekDrogi) {
                droga.remove();
                break;
            }
        }
        return true;
    }
}
