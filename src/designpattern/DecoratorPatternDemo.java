package designpattern;

interface Product {
    double getPrice();
    String getDescription();
}

/*
 * Fügt einem Objekt zur Laufzeit neue Funktionalitäten hinzu,
 * ohne dessen Struktur zu ändern.
 * Beispiel: In einem E-Commerce-System könnte das DiscountDecorator verwendet werden,
 * um einem Produkt Rabatte hinzuzufügen.
 * */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Product product = new BasicProduct(1000, "Laptop");
        System.out.println(product.getDescription() + ": " + product.getPrice());
        Product discountedProduct = new DiscountDecorator(product, 0.10);
        System.out.println(discountedProduct.getDescription() + ": " + discountedProduct.getPrice());
    }
}

class BasicProduct implements Product {
    private double price;
    private String description;

    public BasicProduct(double price, String description) {
        this.price = price;
        this.description = description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

class DiscountDecorator implements Product {
    private Product product;
    private double discount;

    public DiscountDecorator(Product product, double discount) {
        this.product = product;
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return product.getPrice() * (1 - discount);
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " mit " + (discount * 100) + "% Rabatt";
    }
}
