import java.util.ArrayList;

public class Drzewo {
    private int liczbaWierzcholkow;
    private ArrayList<Wierzcholek> graf  = new ArrayList<>();

    public Drzewo(int liczbaWierzcholkow){
        this.liczbaWierzcholkow = liczbaWierzcholkow;
    }

    public int getLiczbaWierzcholkow(){
        return this.liczbaWierzcholkow;
    }

    public ArrayList<Wierzcholek> getGraf(){
        return this.graf;
    }



}
