import java.util.ArrayList;
import java.util.Collections;

class Beverage {
  public static final int SUGAR_COST = 25;
  public static final int CREAM_COST = 25;
  public static final int COFFEE_COST = 75;
  public static final int MILK_COST = 50;
  public static final int CHOCOLATE_COST = 50;
  private final ArrayList<String> INGREDIENTS = new ArrayList<>();

  Beverage(int A, int B, int C, int D) {
    for (int i = 1; i <= 4; i++) {
      switch (i) {
        case 1:
          INGREDIENTS.add("Coffee");
          break;
        case 2:
          INGREDIENTS.add("Cream");
          break;
        case 3:
          INGREDIENTS.add("Sugar");
          break;
        case 4:
          INGREDIENTS.add("Water");
          break;
        case 5:
          INGREDIENTS.add("Chocolate");
          break;
        case 6:
          INGREDIENTS.add("Milk");
          break;
        default:
          break;
      }
    }
  }

  public int getSugarCost() {
    return SUGAR_COST;
  }

  public int getCreamCost() {
    return CREAM_COST;
  }

  public int getCoffeeCost() {
    return COFFEE_COST;
  }

  public int getMilkCost() {
    return MILK_COST;
  }

  public int getChocolateCost() {
    return CHOCOLATE_COST;
  }

  public ArrayList<String> getIngredients() {
    Collections.sort(INGREDIENTS);
    return INGREDIENTS;
  }
}
