package designpattern;

import java.util.ArrayList;
import java.util.List;

/*
* Ermöglicht einem Objekt, eine Abhängigkeit zu einer Menge von Beobachtern zu
* unterhalten und alle automatisch zu benachrichtigen,
* wenn sich der Zustand ändert.
* Beispiel: In einem Börsensystem, bei dem die Kurse aktualisiert werden
* und mehrere Benutzer benachrichtigt werden sollen.
*
* */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Stock stock = new Stock();
        Investor investor1 = new Investor("Alice");
        Investor investor2 = new Investor("Bob");

        stock.registerObserver(investor1);
        stock.registerObserver(investor2);

        stock.setPrice(100);
        stock.removeObserver(investor1);

        stock.setPrice(150);
    }
}

class Stock {
    private List<Observer> observers = new ArrayList<Observer>();
    private int price;

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setPrice(int newPrice) {
        this.price = newPrice;
        observers.stream().forEach((o) -> o.update(newPrice));
    }
}

interface Observer {
    void update(int price);
}

class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }
    @Override
    public void update(int price) {
        System.out.println("Investor " + name + " has received a new price update: " + price);
    }
}
