package my_package;

public class PizzaTopping {
    private String meat_type;
    private String cheese_type;
    private String extras;
    private int pizzaID;

    public PizzaTopping(int pID,String m,String c,String e) {
        pizzaID=pID;
        meat_type = m;
        cheese_type = c;
        extras=e;
    }


    public String getMeat_type() {
        return meat_type;
    }

    public String getCheese_type() {
        return cheese_type;
    }

    public String getExtras() {
        return extras;
    }

    public int getPizzaID() {
        return pizzaID;
    }
}
