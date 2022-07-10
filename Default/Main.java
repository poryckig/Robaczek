package Default;

import ObslugaPlikow.Ladowacz;
import ObslugaPlikow.Pisacz;
import StrukturyDanych.DrzewoZRobakiem;
import Algorytm.Algorytm;
import StrukturyDanych.RuchyInfo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        long poczatekCzasu = System.currentTimeMillis();

        Ladowacz ladowacz = null;
        try {
            ladowacz = new Ladowacz(args);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<DrzewoZRobakiem> drzewaZRobakiem = ladowacz.wczytajZawartoscPlikuWejsciowego();

        System.out.println();

        ArrayList<RuchyInfo> ruchyInfo = new ArrayList<>(drzewaZRobakiem.size());
        for (DrzewoZRobakiem drzewoZRobakiem: drzewaZRobakiem)
            ruchyInfo.add(new Algorytm(drzewoZRobakiem).wykonajAlgorytm());

        Pisacz pisacz = null;
        try {
            pisacz = new ObslugaPlikow.Pisacz(ladowacz.getPlikWyjsciowy(), ruchyInfo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            pisacz.pisz();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long koniecCzasu = System.currentTimeMillis();
        System.out.println("Zajelo " + (koniecCzasu-poczatekCzasu) + " ms.");
    }
}
