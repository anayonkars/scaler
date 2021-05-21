import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeMachine {
  private final List<Beverage> menu = new ArrayList<>();
  private final Beverage americano;
  private final Beverage blackCoffee;
  private final Beverage cafeMocha;
  private final Beverage custom;

  {
    americano = Beverage.BeverageBuilder.aBeverage()
            .withName("Americano")
            .withCoffee(3)
            .withSugar(1)
            .withMilk(1)
            .build();

    blackCoffee = Beverage.BeverageBuilder.aBeverage()
            .withName("Black Coffee")
            .withCoffee(3)
            .build();

    cafeMocha = Beverage.BeverageBuilder.aBeverage()
            .withName("Cafe Mocha")
            .withCoffee(3)
            .withSugar(1)
            .build();

    custom = Beverage.BeverageBuilder.aBeverage()
            .withName("Custom")
            .build();

  }

  public static final String CUSTOM = "Custom";

  public static void main(String[] args) {
    new CoffeeMachine().initialize();
  }

  {
    menu.add(americano);
    menu.add(blackCoffee);
    menu.add(cafeMocha);
    menu.add(custom);
  }

  public static final String AMERICANO = "Americano";
  public static final String BLACK_COFFEE = "Black Coffee";
  public static final String CAFE_MOCHA = "Cafe Mocha";

  public void initialize() {
    Scanner scannerObj = new Scanner(System.in);
    displayMenu();
    int selectedCoffee = scannerObj.nextInt();
    List<Beverage> menu = this.menu;
    Beverage beverageToDispense = menu.get(selectedCoffee - 1);
    double totalCost = 0;
    boolean isCustomBeverage = false;
    if (CUSTOM.equals(beverageToDispense.getName())) {
      isCustomBeverage = true;
      System.out.println("Please select ingredients.");
      displayIngredients();
      System.out.println("Press Q/q to quit, D/d to dispense, R/r to restock");
    } else {
      System.out.println("You selected " + beverageToDispense.getName() + " : " + beverageToDispense);
      System.out.println("Press Q/q to quit, D/d to dispense, R/r to restock");
      totalCost = CostCalculator.calculateCost(beverageToDispense);
    }

    ArrayList<String> userInputs = new ArrayList<>();
    boolean isQuit = false, isRestock = false, isDispense = false;
    while (true) {
      String input = scannerObj.nextLine();
      if (input.equals("")) {
        continue;
      }
      switch (input) {
        case "Q":
        case "q":
          isQuit = true;
          break;
        case "D":
        case "d":
          isDispense = true;
          break;
        case "R":
        case "r":
          isRestock = true;
          break;
        default:
          userInputs.add(input);
          break;
      }
      if (isRestock) {
        System.out.println("Input cleared.");
        userInputs.clear();
        isRestock = false;
      }
      if (isQuit || isDispense) {
        break;
      }
    }

    if (isQuit) {
      System.out.println("Quitting...");
      scannerObj.close();
    }


    if (isDispense) {
      System.out.println("Dispensing...");
      if (isCustomBeverage) {
        beverageToDispense = buildCustomBeverage(userInputs);
        totalCost = CostCalculator.calculateCost(beverageToDispense);
      }
      if (totalCost > 0) {
        System.out.println("Please pay " + totalCost / 100 + "$");
      }
    }

    scannerObj.close();
  }

  private Beverage buildCustomBeverage(ArrayList<String> userInputs) {
    Beverage.BeverageBuilder beverageBuilder = Beverage.BeverageBuilder.aBeverage();
    for (String input : userInputs) {
      String[] line = input.split(" ");
      Integer beverage = Integer.valueOf(line[0]);
      Integer quantity = Integer.valueOf(line[1]);
      switch (beverage) {
        case 1:
          beverageBuilder.withCoffee(quantity);
          break;
        case 2:
          beverageBuilder.withCream(quantity);
          break;
        case 3:
          beverageBuilder.withSugar(quantity);
          break;
        default:
      }
    }
    return beverageBuilder.build();
  }

  private void displayMenu() {
    List<Beverage> menu = this.menu;
    int i = 0;
    for (; i < menu.size(); i++) {
      String curr = menu.get(i).getName();
      System.out.println(i + 1 + ". " + curr + " (Press " + (i + 1) + " for " + curr + ")");
    }
  }

  private void displayIngredients() {
    String ingredients = "1. Coffee. Cost per unit: 0.75 (Press 1 for Coffee and space then the quantity you prefer)\n" +
            "2. Cream. Cost per unit: 0.25 (Press 2 for Cream and space then the quantity you prefer)\n" +
            "3. Sugar. Cost per unit: 0.25 (Press 3 for Sugar and space then the quantity you prefer)\n" +
            "4. Water. Cost per unit: 0.0 (Press 4 for Water and space then the quantity you prefer)";
    System.out.println(ingredients);
  }

}

