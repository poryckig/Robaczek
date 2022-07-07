package Ruchy;

import StrukturyDanych.DrzewoZRobakiem;

import java.util.ArrayList;

public class RuchDoOdgalezienia implements Ruch {

    private DrzewoZRobakiem drzewoZRobakiem;

    public RuchDoOdgalezienia(DrzewoZRobakiem drzewoZRobakiem) {
        this.drzewoZRobakiem = drzewoZRobakiem;
    }

    @Override
    public void ruszSie(ArrayList<Integer> ruchy) {

    }

    @Override
    public boolean czyRuchMozliwy() {
        return false;
    }
}
