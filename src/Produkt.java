import java.lang.String;
public class Produkt {

    //Die Variablen der Klasse Produkt
    private String name;
    private double preis;
    private int bestand;

    public Produkt(String name, double preis, int bestand){
        
        this.name = name;
      
        this.preis = preis;
      
        this.bestand = bestand;
    }

    
    // Get-Befehle um die Werte der Variablen abzufragen.
    public String getName() {
        return name;
    }
    public double getpreis() {
        return preis;
    }
    public int getbestand() {
        return bestand;
    }

    //Set-Befehle für name, Preis und Bestand.
    public void setName(String name) {
        this.name = name;
    }
    public void setpreis(double preis) {
        this.preis = preis;
    }
    public void setbestand(int bestand) {
        this.bestand = bestand;
    }

    //Weitere Funktionen
    public void bestanderhoehen(int bestand) {
        this.bestand = this.bestand + bestand;
    }

    public void bestandverringern(int bestand) {
        this.bestand = this.bestand - bestand;
    }
    //Check ob der bestand über der zu verkauften menge liegt
    public boolean bestandabfrage(int verkauf) {
        boolean x;
        if (this.bestand >= verkauf){
            x = true;
        }
        else {
            x = false;
        }
        return x;
    }

    //Berechnet den Preis 
    public double gesamtpreisrechner(int verkaufsmenge){
        double gesamtpreis = verkaufsmenge * this.preis;
        return gesamtpreis;
    }

    //Audrucken des Kassenzettels
    public String kassenzettelDrucken(int verkaufsmenge, double gesamtpreis) {
        String kassenzettel;
           
        kassenzettel = "Name: " + this.name + 
   
       "\nVerkaufsmenge: " + verkaufsmenge +
   
       "\nPreis in Euro: " + this.preis +
   
       "\nGesamtpreis: " + gesamtpreis +     
   
       "\n";
   
     return kassenzettel;
   
   }
}
