package Default;

import ObslugaPlikow.Ladowacz;
import ObslugaPlikow.LadowaczBufferedReader;
import ObslugaPlikow.LadowaczScanner;
import ObslugaPlikow.Pisacz;
import StrukturyDanych.DrzewoZRobakiem;
import Algorytm.Algorytm;
import StrukturyDanych.RuchyInfo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        long poczatekCzasuLacznego = System.currentTimeMillis();

        long poczatekCzasuWczytywania = System.currentTimeMillis();
        // Wniosek: BufferedReader jest 2 razy szybsze niz Scanner.
        Ladowacz ladowacz = null;
        try {
            ladowacz = new LadowaczBufferedReader(args);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<DrzewoZRobakiem> drzewaZRobakiem = ladowacz.wczytajZawartoscPlikuWejsciowego();
        long koniecCzasuWczytywania = System.currentTimeMillis();
        System.out.println("Wczytywanie zajelo " + (koniecCzasuWczytywania-poczatekCzasuWczytywania) + " ms.");

        System.out.println();

        long poczatekCzasuAlgorytmu = System.currentTimeMillis();
        ArrayList<RuchyInfo> ruchyInfo = new ArrayList<>(drzewaZRobakiem.size());
        for (DrzewoZRobakiem drzewoZRobakiem: drzewaZRobakiem)
            ruchyInfo.add(new Algorytm(drzewoZRobakiem).wykonajAlgorytm());
        long koniecCzasuAlgorytmu = System.currentTimeMillis();
        System.out.println("Algorytm zajal " + (koniecCzasuAlgorytmu-poczatekCzasuAlgorytmu) + " ms.");

        long poczatekCzasuZapisywania = System.currentTimeMillis();
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
        long koniecCzasuZapisywania = System.currentTimeMillis();
        System.out.println("Zapisywanie zajelo " + (koniecCzasuZapisywania-poczatekCzasuZapisywania) + " ms.");

        System.out.println();

        long koniecCzasuLacznego = System.currentTimeMillis();
        System.out.println("Zajelo lacznie " + (koniecCzasuLacznego-poczatekCzasuLacznego) + " ms.");
        System.out.println("Bez wczytywania zajelo " + (koniecCzasuLacznego-poczatekCzasuAlgorytmu) + " ms.");
    }
}
