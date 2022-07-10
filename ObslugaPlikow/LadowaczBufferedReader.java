package ObslugaPlikow;

import StrukturyDanych.Drzewo;
import StrukturyDanych.DrzewoZRobakiem;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LadowaczBufferedReader implements Ladowacz{

    private File plikWejsciowy = null;
    private File plikWyjsciowy = null;

    private int licznikLiniiPlikuWejsciowego = 0;
    private int licznikDrzewPlikuWejsciowego = 0;

    private final StringBuilder stringBuilder = new StringBuilder();

    public LadowaczBufferedReader(String[] args) throws FileNotFoundException {
        wczytajPliki(args);
    }

    public File getPlikWejsciowy() {
        return plikWejsciowy;
    }

    public File getPlikWyjsciowy() {
        return plikWyjsciowy;
    }

    private void wczytajPliki(String[] args) throws FileNotFoundException {

        if (args.length == 1) {
            plikWejsciowy = new File(args[0]);
            if (!plikWejsciowy.canRead())
                throw new FileNotFoundException("Nie można czytać z pliku wejściowego.");
        }
        else if (args.length > 1) {
            plikWejsciowy = new File(args[0]);
            plikWyjsciowy = new File(args[1]);
            if (!plikWejsciowy.canRead())
                throw new FileNotFoundException("Nie można czytać z pliku wejściowego.");
            if (!plikWyjsciowy.canWrite())
                throw new FileNotFoundException("Nie można pisać do pliku wyjściowego.");
        }
    }

    @Override
    public ArrayList<DrzewoZRobakiem> wczytajZawartoscPlikuWejsciowego() throws IOException {

        BufferedReader reader = otworzReader(plikWejsciowy);

        int liczbaDrzew = wczytajLiczbeDrzew(reader);
        ArrayList<DrzewoZRobakiem> drzewaZRobakiem = new ArrayList<>(liczbaDrzew);

        for (int i = 0; i < liczbaDrzew; i++) {
            Drzewo drzewo = wczytajDrzewo(reader);
            int[] abcd = wczytajWierzcholkiABCD(reader, drzewo);
            drzewaZRobakiem.add(new DrzewoZRobakiem(drzewo, abcd));
        }

        reader.close();
        return drzewaZRobakiem;
    }

    private BufferedReader otworzReader(File plik) {
        BufferedReader reader;
        if (plik == null)
            reader = new BufferedReader(new InputStreamReader(System.in));
        else {
            try {
                reader = new BufferedReader(new FileReader(plik));
            } catch (FileNotFoundException e) {
                System.out.println("Blad: Podano bledny plik wejsciowy.");
                throw new RuntimeException(e);
            }
        }
        return reader;
    }

    private int wczytajLiczbeDrzew(BufferedReader reader) {
        stringBuilder.append("\n");
        int liczbaDrzew = -1;
        try {
            liczbaDrzew = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        licznikLiniiPlikuWejsciowego++;
        if(liczbaDrzew < 1 || liczbaDrzew > 7000){
            System.out.println("Blad: Podano liczbe drzew nie mieszczaca sie w zakresie. Linia: " + licznikLiniiPlikuWejsciowego + ".");
            System.exit(0);
        }
        stringBuilder.append("Liczba drzew: ").append(liczbaDrzew);
        return liczbaDrzew;
    }

    private Drzewo wczytajDrzewo(BufferedReader reader) {

        int liczbaWierzcholkow = wczytajLiczbeWierzcholkowDrzewa(reader);
        Drzewo drzewo = new Drzewo(liczbaWierzcholkow);

        stringBuilder.append("Krawedzie: ");
        for(int k=0; k<drzewo.getLiczbaWierzcholkow() - 1; k++)
            wczytajKrawedz(reader, drzewo);

        return drzewo;
    }

    private void wczytajKrawedz(BufferedReader reader, Drzewo drzewo) {
        int[] krawedz;
        try {
            krawedz = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int u = krawedz[0];
        if (u < 1 || u > drzewo.getLiczbaWierzcholkow()) {
            System.out.println("Blad: Podano numer wierzcholka nie mieszczacy sie w zakresie w drzewie nr: "
                    + licznikDrzewPlikuWejsciowego + ". Linia: " + licznikLiniiPlikuWejsciowego + ".");
            System.exit(0);
        }
        int v = krawedz[1];
        licznikLiniiPlikuWejsciowego++;
        if (v < 1 || v > drzewo.getLiczbaWierzcholkow()) {
            System.out.println("Blad: Podano numer wierzcholka nie mieszczacy sie w zakresie w drzewie nr: "
                    + licznikDrzewPlikuWejsciowego + ". Linia: " + licznikLiniiPlikuWejsciowego + ".");
            System.exit(0);
        }

        stringBuilder.append(u).append(" ").append(v);

        if (!drzewo.getGraf().get(u - 1).getSasiedzi().contains(v) && !drzewo.getGraf().get(v - 1).getSasiedzi().contains(u)) {
            drzewo.getGraf().get(u - 1).getSasiedzi().add(v);      //ustawiamy krawedz miedzy wierzcholkami
            drzewo.getGraf().get(v - 1).getSasiedzi().add(u);      //jesli jeszcze takiej nie ustawilismy
        }
    }

    private int[] wczytajWierzcholkiABCD(BufferedReader reader, Drzewo drzewo) {
        stringBuilder.append("ab, cd:");
        int[] abcd = new int[4];
        for (int i = 0; i < 4; i+=2) {
            int[] paraWierzcholkow = wczytajPareWierzcholkowABLubCD(reader, drzewo);
            abcd[i] = paraWierzcholkow[0];
            abcd[i+1] = paraWierzcholkow[1];
        }
        return abcd;
    }

    private int[] wczytajPareWierzcholkowABLubCD(BufferedReader reader, Drzewo drzewo) {
        int[] paraWierzcholkow;
        try {
            paraWierzcholkow = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        licznikLiniiPlikuWejsciowego++;
        if(paraWierzcholkow[0] < 1 || paraWierzcholkow[0] > drzewo.getLiczbaWierzcholkow()){
            System.out.println("Blad: Podano koniec sciezki aktualnej nie mieszczacy sie w zakresie w drzewie nr: "
                    + licznikDrzewPlikuWejsciowego +". Linia: " + licznikLiniiPlikuWejsciowego + ".");
            System.exit(0);
        }

        licznikLiniiPlikuWejsciowego++;
        if(paraWierzcholkow[1] < 1 || paraWierzcholkow[1] > drzewo.getLiczbaWierzcholkow() || paraWierzcholkow[0] == paraWierzcholkow[1]){
            System.out.println("Blad: Podano koniec sciezki koncowej nie mieszczacy sie w zakresie lub zla relacje koncow sciezki w drzewie:nr: "
                    + licznikDrzewPlikuWejsciowego +". Linia: " + licznikLiniiPlikuWejsciowego + ".");
            System.exit(0);
        }

        stringBuilder.append(paraWierzcholkow[0]).append(" ").append(paraWierzcholkow[1]);
        return paraWierzcholkow;
    }

    private int wczytajLiczbeWierzcholkowDrzewa(BufferedReader reader) {
        int liczbaWierzcholkow = 0;
        try {
            liczbaWierzcholkow = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        licznikLiniiPlikuWejsciowego++;
        licznikDrzewPlikuWejsciowego++;
        Drzewo drzewo = new Drzewo(liczbaWierzcholkow);

        if(drzewo.getLiczbaWierzcholkow() < 4 || drzewo.getLiczbaWierzcholkow() > 100000){
            System.out.println("Blad: Podano liczbe wierzcholkow nie mieszczaca sie w zakresie w drzewie nr: "
                    + licznikDrzewPlikuWejsciowego + ". Linia: " + licznikLiniiPlikuWejsciowego + ".");
            System.exit(0);
        }
        stringBuilder.append("\nStrukturyDanych.Drzewo nr: ").append(licznikDrzewPlikuWejsciowego);
        stringBuilder.append("Liczba wierzcholkow drzewa: ").append(drzewo.getLiczbaWierzcholkow());

        return liczbaWierzcholkow;
    }

    public String getKrokiWczytywania(){ return stringBuilder.toString(); }

}
