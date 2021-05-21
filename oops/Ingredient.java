public enum Ingredient {
    COFFEE("Coffee", 75),
    SUGAR("Sugar", 25),
    CREAM("Cream", 25),
    MILK("Milk", 50),
    CHOCOLATE("Chocolate", 50);

    private final String name;
    private final int cost;

    Ingredient(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
