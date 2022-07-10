package WyznaczanieDrogi;

import StrukturyDanych.Drzewo;
import StrukturyDanych.Wierzcholek;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSNajkrotszaDroga {

    private Drzewo drzewo;
    private int poczatek;
    private int liczbaWierzcholkow;
    private int[] poprzedniki;
    private int[] odleglosciDoWierzcholkow;
    private boolean[] czyOdwiedzono;
    private LinkedList<Integer> kolejka;

    public BFSNajkrotszaDroga(Drzewo drzewo, int poczatek) {
        this.drzewo = drzewo;
        this.poczatek = poczatek;
        inicjujWartosciPoczatkowe();
        wykonajBFS();
    }

    private void inicjujWartosciPoczatkowe() {
        liczbaWierzcholkow = drzewo.getLiczbaWierzcholkow();
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
            ArrayList<Wierzcholek> graf = drzewo.getGraf();
            Wierzcholek aktualnyWierzcholek = graf.get(numerAktualnegoWierzcholka-1);
            ArrayList<Integer> sasiedzi = aktualnyWierzcholek.getSasiedzi();

            for (int i = 0; i < sasiedzi.size(); i++) {
                int numerAktualnegoSasiada = sasiedzi.get(i);
                if (!czyOdwiedzono[numerAktualnegoSasiada-1]) {
                    czyOdwiedzono[numerAktualnegoSasiada-1] = true;
                    odleglosciDoWierzcholkow[numerAktualnegoSasiada-1] =
                            odleglosciDoWierzcholkow[numerAktualnegoWierzcholka-1] + 1;
                    poprzedniki[numerAktualnegoSasiada-1] = numerAktualnegoWierzcholka;
                    kolejka.add(numerAktualnegoSasiada);
                }
            }
        }
    }

    public LinkedList<Integer> wyznaczNajkrotszaDroge(int koniec) {

        LinkedList<Integer> droga = new LinkedList<>();
        int aktualnyWierzcholek = koniec;
        droga.add(aktualnyWierzcholek);
        while ((aktualnyWierzcholek = poprzedniki[aktualnyWierzcholek-1]) != -1)
            droga.add(0, aktualnyWierzcholek);
        return droga;
    }
}
