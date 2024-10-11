package designpattern;

interface PricingStrategy {
    double calculatePrice(double basePrice);
}

/*
 * Definiert eine Familie von Algorithmen, kapselt sie und macht sie austauschbar.
 * In einem Reisebuchungssystem könnten verschiedene Preisberechnungsstrategien
 * für verschiedene Arten von Buchungen verwendet werden.
 *
 * */
public class PricingStrategyDemonstration {
    public static void main(String[] args) {
        Booking booking = new Booking();

        booking.setPricingStrategy(new RegularPricing());
        System.out.println("Regular Booking: " + booking.getPrice(100, 3));

        booking.setPricingStrategy(new DiscountedPricing());
        System.out.println("Discounted Booking: " + booking.getPrice(100, 3));

        booking.setPricingStrategy(new EarlyBirdPricing());
        System.out.println("Early Bird Booking: " + booking.getPrice(100, 3));
    }
}

class RegularPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice;
    }
}

class DiscountedPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.9;
    }
}

class EarlyBirdPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.8;
    }
}

class Booking {
    private PricingStrategy pricingStrategy;

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double getPrice(double basePrice, int days) {
        if (pricingStrategy == null) {
            throw new IllegalStateException("Pricing strategy is not set.");
        }
        return pricingStrategy.calculatePrice(basePrice) * days;
    }
}
