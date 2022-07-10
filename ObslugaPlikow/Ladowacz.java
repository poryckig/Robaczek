package ObslugaPlikow;

import StrukturyDanych.DrzewoZRobakiem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface Ladowacz {
    ArrayList<DrzewoZRobakiem> wczytajZawartoscPlikuWejsciowego() throws IOException;
    String getKrokiWczytywania();
    File getPlikWejsciowy();
    File getPlikWyjsciowy();
}
