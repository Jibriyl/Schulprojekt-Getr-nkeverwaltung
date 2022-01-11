import java.lang.String;

public class Getraenk extends Produkt{

    private double alkoholgehalt;

    public Getraenk(String name, double preis, int bestand, double alkoholgehalt){
        super(name, preis, bestand);

        this.alkoholgehalt = alkoholgehalt;

      }

    public double getalkohol(){
      return this.alkoholgehalt;
    }
}
