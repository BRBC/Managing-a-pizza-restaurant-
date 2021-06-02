package my_package;

public class Pizza {
    private String name;
    private String cheese_type;
    private int size;
    private int price;
    private int drinkID;
    private int pizzaID;

    public Pizza(String n, int p, int s, int pr, int dID) {
        name = n;
        pizzaID = p;
        size = s;
        price = pr;
        drinkID = dID;
    }

    public int getPizzaID() {
        return pizzaID;
    }

    public String getName() {
        return name;
    }


    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public int getDrinkID() {
        return drinkID;
    }
}
