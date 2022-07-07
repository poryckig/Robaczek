import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        if(args.length < 2){
            System.out.println("Prosze podac plik wejsciowy i wyjsciowy.");
            System.exit(0);
        }

        File plikWejsciowy = new File(args[0]);
        File plikWyjsciowy = new File(args[1]);

        Scanner scannerPlikWejsciowy;

        try {
            scannerPlikWejsciowy = new Scanner(plikWejsciowy);
        } catch (FileNotFoundException e) {
            System.out.println("Blad: Podano bledny plik wejsciowy.");
            throw new RuntimeException(e);
        }


        int liczbaDrzew = scannerPlikWejsciowy.nextInt();
        if(liczbaDrzew < 1 || liczbaDrzew > 7000){
            System.out.println("Blad: Podano liczbe drzew nie mieszczaca sie w zakresie.");
            System.exit(0);
        }

        System.out.println(liczbaDrzew);///////////

        int i, j, k, u, v, a, b, c, d;
        for(i=0; i<liczbaDrzew; i++){
            scannerPlikWejsciowy.nextLine();
            Drzewo drzewo = new Drzewo(scannerPlikWejsciowy.nextInt());
            scannerPlikWejsciowy.nextLine();
            if(drzewo.getLiczbaWierzcholkow() < 4 || drzewo.getLiczbaWierzcholkow() > 100000){
                System.out.println("Blad: Podano liczbe wierzcholkow nie mieszczaca sie w zakresie w drzewie: " + (i + 1));
                System.exit(0);
            }

            System.out.println(drzewo.getLiczbaWierzcholkow());/////////////////

            for(j=1; j<=drzewo.getLiczbaWierzcholkow(); j++){
                Wierzcholek wierzcholek = new Wierzcholek(j);
                drzewo.getGraf().add(wierzcholek);
            }

            for(k=0; k<drzewo.getLiczbaWierzcholkow() - 1; k++) {
                u = scannerPlikWejsciowy.nextInt();
                if (u < 1 || u > drzewo.getLiczbaWierzcholkow()) {
                    System.out.println("Blad: Podano numer wierzcholka nie mieszczacy sie w zakresie w drzewie: " + (i + 1) + ", krawedzi: " + (k + 1));
                    System.exit(0);
                }
                v = scannerPlikWejsciowy.nextInt();
                if (v < 1 || v > drzewo.getLiczbaWierzcholkow()) {
                    System.out.println("Blad: Podano numer wierzcholka nie mieszczacy sie w zakresie lub zla relacje wierzcholkow w drzewie: " + (i + 1) + ", krawedzi: " + (k + 1));
                    System.exit(0);
                }

                System.out.println(u + " " + v);

                if (!drzewo.getGraf().get(u - 1).getSasiedzi().contains(v) && !drzewo.getGraf().get(v - 1).getSasiedzi().contains(u)) {
                    drzewo.getGraf().get(u - 1).getSasiedzi().add(v);      //ustawiamy krawedz miedzy wierzcholkami
                    drzewo.getGraf().get(v - 1).getSasiedzi().add(u);      //jesli jeszcze takiej nie ustawilismy
                }                                                          //(krawedz u -- v == krawedz v -- u)

                scannerPlikWejsciowy.nextLine();
            }


            a = scannerPlikWejsciowy.nextInt();

            if(a < 1 || a > drzewo.getLiczbaWierzcholkow()){
                System.out.println("Blad: Podano koniec sciezki aktualnej nie mieszczacy sie w zakresie w drzewie: " + (i + 1));
                System.exit(0);
            }
            b = scannerPlikWejsciowy.nextInt();
            if(b < 1 || b > drzewo.getLiczbaWierzcholkow() || b == a){
                System.out.println("Blad: Podano koniec sciezki aktualnej nie mieszczacy sie w zakresie lub zla relacje koncow sciezki w drzewie: " + (i + 1));
                System.exit(0);
            }

            System.out.println(a + " " + b);

            scannerPlikWejsciowy.nextLine();

            c = scannerPlikWejsciowy.nextInt();
            if(c < 1 || c > drzewo.getLiczbaWierzcholkow()){
                System.out.println("Blad: Podano koniec sciezki koncowej nie mieszczacy sie w zakresie w drzewie: " + (i + 1));
                System.exit(0);
            }
            d = scannerPlikWejsciowy.nextInt();
            if(d < 1 || d > drzewo.getLiczbaWierzcholkow() || d == c){
                System.out.println("Blad: Podano koniec sciezki koncowej nie mieszczacy sie w zakresie lub zla relacje koncow sciezki w drzewie: " + (i + 1));
                System.exit(0);
            }

            System.out.println(c + " " + d);



            Algorytm algorytm = new Algorytm(a, b, c, d);
            //...



        }




        scannerPlikWejsciowy.close();
    }
}
