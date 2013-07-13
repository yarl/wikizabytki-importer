package pl.wikizabytki.classes;

import java.io.IOException;
import java.util.ArrayList;
import javax.security.auth.login.LoginException;
import javax.swing.tree.DefaultMutableTreeNode;
import pl.wikizabytki.Main;

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
    
    public String URL() {
        return "Wikipedia:Wiki Lubi Zabytki/" + Main.VOIV + "/" + name;
    }
    
    public String getWikiCode() {
        String text = "{{mapa obiektów}}\n\n";
        for(Gmina g : gminas) text += "{{/" + g.name + "}}\n";
        return text;
    }
    
    public void uploadWiki() {
        try {
            Main.wiki.edit(URL(), getWikiCode(), "import zabytków");
            Main.log.green(Main.VOIV + "/" + name + ": uploaded!\n");
            for(Gmina g : gminas) g.uploadWiki();
        } catch (IOException | LoginException ex) {
            Main.log.red(ex.getLocalizedMessage() + "\n");
        }
    }
    
    public void createTree() {
        DefaultMutableTreeNode powiat = new DefaultMutableTreeNode(name);
        Main.model.insertNodeInto(powiat, Main.top, Main.top.getChildCount());
        for(Gmina g : gminas)
            Main.model.insertNodeInto(new DefaultMutableTreeNode(g.name), powiat, gminas.indexOf(g));
    }
}
