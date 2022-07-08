package Ruchy;

import StrukturyDanych.DrzewoZRobakiem;

import java.util.ArrayList;
import java.util.LinkedList;

public class ZwyklyRuch implements Ruch {

    private DrzewoZRobakiem drzewoZRobakiem;

    public ZwyklyRuch(DrzewoZRobakiem drzewoZRobakiem) {
        this.drzewoZRobakiem = drzewoZRobakiem;
    }

    @Override
    public boolean ruszSie(LinkedList<Integer> ruchy, LinkedList<Integer> droga) {

        int nastepnyWierzcholek = droga.peek();
        if (nastepnyWierzcholek == drzewoZRobakiem.getWierzcholekRobakaPrzedPrzodem())
            return false;

        droga.remove();
        drzewoZRobakiem.ruszSieDoPrzodu(nastepnyWierzcholek);
        ruchy.add(nastepnyWierzcholek);
        return true;
    }
}
