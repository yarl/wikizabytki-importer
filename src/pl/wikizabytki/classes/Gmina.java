package pl.wikizabytki.classes;

import java.util.ArrayList;

/**
 *
 * @author Pawel
 */
public class Gmina {
    public String name;
    public ArrayList<Monument> list = new ArrayList<>();
    
    public Gmina(String name) {
        this.name = name;
    }
}
