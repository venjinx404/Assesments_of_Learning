//Methods and Classes are in project_03
import java.util.Scanner;
import java.util.ArrayList;

public class Project_04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Order> or = new ArrayList<>();

        System.out.println("--- Welcome to BaseCase Shop ---");

        System.out.println("How many items do you want?");
        int item = sc.nextInt();
        sc.nextLine();

        if (item > 5) {
            System.out.println("Maximum 5 items");
            item = 5;
        } else if (item <= 0) {
            System.out.println("Kichui Nili na? Hoilo re?");
            return;
        }
        for (int i = 1; i <= item; i++) {
            System.out.print("Enter Product " + i + " Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            try {

                Order order = new Order(name, price, quantity);
                or.add(order);

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage() + " Skipping item.");
            }
        }
        double subtotal = 0;
        for (Order order : or) {
            subtotal += order.gettotal();
        }
        double discountRate;

        if (subtotal > 100) {
            discountRate = 0.20;
        } else if (subtotal > 50) {
            discountRate = 0.10;
        } else {
            discountRate = 0.05;
        }

        double discountAmount = subtotal * discountRate;

        double deliveryFee = (subtotal < 50) ? 10 : 0;

        double finalTotal = subtotal - discountAmount + deliveryFee;

        System.out.println("\n--- Final Receipt ---");

        int itemNumber = 1;

        for (Order order : or) {
            System.out.println("Item " + itemNumber + ": " + order);
            itemNumber++;
        }

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount Applied (" + (int) (discountRate * 100) + "%): " + discountAmount);
        System.out.println("Delivery Fee: " + deliveryFee);
        System.out.println("Final Total: " + finalTotal);

        System.out.println("--------------------------");

        sc.close();

    }
}
