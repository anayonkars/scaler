public class CostCalculator {
    private CostCalculator() {

    }

    public static int calculateCost(Beverage beverage) {
        int cost = 0;
        cost += beverage.getCoffeeQuantity() * Beverage.COFFEE_COST;
        cost += beverage.getCreamQuantity() * Beverage.CREAM_COST;
        cost += beverage.getMilkQuantity() * Beverage.MILK_COST;
        cost += beverage.getSugarQuantity() * Beverage.CREAM_COST;
        return cost;
    }
}
