package machine;
import java.util.Scanner;

public class CoffeeMachine {

    public static void printStatus(int[] CoffeeMachine) {
        System.out.println("The coffee machine has:");
        System.out.println(CoffeeMachine[0] + " ml of water");
        System.out.println(CoffeeMachine[1] + " ml of milk");
        System.out.println(CoffeeMachine[2] + " g of coffee beans");
        System.out.println(CoffeeMachine[3] + " disposable cups");
        System.out.println("$" + CoffeeMachine[4] + " of money");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int CoffeeMachine [] = {400, 540, 120, 9, 550};
        int Espresso [] = {250, 0, 16, 1, -4};
        int Latte [] = {350, 75, 20, 1, -7};
        int Cappuccino [] = {200, 100, 12, 1, -6};

        printStatus(CoffeeMachine);

        System.out.println();

        while (true) {
            System.out.println("Write action (buy, fill, take):");
            String action = scanner.nextLine();
            if (action.equals("buy")) {
                System.out.println(
                        "What do you want to buy?" +
                        " 1 - espresso, 2 - latte, 3 - cappuccino");

                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        for ( int i = 0; i < CoffeeMachine.length; i++ ) {
                            CoffeeMachine[i] -= Espresso[i];
                        }
                        printStatus(CoffeeMachine);
                        break;
                    case "2":
                        for ( int i = 0; i < CoffeeMachine.length; i++ ) {
                            CoffeeMachine[i] -= Latte[i];
                        }
                        printStatus(CoffeeMachine);
                        break;
                    case "3":
                        for ( int i = 0; i < CoffeeMachine.length; i++ ) {
                            CoffeeMachine[i] -= Cappuccino[i];
                        }
                        printStatus(CoffeeMachine);
                        break;
                }

            }

            if (action.equals("take")) {
                int taken = CoffeeMachine[4];
                CoffeeMachine[4] = 0;
                System.out.println("I gave you $" + taken);
                System.out.println();
                printStatus(CoffeeMachine);

                break;
            }



            if (action.equals("fill")) {
                int filled [] = {0,0,0,0,0};
                int filling;

                System.out.println("Write how many ml of water you want to add:");
                filling = scanner.nextInt();
                filled[0] = filling;

                System.out.println("Write how many ml of milk you want to add:");
                filling = scanner.nextInt();
                filled[1] = filling;

                System.out.println("Write how many coffee beans you want to add:");
                filling = scanner.nextInt();
                filled[2] = filling;

                System.out.println("Write how many disposable cups you want to add:");
                filling = scanner.nextInt();
                filled[3] = filling;

                for (int i = 0; i < CoffeeMachine.length; i++ ) {
                    CoffeeMachine[i] += filled[i];
                }
                printStatus(CoffeeMachine);
            }
            break;
        }

    }
}