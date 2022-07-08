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

        int nastepnyWierzcholek = 0; //BFS.getWierzcholekDoNajdluzszegoOdgalezenia();
        if (nastepnyWierzcholek == -1)
            return false;

        drzewoZRobakiem.ruszSieDoTylu(nastepnyWierzcholek);
        ruchy.add(nastepnyWierzcholek);

        int pierwszyWierzcholekDrogi = droga.peek();
        int przod = drzewoZRobakiem.getPrzod();
        if (przod == pierwszyWierzcholekDrogi)
            droga.remove();

        return true;
    }
}
