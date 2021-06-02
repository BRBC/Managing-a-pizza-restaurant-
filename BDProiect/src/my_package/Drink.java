package my_package;

public class Drink {
    private String name;
    private String type;
    private int volume;
    private int price;
    private int drinkID;

    public Drink(String n,int ID, String t, int v, int p) {
        name = n;
        drinkID=ID;
        type = t;
        volume = v;
        price = p;
    }

    public int getDrinkID() {
        return drinkID;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }

    public int getPrice() {
        return price;
    }
}
