package coffeeMachine.com;

import java.util.Scanner;

public class CoffeeMaker {

    int water = 400;
    int coffeeBeans = 120;
    int milk = 540;
    int disposableCups = 9;
    int money = 550;
    String action;
    String choice;
    boolean running = true;
    Scanner scanner = new Scanner(System.in);


    CoffeeMaker() {

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.nextLine();
            pickAction(action);

        } while (running);

    }

    public void pickAction(String action) {
        this.action = action;

        switch (action) {
            case "buy" -> {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                choice = scanner.nextLine();
                buy(choice);
            }
            case "fill" -> fill();
            case "take" -> take();
            case "remaining" -> remaining();
            case "exit" -> running = false;
        }
    }

    public void buy(String choice) {
        this.choice = choice;
        switch (choice) {
            case "1" -> {
                int espWat = 250;
                int espBeans = 16;
                int espPrice = 4;

                if (water < espWat) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (coffeeBeans < espBeans) {
                    System.out.println("Sorry, not enough beans!");
                    break;
                } else if (disposableCups == 0) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                }


                water -= espWat; // to reduce water in machine
                coffeeBeans -= espBeans; // to reduce beans in machine
                money += espPrice; // to add money in machine
                disposableCups--; // to reduce cups by one
            }
            case "2" -> {
                int latWat = 350;
                int latMilk = 75;
                int latBeans = 20;
                int latPrice = 7;
                if (water < latWat) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (coffeeBeans < latBeans) {
                    System.out.println("Sorry, not enough beans!");
                    break;
                } else if (milk < latMilk) {
                    System.out.println("Sorry, not enough beans!");
                    break;
                } else if (disposableCups == 0) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                }
                water -= latWat; // reduce water
                milk -= latMilk; // reduce milk
                coffeeBeans -= latBeans; // reduce beans
                money += latPrice; // add money
                disposableCups--; // reduce cups
                }
            case "3" -> {
                int capWat = 200;
                int capMilk = 100;
                int capBeans = 12;
                int capPrice = 6;


                if (water < capWat) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (coffeeBeans < capBeans) {
                    System.out.println("Sorry, not enough beans!");
                    break;
                } else if (milk < capMilk) {
                    System.out.println("Sorry, not enough beans!");
                    break;
                } else if (disposableCups == 0) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                }
                water -= capWat; // reduce water
                milk -= capMilk; // reduce milk
                coffeeBeans -= capBeans; // reduce beans
                money += capPrice; // add money
                disposableCups--; // reduce cups
            }
            case "back" -> {
                break;
            }
        }
    }

    public void fill() {
        System.out.println("Write how many ml of water you want to add:");
        int addW = scanner.nextInt();
        water += addW;
        System.out.println("Write how many ml of milk you want to add:");
        int addM = scanner.nextInt();
        milk += addM;
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addB = scanner.nextInt();
        coffeeBeans += addB;
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int addDC = scanner.nextInt();
        disposableCups += addDC;

    }

    public void take() {
        System.out.printf("I gave you %d", money);
        money = 0;
    }

    public void remaining() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", water);
        System.out.printf("%d ml of milk\n", milk);
        System.out.printf("%d g of coffee beans\n", coffeeBeans);
        System.out.printf("%d disposable cups\n", disposableCups);
        System.out.printf("%d of money\n", money);
    }

}
