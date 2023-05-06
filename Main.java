
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static File textFileMain = new File("basket.txt");
    public static String[] products = {"Milk", "Bred", "Onion"};
    public static int[] prices = {339, 14, 80};

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("task 1\n");
        Basket basket;
        if (textFileMain.exists()) {
            System.out.println("The basket already exists and will be used:");
            basket = Basket.loadFromTxtFile(textFileMain);
            basket.printCart();
        } else {
            System.out.print("Basket empty. ");
            basket = new Basket(products, prices);
        }
        groceryList(basket);
        while (true) {
            System.out.println("\ntake the product and quantity separated by a space " +
                    "or enter1 5" +
                    " \"end\" for exit");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println(String.format("You must enter two numbers \"Number, Quantity\"" +
                        " through a gap, not '%s'", input));
                continue;
            }
            try {
                if (Integer.parseInt(parts[0]) < 0 || Integer.parseInt(parts[0]) > products.length) {
                    System.out.println(String.format("You must enter the item number from '1' to '%s'",
                            (products.length)));
                } else if (Integer.parseInt(parts[1]) >= 0) {
                    int productNumber = Integer.parseInt(parts[0]) - 1;
                    int productCount = Integer.parseInt(parts[1]);
                    basket.addToCart(productNumber, productCount);
                    basket.saveTxt(textFileMain);
                } else
                    System.out.println(String.format("Quantity of goods cannot be negative" +
                            " '%s'", Integer.parseInt(parts[1])));
            } catch (NumberFormatException e) {
                System.out.println(String.format("Input error, you entered not two numbers separated by a space:" +
                        " '%s'", input));
            }
        }
        System.out.println("Your basket:");
        basket.printCart();
    }

    private static void groceryList(Basket basket) {
        System.out.println("List of products available for purchase:");
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d. %s %d rub/ps \n", i + 1, products[i], prices[i]);
        }
    }
}