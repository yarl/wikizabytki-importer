package pl.wikizabytki.classes;

import java.util.ArrayList;

/**
 *
 * @author Pawel
 */
public class Powiat {
    public String name;
    public ArrayList<Gmina> gminas = new ArrayList<>();
    
    public Powiat(String name) {
        this.name = name;
    }
    
    public String show() {
        String text = "powiat " + name + "\n";
        for(Gmina g : gminas) text += g.show();
        return text;
    }
}
