package Ruchy;

import java.util.ArrayList;
import java.util.LinkedList;

public interface Ruch {
    public void ruszSie(ArrayList<Integer> ruchy, LinkedList<Integer> droga);
    public boolean czyRuchMozliwy(LinkedList<Integer> droga);
}
