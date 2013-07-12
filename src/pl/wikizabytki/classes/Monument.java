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
    
    public Monument(String id, String name, String number, String gmina, String town, String street, int partOf) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.number = number;
        this.gmina = gmina;
        this.town = town;
        this.street = street;
        this.partOf = partOf;
    }
    
    /**
     * Checks if monument in parameter is part of this monument complex
     * @param m
     * @return 
     */
    public boolean isPart(Monument m) {
        //if(name.contains("zespół")) return false;
        //if(m.partOf == 1) return false;
        
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
    
//    public String _show(){
//        String text = "";
//        text += "\t\t " + name + "\n";
//        for(Monument m : parts) text += "\t" + m.show();
//        return text;
//    }
    
    public String show(int n){
        String text = "{{zabytki/wpis\n";
            text += "| numer       = " + number + " | id = " + id + "\n";
            text += "| zespół zabytków = "; 
                if(parts.isEmpty()) text += "nie\n";
                else if(!parts.isEmpty()) text += "tak\n";
                else if(n>0) text += n + "\n";
                else text += "??";
            text += "| nazwa       = " + name + "\n";
            text += "| miejscowość = " + town + "\n";
            text += "| adres       = " + street + "\n";
            text += "| długość     =  | szerokość  = \n";
            text += "| zdjęcie     = \n";
            text += "| commons     = \n";
            text += "}}\n";
            
        if(!parts.isEmpty()){
            text += "{{zabytki/zespół zabytków/góra}}\n";
            for(Monument m : parts) text += m.show(id);
            text += "{{zabytki/zespół zabytków/dół}}\n";
        }   
        return text;
    }
    
    
}
