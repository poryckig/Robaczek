package WyznaczanieDrogi;

import StrukturyDanych.DrzewoZRobakiem;
import StrukturyDanych.Wierzcholek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BFSNajdluzszaDroga {

    private DrzewoZRobakiem drzewoZRobakiem;
    private int poczatek;
    private int liczbaWierzcholkow;
    private int[] poprzedniki;
    private int[] odleglosciDoWierzcholkow;
    private boolean[] czyOdwiedzono;
    private LinkedList<Integer> kolejka;

    public BFSNajdluzszaDroga(DrzewoZRobakiem drzewoZRobakiem, int poczatek) {
        this.drzewoZRobakiem = drzewoZRobakiem;
        this.poczatek = poczatek;
        inicjujWartosciPoczatkowe();
        wykonajBFS();
    }

    private void inicjujWartosciPoczatkowe() {
        liczbaWierzcholkow = drzewoZRobakiem.getDrzewo().getLiczbaWierzcholkow();
        poprzedniki = new int[liczbaWierzcholkow];
        odleglosciDoWierzcholkow = new int[liczbaWierzcholkow];
        czyOdwiedzono = new boolean[liczbaWierzcholkow];
        kolejka = new LinkedList<>();

        for (int i = 0; i < liczbaWierzcholkow; i++) {
            czyOdwiedzono[i] = false;
            odleglosciDoWierzcholkow[i] = Integer.MAX_VALUE;
            poprzedniki[i] = -1;
        }

        czyOdwiedzono[poczatek-1] = true;
        odleglosciDoWierzcholkow[poczatek-1] = 0;
        kolejka.add(poczatek);
    }

    private void wykonajBFS() {
        while (!kolejka.isEmpty()) {
            int numerAktualnegoWierzcholka = kolejka.remove();;
            ArrayList<Wierzcholek> graf = drzewoZRobakiem.getDrzewo().getGraf();
            Wierzcholek aktualnyWierzcholek = graf.get(numerAktualnegoWierzcholka-1);
            ArrayList<Integer> sasiedzi = aktualnyWierzcholek.getSasiedzi();

            for (int i = 0; i < sasiedzi.size(); i++) {
                int numerAktualnegoSasiada = sasiedzi.get(i);
                if (!czyOdwiedzono[numerAktualnegoSasiada-1] && drzewoZRobakiem.czyRobakLezyNaWierzcholku(numerAktualnegoSasiada-1)) {
                    czyOdwiedzono[numerAktualnegoSasiada-1] = true;
                    odleglosciDoWierzcholkow[numerAktualnegoSasiada-1] =
                            odleglosciDoWierzcholkow[numerAktualnegoWierzcholka-1] + 1;
                    poprzedniki[numerAktualnegoSasiada-1] = numerAktualnegoWierzcholka;
                    kolejka.add(numerAktualnegoSasiada);
                }
            }
        }
    }

    public LinkedList<Integer> wyznaczNajdluzszaDroge() {
        LinkedList<Integer> droga = new LinkedList<>();

        int aktualnyWierzcholek = wyznaczNajdalszyWierzcholek();
        if (aktualnyWierzcholek == -1)
            return droga;
        else
            droga.add(aktualnyWierzcholek);

        while ((aktualnyWierzcholek = poprzedniki[aktualnyWierzcholek-1]) != -1)
            droga.add(0, aktualnyWierzcholek);
        droga.remove();
        return droga;
    }

    public int wyznaczNajdalszyWierzcholek() {
        int maksIndeks = -2;
        int maksOdleglosc = -1;
        for (int i = 0; i < liczbaWierzcholkow; i++)
            if (odleglosciDoWierzcholkow[i] > maksOdleglosc && odleglosciDoWierzcholkow[i] != Integer.MAX_VALUE)
                maksIndeks = i;
        return maksIndeks +1;
    }
}
