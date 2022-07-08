package StrukturyDanych;

import java.util.ArrayList;
import java.util.Iterator;

public class Drzewo implements Iterable{
    private int liczbaWierzcholkow;
    private ArrayList<Wierzcholek> graf;

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

    @Override
    public Iterator iterator() {
        return graf.iterator();
    }
}
