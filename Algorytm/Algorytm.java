package Algorytm;

import Ruchy.Czolgacz;
import StrukturyDanych.DrzewoZRobakiem;
import WyznaczanieDrogi.Orientacja;

import java.util.LinkedList;

public class Algorytm {

    private DrzewoZRobakiem drzewoZRobakiem;
    public Algorytm(DrzewoZRobakiem drzewoZRobakiem){
        this.drzewoZRobakiem = drzewoZRobakiem;
    }

    public void wykonajAlgorytm() {

        Orientacja orientacja = new Orientacja(drzewoZRobakiem);
        System.out.println("a");
        orientacja.wyznaczOrientacjeRobaka();
        System.out.println("b");
        LinkedList<Integer> drogaDlaRobaka = orientacja.getDrogaDlaRobaka();

        Czolgacz czolgacz = new Czolgacz(drzewoZRobakiem);
        czolgacz.czolgajSie(drogaDlaRobaka);

    }

}
