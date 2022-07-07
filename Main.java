import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Ladowacz ladowacz = null;
        try {
            ladowacz = new Ladowacz(args);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<DrzewoZRobakiem> drzewaZRobakiem = ladowacz.wczytajZawartoscPlikuWejsciowego();
        for (DrzewoZRobakiem drzewoZRobakiem: drzewaZRobakiem)
            new Algorytm(drzewoZRobakiem).wykonajAlgorytm();

        /*
        Pisacz pisacz = null;
        try {
            pisacz = new Pisacz(ladowacz.getPlikWyjsciowy());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            pisacz.piszDoPliku("ala", "ma", "kota");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */
    }
}
