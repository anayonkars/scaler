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
    INGREDIENTS.add("Coffee");
    INGREDIENTS.add("Cream");
    INGREDIENTS.add("Sugar");
    INGREDIENTS.add("Water");
    Collections.sort(INGREDIENTS);
    /*INGREDIENTS.add("Chocolate");
    INGREDIENTS.add("Milk");*/
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
    return INGREDIENTS;
  }
}
