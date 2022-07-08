package WyznaczanieDrogi;

import StrukturyDanych.Drzewo;
import StrukturyDanych.DrzewoZRobakiem;
import StrukturyDanych.Wierzcholek;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {

    private Drzewo drzewo;
    private int poczatek;
    private int liczbaWierzcholkow;
    private int[] poprzedniki;
    private int[] odleglosciDoWierzcholkow;
    private boolean[] czyOdwiedzono;
    private LinkedList<Integer> kolejka;

    public BFS(Drzewo drzewo, int poczatek) {
        this.drzewo = drzewo;
        this.poczatek = poczatek;
        inicjujWartosciPoczatkowe();
        wykonajBFS();
    }

    public LinkedList<Integer> wyznaczNajkrotszaDroge(int koniec) {

        LinkedList<Integer> odwroconaDroga = wyznaczDrogeZPoprzednikow(koniec);
        LinkedList<Integer> prawidlowaDroga = odwrocDroge(odwroconaDroga);
        return prawidlowaDroga;
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

        czyOdwiedzono[poczatek] = true;
        odleglosciDoWierzcholkow[poczatek] = 0;
        kolejka.add(poczatek);
    }

    private void wykonajBFS() {
        while (!kolejka.isEmpty()) {
            System.out.println("c");
            int numerAktualnegoWierzcholka = kolejka.remove();
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

    private LinkedList<Integer> wyznaczDrogeZPoprzednikow(int koniec) {
        LinkedList<Integer> odwroconaDroga = new LinkedList<>();
        int aktualnyWierzcholek = koniec;
        odwroconaDroga.add(aktualnyWierzcholek);
        while ((aktualnyWierzcholek = poprzedniki[aktualnyWierzcholek]) != -1)
            odwroconaDroga.add(aktualnyWierzcholek);
        return odwroconaDroga;
    }

    private LinkedList<Integer> odwrocDroge(LinkedList<Integer> odwroconaDroga) {
        LinkedList<Integer> prawidlowaDroga = new LinkedList<>();
        for (int element: odwroconaDroga) {
            int pobranyElement = odwroconaDroga.remove(odwroconaDroga.size()-1);
            prawidlowaDroga.add(pobranyElement);
        }
        return prawidlowaDroga;
    }
}
