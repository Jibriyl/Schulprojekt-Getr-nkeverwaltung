import java.lang.String;
import java.util.HashMap;
import java.util.Scanner;

public class Getraenkeverwaltung {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Kasse kasse1 = new Kasse(100);
        int i = 0;

        // Erstelen der Map in der die Getraenke und Snack Objekte gespeichert werden.
        HashMap<String, Getraenk> map = new HashMap<>();
        HashMap<String, Snacks> snack = new HashMap<>();

        // Hinzufügen der Getraenke mit Konstuktor
        map.put("Fanta", new Getraenk("Fanta", 3, 30, 0));
        map.put("Cola", new Getraenk("Cola", 3.99, 50, 0));
        map.put("Cola Light", new Getraenk("Cola Light", 3.99, 50, 0));
        map.put("Vodka", new Getraenk("Vodka", 5, 30, 40));
        map.put("Tomatensaft", new Getraenk("Tomatensaft", 1, 50000, 0));
        map.put("WhiteRussen", new Getraenk("WhiteRussian", 0.49, 40, 35));
        map.put("Fritz", new Getraenk("Fritz", 2, 50, 0));
        map.put("Effekt", new Getraenk("Effekt", 1, 10, 0));

        // Hinzufügen der Snacks mit Konstruktor
        snack.put("Chips", new Snacks("Chips", 1.99, 100));
        snack.put("Nuesse", new Snacks("Nuesse", 2.49, 30));
        snack.put("Pringels", new Snacks("Pringels", 3.99, 50));
        snack.put("Popkorn", new Snacks("Popkorn", 3.49, 10));

        // Wilkommensnachricht
        System.out.println("Herzlich Willkommen zur Getränkeverwaltung!");

