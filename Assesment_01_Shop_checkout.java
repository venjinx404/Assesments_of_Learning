import java.util.Scanner;

public class Assesment_01_Shop_checkout {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-- Welcome to Howard Shop --");

        System.out.print("Enter Product Name: ");
        String productName = sc.nextLine();

        System.out.print("Enter Unit Price: ");
        double unitPrice = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Discount Amount in Percentage: ");
        double discount = sc.nextDouble();

        double DISCOUNT_RATE = discount / 100;

        double subtotal = unitPrice * quantity;
        double discountAmount = subtotal * DISCOUNT_RATE;
        double finalPrice = subtotal - discountAmount;

        int roundedFinalPrice = (int) finalPrice;

        System.out.println("\n--- Final Receipt ---");
        System.out.println("Item: " + productName);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Discount Applied: $" + discountAmount);
        System.out.println("Total (Rounded Down): $" + roundedFinalPrice);
        System.out.println("--------------------");

        sc.close();
    }
}
