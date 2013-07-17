package pl.wikizabytki.classes;

import java.io.IOException;
import java.util.ArrayList;
import javax.security.auth.login.LoginException;
import pl.wikizabytki.Main;

/**
 *
 * @author Pawel
 */
public class Gmina {
    public String name;
    public String powiat;
    public ArrayList<Monument> monuments = new ArrayList<>();
    
    public Gmina(String name, int powiat) {
        this.name = name;
        this.powiat = Main.powiats.get(powiat).name;
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

    public String getWikiCode() {
        String text = "<includeonly>== " + name + "==</includeonly>\n{{edytuj|{{SUBST:FULLPAGENAME}}}}\n{{zabytki/góra\n";
            text += "| województwo = " + Main.VOIV_CODE + "\n";
            text += "| powiat      = " + powiat + "\n";
            text += "| gmina       = " + name + "\n";
            text += "}}\n";

        for(Monument m : monuments) text += m.getWikiCode(-1);
        text += "|}\n";
        return text;
    }
    
    public void uploadWiki() {
        try {
            Main.wiki.edit(URL(), getWikiCode(), "import zabytków");
            Main.log.green(Main.VOIV + "/" + powiat + "/" + name + ": uploaded!\n");
        } catch (IOException | LoginException ex) {
            Main.log.red(ex.getLocalizedMessage() + "\n");
        }
    }
}
