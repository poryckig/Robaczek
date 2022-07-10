package ObslugaPlikow;

import StrukturyDanych.RuchyInfo;

import java.io.*;
import java.util.ArrayList;

public class Pisacz {

    private File plikWyjsciowy;
    private ArrayList<RuchyInfo> ruchyInfo;

    public Pisacz (File plikWyjsciowy, ArrayList<RuchyInfo> ruchyInfo) throws FileNotFoundException {
        if (plikWyjsciowy != null && !plikWyjsciowy.canWrite())
            throw new FileNotFoundException("Nie można pisać do pliku wyjściowego.");
        this.plikWyjsciowy = plikWyjsciowy;
        this.ruchyInfo = ruchyInfo;
    }

    public void pisz() throws IOException {
        if (plikWyjsciowy == null)
            piszNaKonsole();
        else
            piszDoPliku();
    }

    private void piszDoPliku () throws IOException {
        Writer writer;
        if (plikWyjsciowy == null)
            writer = new OutputStreamWriter(System.out);
        else
            writer = new BufferedWriter(new FileWriter(plikWyjsciowy));

        for (RuchyInfo ruchInfo: ruchyInfo) {
            int liczbaRuchow = ruchInfo.getLiczbaRuchow();
            writer.append(liczbaRuchow + "\n");
            if (liczbaRuchow != -1)
                writer.append(ruchInfo.getKolejnoscRuchow() + "\n");
        }

        writer.flush();
    }

    private void piszNaKonsole() {
        for (RuchyInfo ruchInfo: ruchyInfo) {
            int liczbaRuchow = ruchInfo.getLiczbaRuchow();
            System.out.print(liczbaRuchow + "\n");
            if (liczbaRuchow != -1)
                System.out.print(ruchInfo.getKolejnoscRuchow() + "\n");
        }
    }
}
