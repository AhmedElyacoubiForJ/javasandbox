package designpattern;

/*
* Verwendet Methoden zur Erstellung von Objekten, ohne den genaueren Klassentype anzugeben.
* Beispiel: In Online-Bestellsystem kann der PaymentFactory verwendet werden,
* um verschiedene Zahlungsmethoden zu erstellen.
*
* */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        Payment creditCardPayment = PaymentFactory.createPayment("creditcard");
        creditCardPayment.pay();

        Payment payPalPayment = PaymentFactory.createPayment("paypal");
        payPalPayment.pay();

        // Falls unbekannter Zahlungstyp angegeben wird
        Payment unknownPayment = PaymentFactory.createPayment("unknown");
        // Exception handling wird nicht in diesem Beispiel demonstriert,
        // aber in realen Anwendungsfällen ist es sinnvoll.
        unknownPayment.pay(); // Unbekannter Zahlungstyp: IllegalArgumentException
    }
}

interface Payment {
    void pay();
}

class CreditCardPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Bezahlung per Kreditkarte");
    }
}

class PayPalPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Bezahlung per PayPal");
    }
}

class PaymentFactory {
    public static Payment createPayment(String paymentType) {
        if (paymentType.equalsIgnoreCase("creditcard")) {
            return new CreditCardPayment();
        } else if (paymentType.equalsIgnoreCase("paypal")) {
            return new PayPalPayment();
        } else {
            throw new IllegalArgumentException("Unbekannter Zahlungstyp");
        }
    }
}
