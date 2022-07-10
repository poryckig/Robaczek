package Algorytm;

import Ruchy.Czolgacz;
import StrukturyDanych.DrzewoZRobakiem;
import StrukturyDanych.RuchyInfo;
import WyznaczanieDrogi.Orientacja;

import java.util.LinkedList;

public class Algorytm {

    private final DrzewoZRobakiem drzewoZRobakiem;

    public Algorytm(DrzewoZRobakiem drzewoZRobakiem){
        this.drzewoZRobakiem = drzewoZRobakiem;
    }

    public RuchyInfo wykonajAlgorytm() {

        Orientacja orientacja = new Orientacja(drzewoZRobakiem);
        orientacja.wyznaczOrientacjeRobaka();
        LinkedList<Integer> drogaDlaRobaka = orientacja.getDrogaDlaRobaka();

        Czolgacz czolgacz = new Czolgacz(drzewoZRobakiem);
        czolgacz.czolgajSie(drogaDlaRobaka);

        int liczbaRuchow = czolgacz.getLiczbaRuchow();
        String kolejnoscRuchow = czolgacz.getKolejnoscRuchow();

        return new RuchyInfo(liczbaRuchow, kolejnoscRuchow);
    }

}
