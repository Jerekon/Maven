import java.util.Scanner;

public class nalogfins {

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int taxEarningsMinusSpendings = (earnings - spendings) * 15 / 100;
        if (taxEarningsMinusSpendings >= 0) {
            return taxEarningsMinusSpendings;
        } else {

            return 0;
        }
    }

    public static int taxEarnings (int earnings) {
        int taxEarnings = (earnings) * 6 / 100;
        if (taxEarnings >= 0) {
            return taxEarnings;
        } else {

            return 0;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int earnings = 0;    // РґРѕС…РѕРґС‹
            int spendings = 0;   // СЂР°СЃС…РѕРґС‹

            System.out.println("Select an operation and enter its number:");
            System.out.println("1. Enter a new income");
            System.out.println("2. Add a new expense");
            System.out.println("3. Choose a tax system");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                System.out.println("The program is completed!");
                break;
            }
            switch (input) {
                case "1":
                    System.out.println("Enter the amount of income:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case "2":
                    System.out.println("Enter the expense amount:");
                    String moneyStr2 = scanner.nextLine(); // РќРµ РёСЃРїРѕР»СЊР·СѓР№С‚Рµ С‚СѓС‚ nextInt (!)
                    int money2 = Integer.parseInt(moneyStr2);
                    spendings += money2;
                    break;

                case "3":
                    System.out.println("We advise you to use USN");
                    System.out.printf("Your tax will be at 6%" + ((earnings * 6) / 100) +"RUB");
                    System.out.println("Your tax will be at 15%" + ((earnings - spendings) * 15 / 100) + "RUB");

                default:
                    System.out.println("There is no such operation");
                    break;
            }

        }
    }
}
