package pl.wikizabytki.classes;

import java.util.ArrayList;
import pl.wikizabytki.Main;

/**
 *
 * @author Pawel
 */
public class Gmina {
    public String name;
    public String powiat;
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
    
    public String URL() {
        return "Wikipedia:Wiki Lubi Zabytki/" + Main.VOIV + "/" + powiat + "/" + name;
    }
    
    public String show() {
        String text = "{{zabytki/góra\n";
            text += "| województwo = " + Main.VOIV_CODE + "\n";
            text += "| powiat      = " + powiat + "\n";
            text += "| gmina       = " + name + "\n";
            text += "}}\n";

        for(Monument m : monuments) text += m.show(-1);
        
        text += "|}";
        
        return text;
    }
}
