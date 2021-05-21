import java.util.ArrayList;
import java.util.Collections;

class Beverage {
  public static final int SUGAR_COST = 25;
  public static final int CREAM_COST = 25;
  public static final int COFFEE_COST = 75;
  public static final int MILK_COST = 50;
  public static final int CHOCOLATE_COST = 50;
  private final ArrayList<String> INGREDIENTS = new ArrayList<>();

  private int sugarQuantity;
  private int creamQuantity;
  private int milkQuantity;
  private int coffeeQuantity;

  Beverage() {
    INGREDIENTS.add("Coffee");
    INGREDIENTS.add("Cream");
    INGREDIENTS.add("Sugar");
    INGREDIENTS.add("Water");
    Collections.sort(INGREDIENTS);
    /*INGREDIENTS.add("Chocolate");
    INGREDIENTS.add("Milk");*/
  }

  public int getSugarQuantity() {
    return sugarQuantity;
  }

  public int getCreamQuantity() {
    return creamQuantity;
  }

  public int getMilkQuantity() {
    return milkQuantity;
  }

  public int getCoffeeQuantity() {
    return coffeeQuantity;
  }

  public ArrayList<String> getIngredients() {
    return INGREDIENTS;
  }


  public static final class BeverageBuilder {
    private int sugarQuantity;
    private int creamQuantity;
    private int milkQuantity;
    private int coffeeQuantity;

    private BeverageBuilder() {
    }

    public static BeverageBuilder aBeverage() {
      return new BeverageBuilder();
    }

    public BeverageBuilder withSugarQuantity(int sugarQuantity) {
      this.sugarQuantity = sugarQuantity;
      return this;
    }

    public BeverageBuilder withCreamQuantity(int creamQuantity) {
      this.creamQuantity = creamQuantity;
      return this;
    }

    public BeverageBuilder withMilkQuantity(int milkQuantity) {
      this.milkQuantity = milkQuantity;
      return this;
    }

    public BeverageBuilder withCoffeeQuantity(int coffeeQuantity) {
      this.coffeeQuantity = coffeeQuantity;
      return this;
    }

    public Beverage build() {
      Beverage beverage = new Beverage();
      beverage.sugarQuantity = this.sugarQuantity;
      beverage.milkQuantity = this.milkQuantity;
      beverage.creamQuantity = this.creamQuantity;
      beverage.coffeeQuantity = this.coffeeQuantity;
      return beverage;
    }
  }
}
