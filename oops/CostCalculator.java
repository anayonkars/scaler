import java.util.Map;

public class CostCalculator {
    private CostCalculator() {

    }

    public static int calculateCost(Beverage beverage) {
        int cost = 0;
        for (Map.Entry<Ingredient, Integer> entry : beverage.getRecipe().entrySet()) {
            cost += entry.getKey().getCost() * entry.getValue();
        }
        return cost;
    }
}
