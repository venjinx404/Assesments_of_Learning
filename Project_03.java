import java.util.*;

class Order {
    public String productName;
    private double unitPrice;
    private int quantity;

    public Order(String name, double price, int qty) throws Exception {
        productName = name;
        setunitprice(price);
        setQuantity(qty);
    }

    void setunitprice(double price) throws Exception {
        if (price <= 0) {
            throw new Exception("What? Is this even a Price??");
        }
        unitPrice = price;
    }

    void setQuantity(int qty) throws Exception {
        if (qty <= 0) {
            throw new Exception("What??No Item???");
        }
        quantity = qty;
    }

    double gettotal() {
        return unitPrice * quantity;
    }

    public String toString() {
        return productName + " - " + quantity + " pcs x " + unitPrice + " = " + gettotal();
    }

}

public class Project_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Order Test ---");

        try {
            // Order 1 
            System.out.print("Enter Product 1 Name: ");
            String name1 = sc.nextLine();

            System.out.print("Enter Price: ");
            double price1 = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            int qty1 = sc.nextInt();
            sc.nextLine();

            Order o1 = new Order(name1, price1, qty1);

            // Order 2 
            System.out.print("Enter Product 2 Name: ");
            String name2 = sc.nextLine();

            System.out.print("Enter Price: ");
            double price2 = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            int qty2 = sc.nextInt();

            Order o2 = new Order(name2, price2, qty2);

            System.out.println(o1);
            System.out.println(o2);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("--- Invalid Order Attempt ---");

        try {
            Order o3 = new Order("Mouse", 40.44, -18);
            System.out.println(o3);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
