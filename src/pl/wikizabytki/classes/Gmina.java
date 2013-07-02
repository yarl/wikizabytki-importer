package pl.wikizabytki.classes;

import java.util.ArrayList;

/**
 *
 * @author Pawel
 */
public class Gmina {
    public String name;
    public ArrayList<Monument> monuments = new ArrayList<>();
    
    public Gmina(String name) {
        this.name = name;
    }
    
    public void add(Monument m) {
        if(monuments.size()>=1) {
            Monument last = monuments.get(monuments.size()-1);
            if(m.isPart(last)) last.addPart(m);
            else monuments.add(m);
        } else monuments.add(m);
    }
    
    public String show() {
        String text = "\t gmina " + name + "\n";
        for(Monument m : monuments) text += m.show();
        return text;
    }
}
