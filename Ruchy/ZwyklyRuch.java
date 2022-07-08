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
    public void ruszSie(ArrayList<Integer> ruchy, LinkedList<Integer> droga) {

    }

    @Override
    public boolean czyRuchMozliwy(LinkedList<Integer> droga) {
        return false;
    }
}