        // Main Loop in dem die Software ausgeführt wird.
        while (i < 10) {
            i = 9;
            System.out.println("Der aktuelle Kassenstand ist: " + kasse1.getkassenstand());
            System.out.println("1 = Abfrage aller verfübaren Getraenke");
            System.out.println("2 = Getraenkedaten abfragen");
            System.out.println("3 = Getraenk verkaufen");
            System.out.println("4 = Bestand der Getraenk erhöhen");
            System.out.println("5 = Neues Getraenk hinzufügen");
            System.out.println("6 = Abfrage aller verfübaren Snacks");
            System.out.println("7 = Snackdaten abfragen");
            System.out.println("8 = Snack verkaufen");
            System.out.println("9 = Bestand der Snacks erhöhen");
            System.out.println("10 = Neuen Snack hinzufügen");
            System.out.println("11+ = Programm beenden");
            System.out.println("Was wollen sie tun?");
            i = scan.nextInt();
            switch (i) {
            case 1: //Ausgeben aller Keys der Getraenke Map
                System.out.println(map.keySet());
                break;
            case 2: //Auwal welche Daten der Getraenke ausgegeben werden sollen
                System.out.println("1 = Preis abfragen");
                System.out.println("2 = Bestand abfragen");
                System.out.println("3 = Alkoholgehalt abfragen");
                System.out.println("4+ = Zurück zur Auswahl");
                System.out.println("Was wollen sie tun?");
                int z = scan.nextInt();
                switch (z) {
                case 1:
                    map.forEach((k,v) -> System.out.println("Name: " + k + " Preis: " +map.get(k).getpreis()));
                    break;
                case 2:
                    map.forEach((k,v) -> System.out.println("Name: " + k + " Bestand: " +map.get(k).getbestand()));
                break;
                case 3:
                    map.forEach((k,v) -> System.out.println("Name: " + k + " Alkoholanteil: " +map.get(k).getalkohol()));
                default:
                    break;
                }
                break;
            case 3: //Verkaufen der Getraenke
                System.out.println("Welches Getraenk soll verkauft werden?");
                String getraenkauswahl = scan.next();
                System.out.println("Wie viele Getraenke sollen verkauft werden?");
                int getraenkanzahl = scan.nextInt();
                if (map.get(getraenkauswahl).bestandabfrage(getraenkanzahl)) {
                    map.get(getraenkauswahl).bestandverringern(getraenkanzahl);
                    System.out.println(map.get(getraenkauswahl).kassenzettelDrucken(getraenkanzahl,
                            map.get(getraenkauswahl).gesamtpreisrechner(getraenkanzahl)));
                    kasse1.verkauf(map.get(getraenkauswahl).gesamtpreisrechner(getraenkanzahl));
                } 
                else {
                    System.out.println("Der bestand reicht nicht aus um die bestellung zu erfüllen.");
                }
                break;
            case 4: //Lagerbestand der Getraenke erhöhen
                System.out.println("Von welchem Getraenk ist eine Lieferung angekommen?");
                String getraenklieferung = scan.next();
                System.out.println("Wie viele Getraenke wurden geliefert?");
                int scannerbestellungsanzahl = scan.nextInt();
                map.get(getraenklieferung).bestanderhoehen(scannerbestellungsanzahl);
                break;
            case 5: //Neues Getraenk hinzufuegen
                System.out.println("Wie heisst das neue Getraenk?");
                String neugetraenk = scan.next();
                System.out.println("Wie viel soll das Getraenk kosten?");
                double neupreis = scan.nextDouble();
                System.out.println("Wie viele dieses Getraenks sind auf Lager?");
                int neuanzahl = scan.nextInt();
                System.out.println("Welchen Alkoholgehalt hat das neue Getraenk?");
                double alkoholgehalt = scan.nextDouble();
                map.put(neugetraenk, new Getraenk(neugetraenk, neupreis, neuanzahl, alkoholgehalt));
                System.out.println("Das Getraenk " + neugetraenk + " wurde mit dem Bestand von " + neuanzahl
                        + " zum Preis von " + neupreis + " euro hinzugefügt.");
                break;
            case 6: //Ausagebe aller Snacks 
                System.out.println(snack.keySet());
                break;
            case 7: //Abfrage der Snack Daten, anders als bei den Getraenken muss der gewünchte Snakc ausgefaehlt werden
                System.out.println("1 = Preis abfragen");
                System.out.println("2 = Bestand abfragen");
                System.out.println("3+ = Zurück zur Auswahl");
                System.out.println("Was wollen sie tun?");
                int auswahl = scan.nextInt();
                System.out.println("Auf welchen Snack bezieht sich ihre abfrage?");
                String snackauswahl = scan.next();
                switch (auswahl) {
                case 1:
                    System.out.println("Der Preis von " + snackauswahl + " ist " + snack.get(snackauswahl).getpreis());
                    break;
                case 2:
                    System.out.println("Es sind noch " + snack.get(snackauswahl).getbestand() + " Packungen "
                            + snackauswahl + " auf Lager");
                    break;
                default:
                    break;
                }
                break;
            case 8: //Verkauf von Snacks
                System.out.println("Welcher Snack soll verkauft werden?");
                String snackauswahl2 = scan.next();
                System.out.println("Wie viele Snacks sollen verkauft werden?");
                int snackanzahl = scan.nextInt();
                if (snack.get(snackauswahl2).bestandabfrage(snackanzahl)) {
                    snack.get(snackauswahl2).bestandverringern(snackanzahl);
                    System.out.println(snack.get(snackauswahl2).kassenzettelDrucken(snackanzahl,
                            snack.get(snackauswahl2).gesamtpreisrechner(snackanzahl)));
                    kasse1.verkauf(snack.get(snackauswahl2).gesamtpreisrechner(snackanzahl));
                } 
                else {
                    System.out.println("Der bestand reicht nicht aus um die bestellung zu erfüllen.");
                }
                break;
            case 9: //Erhoehen bestand Snacks
                System.out.println("Von welchem Snack ist eine Lieferung angekommen?");
                String snacklieferung = scan.next();
                System.out.println("Wie viele Snacks wurden geliefert?");
                int scannerbestellungsanzahlsnack = scan.nextInt();
                snack.get(snacklieferung).bestanderhoehen(scannerbestellungsanzahlsnack);
                break;
            case 10: //Hinzufuegen neuer Snack
                System.out.println("Wie heisst der neue Snack?");
                String neusnack = scan.next();
                System.out.println("Wie viel soll der Snack kosten?");
                double neupreissnack = scan.nextDouble();
                System.out.println("Wie viele dieses Snacks sind auf Lager?");
                int neuanzahlsnack = scan.nextInt();
                snack.put(neusnack, new Snacks(neusnack, neupreissnack, neuanzahlsnack));
                System.out.println("Der Snack " + neusnack + " wurde mit dem Bestand von " + neuanzahlsnack
                        + " zum Preis von " + neupreissnack + " euro hinzugefügt.");
                break;
            default: //Bei allen anderen Int eingaben wird Porgramm beendet
                System.out.println("Programm beendet");
                break;
            }
        }
        scan.close();
    }
}
