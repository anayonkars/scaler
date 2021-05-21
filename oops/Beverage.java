import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Beverage {
  public static final int SUGAR_COST = 25;
  public static final int CREAM_COST = 25;
  public static final int COFFEE_COST = 75;
  public static final int MILK_COST = 50;
  public static final int CHOCOLATE_COST = 50;
  private final ArrayList<String> INGREDIENTS = new ArrayList<>();

  private final Map<Ingredient, Integer> recipe = new HashMap<>();
  private String name;

  Beverage() {
    INGREDIENTS.add("Coffee");
    INGREDIENTS.add("Cream");
    INGREDIENTS.add("Sugar");
    INGREDIENTS.add("Water");
    Collections.sort(INGREDIENTS);
    this.name = name;
    /*INGREDIENTS.add("Chocolate");
    INGREDIENTS.add("Milk");*/
  }

  @Override
  public String toString() {
    return "Beverage{" +
            "recipe=" + recipe +
            ", name='" + name + '\'' +
            '}';
  }

  public Map<Ingredient, Integer> getRecipe() {
    return recipe;
  }

  public ArrayList<String> getIngredients() {
    return INGREDIENTS;
  }


  public static final class BeverageBuilder {
    private int sugarQuantity;
    private int creamQuantity;
    private int milkQuantity;
    private int coffeeQuantity;
    private String name;

    private BeverageBuilder() {
    }

    public static BeverageBuilder aBeverage() {
      return new BeverageBuilder();
    }

    public BeverageBuilder withSugar(int sugarQuantity) {
      this.sugarQuantity = sugarQuantity;
      return this;
    }

    public BeverageBuilder withCream(int creamQuantity) {
      this.creamQuantity = creamQuantity;
      return this;
    }

    public BeverageBuilder withMilk(int milkQuantity) {
      this.milkQuantity = milkQuantity;
      return this;
    }

    public BeverageBuilder withCoffee(int coffeeQuantity) {
      this.coffeeQuantity = coffeeQuantity;
      return this;
    }

    public BeverageBuilder withName(String name) {
      this.name = name;
      return this;
    }

    public Beverage build() {
      Beverage beverage = new Beverage();
      beverage.recipe.put(Ingredient.SUGAR, sugarQuantity);
      beverage.recipe.put(Ingredient.MILK, milkQuantity);
      beverage.recipe.put(Ingredient.CREAM, creamQuantity);
      beverage.recipe.put(Ingredient.COFFEE, coffeeQuantity);
      beverage.name = this.name;
      return beverage;
    }
  }
}
