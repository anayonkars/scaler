import java.util.ArrayList;
import java.util.Collections;

class Beverage {
  private final int sugarCost = 25;
  private final int creamCost = 25;
  private final int coffeeCost = 75;
  private final int milkCost = 50;
  private final int chocolateCost = 50;
  private final ArrayList<String> ingredients = new ArrayList<>();

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
