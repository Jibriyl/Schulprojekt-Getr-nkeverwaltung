    class Kasse {
        private double kassenstand;

    public Kasse (double kassenstand){
        this.kassenstand = kassenstand;
    }

    public double getkassenstand() {
        return kassenstand;
    }

    public void verkauf(double verkaufpreis){
        this.kassenstand = this.kassenstand + verkaufpreis;
    }

    public void auszahlung(double auszahlmenge){
        this.kassenstand = this.kassenstand - auszahlmenge;
    }
}
