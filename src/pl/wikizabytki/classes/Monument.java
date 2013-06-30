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
    
    public boolean isPart(Monument m) {
        //if(name.contains("zespół")) return false;
        if(m.number.equals(number)) {
            System.out.println("Equals: number");
            return true;
        }
        if(m.street.equals(street) && m.number.equals(number)) {
            System.out.println("Equals: street 'n' number");
            return true;
        }
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
}
