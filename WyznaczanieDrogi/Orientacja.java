package WyznaczanieDrogi;

import StrukturyDanych.Drzewo;
import StrukturyDanych.DrzewoZRobakiem;

import java.util.LinkedList;

public class Orientacja {

    private DrzewoZRobakiem drzewoZRobakiem;
    private LinkedList<Integer> drogaPrzodPrzod, drogaPrzodTyl, drogaTylPrzod, drogaTylTyl;

    public Orientacja(DrzewoZRobakiem drzewoZRobakiem) {
        this.drzewoZRobakiem = drzewoZRobakiem;
    }

    public LinkedList<Integer> getDrogaDlaRobaka() { return drogaPrzodPrzod; }
    public  void wyznaczOrientacjeRobaka() {
        Drzewo drzewo = drzewoZRobakiem.getDrzewo();
        BFSNajkrotszaDroga odPrzodu = new BFSNajkrotszaDroga(drzewo, drzewoZRobakiem.getPrzod());
        BFSNajkrotszaDroga odTylu = new BFSNajkrotszaDroga(drzewo, drzewoZRobakiem.getTyl());

        drogaPrzodPrzod = odPrzodu.wyznaczNajkrotszaDroge(drzewoZRobakiem.getDocelowyPrzod());
        drogaPrzodTyl = odPrzodu.wyznaczNajkrotszaDroge(drzewoZRobakiem.getDocelowyTyl());
        drogaTylPrzod = odTylu.wyznaczNajkrotszaDroge(drzewoZRobakiem.getDocelowyPrzod());
        drogaTylTyl = odTylu.wyznaczNajkrotszaDroge(drzewoZRobakiem.getDocelowyTyl());

        int sumaDoPrzodu = drogaPrzodPrzod.size() + drogaTylPrzod.size();
        int sumaDoTylu = drogaPrzodTyl.size() + drogaTylTyl.size();

        ustawPolozenieDocelowe(sumaDoPrzodu,sumaDoTylu);
        ustawPolozeniePoczatkowe();
    }

    private void ustawPolozenieDocelowe(int sumaDoPrzodu, int sumaDoTylu) {
        // polozenie docelowe - zle
        if (sumaDoTylu > sumaDoPrzodu ) {
            drzewoZRobakiem.zmienDocelowyKierunekRobaka();
            LinkedList<Integer> tmp;

            tmp = drogaPrzodPrzod;
            drogaPrzodPrzod = drogaPrzodTyl;
            drogaPrzodTyl = tmp;

            tmp = drogaTylPrzod;
            drogaTylPrzod = drogaTylTyl;
            drogaTylTyl = tmp;
        }
    }

    private void ustawPolozeniePoczatkowe() {
        // polozenie poczatkowe - zle
        if (drogaPrzodTyl.size() > drogaTylTyl.size()) {
            drzewoZRobakiem.zmienKierunekRobaka();
            LinkedList<Integer> tmp;

            tmp = drogaPrzodPrzod;
            drogaPrzodPrzod = drogaTylPrzod;
            drogaTylPrzod = tmp;

            tmp = drogaPrzodTyl;
            drogaPrzodTyl = drogaTylTyl;
            drogaTylTyl = tmp;
        }
    }
}
