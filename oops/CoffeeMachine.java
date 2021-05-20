import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CoffeeMachine {
  public static void main(String args[]) {
    new CoffeeMachine().initialize();
  }

  private ArrayList<String> menu = new ArrayList<>();
  private Beverage americano = new Beverage(1, 2, 3, 6);
  private Beverage blackCoffee = new Beverage(1, 2, 3, 4);
  private Beverage cafeMocha = new Beverage(1, 2, 3, 5);
  public static final String AMERICANO = "Americano";
  public static final String BLACK_COFFEE = "Black Coffee";
  public static final String CAFE_MOCHA = "Cafe Mocha";

  public void initialize() {
    Scanner scannerObj = new Scanner(System.in);
    displayMenu();
    int selectedCoffee = scannerObj.nextInt();
    ArrayList<String> menu = getMenu();
    String coffeeToDispense = new String();
    for (int i = 0; i < menu.size(); i++) {
      String curr = menu.get(i);
      if (selectedCoffee == i + 1) {
        coffeeToDispense = curr;
        break;
      }
    }

    System.out.println("You selected " + coffeeToDispense);
    System.out.println("Please select ingredients.");
    System.out.println("Press Q/q to quit, D/d to dispense, R/r to restock");
    ArrayList<String> ingredients = displayIngredients(coffeeToDispense);

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
          isDispense = true;
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
      }
      if (isQuit || isDispense) {
        break;
      }
    }

    if (isQuit) {
      System.out.println("Quitting...");
      scannerObj.close();
    }

    double totalCost = 0;
    if (isDispense) {
      System.out.println("Dispensing...");
      Beverage beverage = new Beverage();
      for (int i = 0; i < userInputs.size(); i++) {
        String curr = userInputs.get(i);
        String[] splitInput = curr.split(" ", 2);
        int selectedIngredient = Integer.valueOf(splitInput[0]);
        int selectedQuantity = Integer.valueOf(splitInput[1]);
        for (int j = 0; j < ingredients.size(); j++) {
          String currIngr = new String();
          if (selectedIngredient == j + 1) {
            currIngr = ingredients.get(j);
          }
          double cost = 0;
          switch (currIngr) {
            case "Coffee":
              cost = selectedQuantity * beverage.getCoffeeCost();
              break;
            case "Cream":
              cost = selectedQuantity * beverage.getCreamCost();
              break;
            case "Sugar":
              cost = selectedQuantity * beverage.getSugarCost();
              break;
            case "Water":
              cost = 0;
              break;
            case "Chocolate":
              cost = selectedQuantity * beverage.getChocolateCost();
              break;
            case "Milk":
              cost = selectedQuantity * beverage.getMilkCost();
              break;
            default:
              break;
          }
          totalCost += cost;
        }
      }
    }

    System.out.println("Please pay " + totalCost / 100 + "$");
    scannerObj.close();
  }

  private void displayMenu() {
    ArrayList<String> menu = getMenu();
    for (int i = 0; i < menu.size(); i++) {
      String curr = menu.get(i);
      System.out.println(i + 1 + ". " + curr + " (Press " + (i + 1) + " for " + curr + ")");
    }
  }

  private ArrayList<String> displayIngredients(String type) {
    ArrayList<String> ingredients = getIngredients(type);
    Beverage beverage = new Beverage();
    for (int i = 0; i < ingredients.size(); i++) {
      String curr = ingredients.get(i);
      double cost = 0;
      switch (curr) {
        case "Coffee":
          cost = beverage.getCoffeeCost();
          break;
        case "Cream":
          cost = beverage.getCreamCost();
          break;
        case "Sugar":
          cost = beverage.getSugarCost();
          break;
        case "Water":
          cost = 0;
          break;
        case "Chocolate":
          cost = beverage.getChocolateCost();
          break;
        case "Milk":
          cost = beverage.getMilkCost();
          break;
        default:
          break;
      }
      cost = cost / 100;
      System.out.println(i + 1 + ". " + curr + ". Cost per unit: " + cost + " (Press " + (i + 1) + " for " + curr
          + " and space then the quantity you prefer)");
    }
    return ingredients;
  }

  public ArrayList<String> getMenu() {
    menu.add(AMERICANO);
    menu.add(BLACK_COFFEE);
    menu.add(CAFE_MOCHA);
    return menu;
  }

  public ArrayList<String> getIngredients(String type) {
    ArrayList<String> ingredients = new ArrayList<>();
    switch (type) {
      case AMERICANO:
        ingredients = americano.getIngredients();
        break;
      case BLACK_COFFEE:
        ingredients = blackCoffee.getIngredients();
        break;
      case CAFE_MOCHA:
        ingredients = cafeMocha.getIngredients();
        break;
      default:
        break;
    }
    return ingredients;
  }
}

class Beverage {
  private int sugarCost = 25;
  private int creamCost = 25;
  private int coffeeCost = 75;
  private int milkCost = 50;
  private int chocolateCost = 50;
  private ArrayList<String> ingredients = new ArrayList<>();

  Beverage() {
  }

  Beverage(int A, int B, int C, int D) {
    for (int i = 1; i <= 4; i++) {
      switch (i) {
        case 1:
          ingredients.add("Coffee");
          break;
        case 2:
          ingredients.add("Cream");
          break;
        case 3:
          ingredients.add("Sugar");
          break;
        case 4:
          ingredients.add("Water");
          break;
        case 5:
          ingredients.add("Chocolate");
          break;
        case 6:
          ingredients.add("Milk");
          break;
        default:
          break;
      }
    }
  }

  public int getSugarCost() {
    return sugarCost;
  }

  public int getCreamCost() {
    return creamCost;
  }

  public int getCoffeeCost() {
    return coffeeCost;
  }

  public int getMilkCost() {
    return milkCost;
  }

  public int getChocolateCost() {
    return chocolateCost;
  }

  public ArrayList<String> getIngredients() {
    Collections.sort(ingredients);
    return ingredients;
  }
}
