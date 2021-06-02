package my_package;

public class Sauce {
    private String name;
    private int sauceID;
    private int quantity;
    private int price;

    public Sauce(String n, int ID, int q, int pr) {
        name = n;
        sauceID = ID;
        quantity=q;
        price = pr;
    }


    public String getName() {
        return name;
    }

    public int getSauceID() {
        return sauceID;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
