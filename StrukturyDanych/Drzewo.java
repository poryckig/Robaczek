package StrukturyDanych;

import java.util.ArrayList;

public class Drzewo {
    private final int liczbaWierzcholkow;
    private final ArrayList<Wierzcholek> graf;

    public Drzewo(int liczbaWierzcholkow){
        this.liczbaWierzcholkow = liczbaWierzcholkow;
        graf = new ArrayList<>(liczbaWierzcholkow);
        wypelnijGraf();
    }

    private void wypelnijGraf() {
        for (int i = 0; i < liczbaWierzcholkow; i++)
            graf.add(new Wierzcholek(i+1));
    }

    public int getLiczbaWierzcholkow(){
        return this.liczbaWierzcholkow;
    }

    public ArrayList<Wierzcholek> getGraf(){
        return this.graf;
    }
}
