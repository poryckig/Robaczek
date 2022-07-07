package Algorytm;

import Ruchy.Czolgacz;
import StrukturyDanych.DrzewoZRobakiem;

public class Algorytm {

    private DrzewoZRobakiem drzewoZRobakiem;
    public Algorytm(DrzewoZRobakiem drzewoZRobakiem){
        this.drzewoZRobakiem = drzewoZRobakiem;
    }

    public void wykonajAlgorytm() {

        Czolgacz czolgacz = new Czolgacz(drzewoZRobakiem);
        czolgacz.czolgajSie();

    }

}
