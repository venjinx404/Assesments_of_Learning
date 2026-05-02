
import java.util.*;

public class Project_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---Welcome To Trekon Shop--- ");
        System.out.println("Enter Amount of Item (Max 5)");
        int n = sc.nextInt();
        sc.nextLine();

        if (n > 5) {
            System.out.println("Must me lower or equal to 5");
            System.exit(0);
        }

        String[] productName = new String[n];
        double[] prices = new double[n];
        int[] quatity = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name of " + (i + 1) + " Product : ");
            productName[i] = sc.nextLine();

            System.out.print("\nEnter Price: ");
            double price = sc.nextDouble();

            if (price <= 0) {
                System.out.println("Invailed Price. Try Again!!");
                i--;
                sc.nextLine();
                continue;
            }

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();

            if (qty <= 0) {
                System.out.println("Invailed Quantity. Try Again!!");
                i--;
                sc.nextLine();
                continue;
            }

            prices[i] = price;
            quatity[i] = qty;
            sc.nextLine();
        }

        double subtotal = 0;
        for (int i = 0; i < n; i++) {
            subtotal += prices[i] * quatity[i];

        }
        double discountRate;
        if (subtotal > 100) {
            discountRate = 0.20;
        } else if (subtotal > 50) {
            discountRate = 0.10;
        } else {
            discountRate = 0.05;
        }

        double discount = subtotal * discountRate;

        double deliveryFee = (subtotal < 50) ? 10 : 0;

        double finalTotal = subtotal - discount + deliveryFee;

        System.out.println("\n*****");
        System.out.println("--- Final Receipt ---");

        for (int i = 0; i < n; i++) {
            double itemTotal = prices[i] * quatity[i];
            System.out.println("Item " + (i + 1) + ": " + productName[i] +
                    " - " + quatity[i] + " x " + prices[i] + " = " + itemTotal);
        }

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount Applied: " + discount);
        System.out.println("Delivery Fee: " + deliveryFee);
        System.out.println("Final Total: " + finalTotal);
        System.out.println("--------------------------");

        sc.close();
    }
}
