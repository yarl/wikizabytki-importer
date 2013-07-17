package pl.wikizabytki.classes;

import java.util.ArrayList;

/**
 *
 * @author Pawel
 */
public class Monument {
    public int id;
    public String name;
    public String number; //aktualny numer rejestru
    
    public String gmina;
    public String town;
    public String street;

    public Material material;
    public String year;
    
    //group of monuments (zespół zabytków)
    public int partOf = -1;
    public ArrayList<Monument> parts = new ArrayList<>();
    public String hint; //określnie zespołu, np. 'przy dworcu kolejowym'
    
    public Monument(int id, String name, String number, String gmina, String town) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.gmina = gmina;
        this.town = town;
    }
    
    public Monument(String id, String name, String number, String gmina, String town, String street, int partOf, String hint, String year) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.number = number;
        this.gmina = gmina;
        this.town = town;
        this.street = street;
        this.partOf = partOf;
        this.hint = hint;
        this.year = year;
    }
    
    /**
     * Checks if monument in parameter is part of this monument complex
     * @param m
     * @return 
     */
    public boolean isPart(Monument m) {
        //if "parent" is not complex
        if(m.partOf == 1) return false;
        
        //first monument after complex should be in this complex
        if(m.parts.isEmpty()) return true;
        
        //match of register number
        if(!number.isEmpty() && m.number.equals(number)) return true;
        
        //hint contains text "part of"
        if(hint.contains("w zespole")) return true;
        
        //
        if(!m.parts.isEmpty() 
                && m.parts.get(0).name.contains("kościół")
                && hint.contains("przy "))
            return true;
        
        //match of streets
        if(!street.isEmpty() && m.street.equals(street)) return true;

        return false;
    }
       
    public void addPart(Monument m) {
        parts.add(m);
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public void setMaterial(String material) { 
        switch(material) {
            case "mur.":    this.material = Material.MUR; break;
            case "drewn.":  this.material = Material.DRE; break;
            case "szach.":  this.material = Material.SZACH; break;
            case "met.":    this.material = Material.MET; break;  
            case "mur.-drewn.": this.material = Material.MUR_DRE; break;
            case "mur.-met.":   this.material = Material.MUR_MET; break;
        }
    };
    
    public String getWikiCode(int n){
        String text = "{{zabytki/wpis\n";
            text += "| numer       = " + number + " | id = " + id + "\n";
            text += "| zespół zabytków = "; 
                if(n>0) text += n + "\n";
                else if(partOf == 0) text += "tak\n";
                else if(partOf == 1) text += "nie\n";
                else text += "??";
            text += "| nazwa       = " + name;
                if(!year.isEmpty()) text += ", " + year;
                if(!hint.isEmpty() && n == -1) text += " <small>(" + hint + ")</small>";
                if(partOf == 0 && parts.isEmpty()) text += " <font color=red>'''brak zabytków w zespole'''</font>";
                text += "\n";
            text += "| miejscowość = " + town + "\n";
            text += "| adres       = " + street + "\n";
            text += "| długość     =  | szerokość  = \n";
            text += "| zdjęcie     = \n";
            text += "| commons     = \n";
            text += "}}\n";
        
        if(partOf == 0){
            text += "{{zabytki/zespół zabytków/góra}}\n";
            for(Monument m : parts) text += m.getWikiCode(id);
            text += "{{zabytki/zespół zabytków/dół}}\n";
        }   
        return text;
    }
}
