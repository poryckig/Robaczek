package ObslugaPlikow;

import java.io.*;

public class Pisacz {

    File plikWyjsciowy;

    public Pisacz (File plikWyjsciowy) throws FileNotFoundException {
        if (!plikWyjsciowy.canWrite())
            throw new FileNotFoundException("Nie można pisać do pliku wyjściowego.");
        this.plikWyjsciowy = plikWyjsciowy;
    }

    public void piszDoPliku (String[] text) throws IOException {
        Writer writer = new BufferedWriter(new FileWriter(plikWyjsciowy));
        for (String s: text)
            writer.write(s + "\n");
        writer.close();
    }
}
