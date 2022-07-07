import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Ladowacz ladowacz = new Ladowacz(args);
        ArrayList<DrzewoZRobakiem> drzewaZRobakiem = ladowacz.wczytajZawartoscPlikuWejsciowego();
        for (DrzewoZRobakiem drzewoZRobakiem: drzewaZRobakiem)
            new Algorytm(drzewoZRobakiem).wykonajAlgorytm();
    }
}
