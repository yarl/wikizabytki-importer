package pl.wikizabytki.classes;

import java.util.ArrayList;

/**
 *
 * @author Pawel
 */
public class Powiat {
    public String name;
    public String wojewodztwo;
    public ArrayList<Gmina> gminy = new ArrayList<>();
    
    public Powiat(String name, String wojewodztwo) {
        this.name = name;
        this.wojewodztwo = wojewodztwo;
    }
}
