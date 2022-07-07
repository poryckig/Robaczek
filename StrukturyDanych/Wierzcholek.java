package StrukturyDanych;

import java.util.ArrayList;

public class Wierzcholek {
    private int nr;
    private ArrayList<Integer> sasiedzi = new ArrayList<>();

    public Wierzcholek(int nr){
        this.nr = nr;
    }
    public Wierzcholek(int nr, ArrayList<Integer> sasiedzi){
        this.nr = nr;
        this.sasiedzi = sasiedzi;
    }

    int getNr(){
        return this.nr;
    }

    public ArrayList<Integer> getSasiedzi(){
        return this.sasiedzi;
    }
}
