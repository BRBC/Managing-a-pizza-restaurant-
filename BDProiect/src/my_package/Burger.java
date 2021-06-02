/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_package;

/**
 *
 * @author user
 */
class Burger {
    private String name;
    private String meat_type;
    private int weight;
    private int price;
    private int sauceID;
    private int burgerID;

    public Burger(String n,int b,String m,int w, int p, int sID){
        name=n;
        meat_type=m;
        weight=w;
        price=p;
        sauceID=sID;
        burgerID=b;
    }

    public int getBurgerID() {
        return burgerID;
    }


    public String getName() {
        return name;
    }

    public String getMeat_type() {
        return meat_type;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public int getSauceID() {
        return sauceID;
    }
}
