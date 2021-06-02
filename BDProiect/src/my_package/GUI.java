/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_package;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();

    }

    public ArrayList<Burger> burgerList(){
        ArrayList<Burger> burgersList=new ArrayList<>();
        String dbURL="jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username="bd005";
        String password="bd005";
        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement=connection.createStatement();
            String query="SELECT * FROM burgers";
            ResultSet rs=statement.executeQuery(query);
            Burger burger;
            while(rs.next()){
                burger=new Burger(rs.getString("burger_name"),rs.getInt("burger_id"), rs.getString("burger_meat_type"),rs.getInt("burger_weight"), rs.getInt("burger_price"),rs.getInt("sauce_id"));
                burgersList.add(burger);
            }

            connection.close();
        }catch (SQLException e){
            System.out.println("Not connected to database");
            e.printStackTrace();
        }
        return burgersList;
    }

    public void show_burgers(){
        ArrayList<Burger> list=burgerList();
        DefaultTableModel model=(DefaultTableModel)burgerTable.getModel();
        Object[] row=new Object[6];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getName();
            row[1]=list.get(i).getBurgerID();
            row[2]=list.get(i).getMeat_type();
            row[3]=list.get(i).getWeight();
            row[4]=list.get(i).getPrice();
            row[5]=list.get(i).getSauceID();
            model.addRow(row);
        }
    }


    public ArrayList<Pizza> pizzaList(){
        ArrayList<Pizza> pizzasList=new ArrayList<>();
        String dbURL="jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username="bd005";
        String password="bd005";
        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement=connection.createStatement();
            String query="SELECT * FROM pizza";
            ResultSet rs=statement.executeQuery(query);
            Pizza pizza;
            while(rs.next()){
                pizza=new Pizza(rs.getString("pizza_name"),rs.getInt("pizza_id"),rs.getInt("pizza_size"),rs.getInt("pizza_price"),rs.getInt("drink_id"));
                pizzasList.add(pizza);
            }

            connection.close();
        }catch (SQLException e){
            System.out.println("Not connected to database");
            e.printStackTrace();
        }
        return pizzasList;
    }

    public void show_pizzas(){
        ArrayList<Pizza> list=pizzaList();
        DefaultTableModel model=(DefaultTableModel)pizzaTable.getModel();
        Object[] row=new Object[5];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getName();
            row[1]=list.get(i).getPizzaID();
            row[2]=list.get(i).getSize();
            row[3]=list.get(i).getPrice();
            row[4]=list.get(i).getDrinkID();
            model.addRow(row);
        }
    }


    public ArrayList<Drink> drinkList(){
        ArrayList<Drink> drinksList=new ArrayList<>();
        String dbURL="jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username="bd005";
        String password="bd005";
        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement=connection.createStatement();
            String query="SELECT * FROM drinks";
            ResultSet rs=statement.executeQuery(query);
            Drink drink;
            while(rs.next()){
                drink=new Drink(rs.getString("drink_name"),rs.getInt("drink_id"),rs.getString("drink_type"),rs.getInt("drink_price"),rs.getInt("drink_volume"));
                drinksList.add(drink);
            }

            connection.close();
        }catch (SQLException e){
            System.out.println("Not connected to database");
            e.printStackTrace();
        }
        return drinksList;
    }

    public void show_drinks(){
        ArrayList<Drink> list=drinkList();
        DefaultTableModel model=(DefaultTableModel)drinkTable.getModel();
        Object[] row=new Object[5];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getName();
            row[1]=list.get(i).getDrinkID();
            row[2]=list.get(i).getType();
            row[3]=list.get(i).getVolume();
            row[4]=list.get(i).getPrice();
            model.addRow(row);
        }
    }

    public ArrayList<Sauce> sauceList(){
        ArrayList<Sauce> saucesList=new ArrayList<>();
        String dbURL="jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username="bd005";
        String password="bd005";
        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement=connection.createStatement();
            String query="SELECT * FROM sauce";
            ResultSet rs=statement.executeQuery(query);
            Sauce sauce;
            while(rs.next()){
                sauce=new Sauce(rs.getString("sauce_name"),rs.getInt("sauce_id"),rs.getInt("sauce_quantity"),rs.getInt("sauce_price"));
                saucesList.add(sauce);
            }

            connection.close();
        }catch (SQLException e){
            System.out.println("Not connected to database");
            e.printStackTrace();
        }
        return saucesList;
    }

    public void show_sauce(){
        ArrayList<Sauce> list=sauceList();
        DefaultTableModel model=(DefaultTableModel)sauceTable.getModel();
        Object[] row=new Object[4];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getName();
            row[1]=list.get(i).getSauceID();
            row[2]=list.get(i).getQuantity();
            row[3]=list.get(i).getPrice();
            model.addRow(row);
        }
    }

    public ArrayList<PizzaTopping> pizzaToppingList(){
        ArrayList<PizzaTopping> pizzaToppingsList=new ArrayList<>();
        String dbURL="jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username="bd005";
        String password="bd005";
        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement=connection.createStatement();
            String query="SELECT * FROM pizzatopping";
            ResultSet rs=statement.executeQuery(query);
            PizzaTopping pizzatopping;
            while(rs.next()){
                pizzatopping=new PizzaTopping(rs.getInt("pizza_id"),rs.getString("meat_type"),rs.getString("cheese_type"),rs.getString("extra_topping"));
                pizzaToppingsList.add(pizzatopping);
            }

            connection.close();
        }catch (SQLException e){
            System.out.println("Not connected to database");
            e.printStackTrace();
        }
        return pizzaToppingsList;
    }

    public void show_pizzatopping(){
        ArrayList<PizzaTopping> list=pizzaToppingList();
        DefaultTableModel model=(DefaultTableModel)pizzaToppingTable.getModel();
        Object[] row=new Object[4];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getPizzaID();
            row[1]=list.get(i).getMeat_type();
            row[2]=list.get(i).getCheese_type();
            row[3]=list.get(i).getExtras();
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        buttonsPanel = new javax.swing.JPanel();
        pizzaButton = new javax.swing.JButton();
        burgerButton = new javax.swing.JButton();
        drinksButton = new javax.swing.JButton();
        sauceButton = new javax.swing.JButton();
        pizzaToppingButton = new javax.swing.JButton();
        showPanel = new javax.swing.JPanel();
        pizzaPanel = new javax.swing.JPanel();
        pizzaNameLabel = new javax.swing.JLabel();
        pizzaSizeLabel = new javax.swing.JLabel();
        pizzaPriceLabel = new javax.swing.JLabel();
        pizzaDrinkIDLabel = new javax.swing.JLabel();
        pizzaNameField = new javax.swing.JTextField();
        pizzaSizeField = new javax.swing.JTextField();
        pizzaPriceField = new javax.swing.JTextField();
        pizzaDrinkIDField = new javax.swing.JTextField();
        insertPizzaButton = new javax.swing.JButton();
        updatePizzaButton = new javax.swing.JButton();
        deletePizzaButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        pizzaTable = new javax.swing.JTable();
        pizzaIDField = new javax.swing.JTextField();
        pizzaIDLabel = new javax.swing.JLabel();
        pizzaShow = new javax.swing.JButton();
        burgerPanel = new javax.swing.JPanel();
        burgerNameField = new javax.swing.JTextField();
        burgerNameLabel = new javax.swing.JLabel();
        burgerIDField = new javax.swing.JTextField();
        burgerIDLabel = new javax.swing.JLabel();
        burgerMeatTypeField = new javax.swing.JTextField();
        burgerMeatTypeLabel = new javax.swing.JLabel();
        burgerSauceIDField = new javax.swing.JTextField();
        burgerSauceIDLabel = new javax.swing.JLabel();
        burgerWeightField = new javax.swing.JTextField();
        burgerWeightLabel = new javax.swing.JLabel();
        burgerPriceField = new javax.swing.JTextField();
        burgerPriceLabel = new javax.swing.JLabel();
        insertBurgerButton = new javax.swing.JButton();
        updateBurgerButton = new javax.swing.JButton();
        deleteBurgerButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        burgerTable = new javax.swing.JTable();
        burgerShow = new javax.swing.JButton();
        drinksPanel = new javax.swing.JPanel();
        drinkPriceLabel = new javax.swing.JLabel();
        drinkVolumeField = new javax.swing.JTextField();
        drinkNameField = new javax.swing.JTextField();
        drinkVolumeLabel = new javax.swing.JLabel();
        drinkNameLabel = new javax.swing.JLabel();
        insertDrinkButton = new javax.swing.JButton();
        drinkIDField = new javax.swing.JTextField();
        updateDrinkButton = new javax.swing.JButton();
        drinkIDLabel = new javax.swing.JLabel();
        deleteDrinkButton = new javax.swing.JButton();
        drinkTypeField = new javax.swing.JTextField();
        drinkTypeLabel = new javax.swing.JLabel();
        drinkPriceField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        drinkTable = new javax.swing.JTable();
        drinkShow = new javax.swing.JButton();
        saucePanel = new javax.swing.JPanel();
        saucePriceLabel = new javax.swing.JLabel();
        sauceNameField = new javax.swing.JTextField();
        sauceNameLabel = new javax.swing.JLabel();
        insertSauceButton = new javax.swing.JButton();
        updateSauceButton = new javax.swing.JButton();
        deleteSauceButton = new javax.swing.JButton();
        sauceQuantityField = new javax.swing.JTextField();
        sauceQuantityLabel = new javax.swing.JLabel();
        sauceIDField = new javax.swing.JTextField();
        sauceIDLabel = new javax.swing.JLabel();
        saucePriceField = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        sauceTable = new javax.swing.JTable();
        sauceShow = new javax.swing.JButton();
        pizzaToppingPanel = new javax.swing.JPanel();
        pizzaToppingMeatTypeLabel = new javax.swing.JLabel();
        pizzaToppingCheeseTypeLabel = new javax.swing.JLabel();
        pizzaToppingExtraLabel = new javax.swing.JLabel();
        pizzaToppingMeatTypeField = new javax.swing.JTextField();
        pizzaToppingCheeseTypeField = new javax.swing.JTextField();
        pizzaToppingExtraField = new javax.swing.JTextField();
        insertPizzaTopping = new javax.swing.JButton();
        updatePizzaTopping = new javax.swing.JButton();
        deletePizzaTopping = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        pizzaToppingTable = new javax.swing.JTable();
        pizzaToppingIDField = new javax.swing.JTextField();
        pizzaToppingIDLabel = new javax.swing.JLabel();
        pizzaToppingShow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setForeground(new java.awt.Color(255, 204, 204));

        pizzaButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pizzaButton.setText("Pizza");
        pizzaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pizzaButtonActionPerformed(evt);
            }
        });

        burgerButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        burgerButton.setText("Burgers");
        burgerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                burgerButtonActionPerformed(evt);
            }
        });

        drinksButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        drinksButton.setText("Drinks");
        drinksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drinksButtonActionPerformed(evt);
            }
        });

        sauceButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sauceButton.setText("Sauce");
        sauceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sauceButtonActionPerformed(evt);
            }
        });

        pizzaToppingButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pizzaToppingButton.setText("Pizza Topping");
        pizzaToppingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pizzaToppingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
                buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonsPanelLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(pizzaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(burgerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pizzaToppingButton)
                                .addGap(66, 66, 66)
                                .addComponent(sauceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(drinksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
        );
        buttonsPanelLayout.setVerticalGroup(
                buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonsPanelLayout.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pizzaToppingButton, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                        .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(sauceButton, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                                        .addComponent(drinksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(pizzaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(burgerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        showPanel.setLayout(new java.awt.CardLayout());

        pizzaNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pizzaNameLabel.setText("Pizza name:");

        pizzaSizeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pizzaSizeLabel.setText("Pizza size:");

        pizzaPriceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pizzaPriceLabel.setText("Pizza price:");

        pizzaDrinkIDLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pizzaDrinkIDLabel.setText("Drink ID:");

        insertPizzaButton.setText("Insert");
        insertPizzaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertPizzaButtonActionPerformed(evt);
            }
        });

        updatePizzaButton.setText("Update");
        updatePizzaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePizzaButtonActionPerformed(evt);
            }
        });

        deletePizzaButton.setText("Delete");
        deletePizzaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePizzaButtonActionPerformed(evt);
            }
        });

        pizzaTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Name ", "ID", "Size", "Price ", "drink_ID"
                }
        ));
        jScrollPane2.setViewportView(pizzaTable);
        if (pizzaTable.getColumnModel().getColumnCount() > 0) {
            pizzaTable.getColumnModel().getColumn(4).setHeaderValue("drink_ID");
        }

        pizzaIDLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pizzaIDLabel.setText("Pizza ID:");

        pizzaShow.setText("Show");
        pizzaShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pizzaShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pizzaPanelLayout = new javax.swing.GroupLayout(pizzaPanel);
        pizzaPanel.setLayout(pizzaPanelLayout);
        pizzaPanelLayout.setHorizontalGroup(
                pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pizzaPanelLayout.createSequentialGroup()
                                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(pizzaPanelLayout.createSequentialGroup()
                                                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pizzaPanelLayout.createSequentialGroup()
                                                                .addGap(151, 151, 151)
                                                                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(pizzaDrinkIDLabel)
                                                                        .addComponent(pizzaSizeLabel)
                                                                        .addComponent(pizzaPriceLabel)
                                                                        .addComponent(pizzaNameLabel))
                                                                .addGap(18, 18, 18))
                                                        .addGroup(pizzaPanelLayout.createSequentialGroup()
                                                                .addGap(162, 162, 162)
                                                                .addComponent(pizzaIDLabel)
                                                                .addGap(24, 24, 24)))
                                                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(pizzaIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pizzaNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pizzaSizeField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pizzaPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pizzaDrinkIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(pizzaPanelLayout.createSequentialGroup()
                                                .addComponent(insertPizzaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(updatePizzaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(deletePizzaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(pizzaShow, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
        );
        pizzaPanelLayout.setVerticalGroup(
                pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pizzaPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pizzaPanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(pizzaPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(pizzaNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pizzaNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(pizzaSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pizzaSizeField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(pizzaPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pizzaPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(pizzaDrinkIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pizzaDrinkIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(pizzaIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pizzaIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(31, 31, 31)
                                                .addGroup(pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(insertPizzaButton)
                                                        .addComponent(updatePizzaButton)
                                                        .addComponent(deletePizzaButton)
                                                        .addComponent(pizzaShow))
                                                .addGap(37, 37, 37))))
        );

        showPanel.add(pizzaPanel, "card2");

        burgerNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        burgerNameLabel.setText("Burger name:");

        burgerIDLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        burgerIDLabel.setText("Burger ID:");

        burgerMeatTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        burgerMeatTypeLabel.setText("Burger meat type:");

        burgerSauceIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                burgerSauceIDFieldActionPerformed(evt);
            }
        });

        burgerSauceIDLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        burgerSauceIDLabel.setText("Sauce ID:");

        burgerWeightLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        burgerWeightLabel.setText("Burger weight:");

        burgerPriceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        burgerPriceLabel.setText("Burger price:");

        insertBurgerButton.setText("Insert");
        insertBurgerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBurgerButtonActionPerformed(evt);
            }
        });

        updateBurgerButton.setText("Update");
        updateBurgerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBurgerButtonActionPerformed(evt);
            }
        });

        deleteBurgerButton.setText("Delete");
        deleteBurgerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBurgerButtonActionPerformed(evt);
            }
        });

        burgerTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Name ", "ID", "Meat_type ", "Weight ", "Price ", "Sauce_ID"
                }
        ));
        jScrollPane1.setViewportView(burgerTable);
        if (burgerTable.getColumnModel().getColumnCount() > 0) {
            burgerTable.getColumnModel().getColumn(5).setHeaderValue("Sauce_ID");
        }

        burgerShow.setText("Show");
        burgerShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                burgerShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout burgerPanelLayout = new javax.swing.GroupLayout(burgerPanel);
        burgerPanel.setLayout(burgerPanelLayout);
        burgerPanelLayout.setHorizontalGroup(
                burgerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(burgerPanelLayout.createSequentialGroup()
                                .addGroup(burgerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(burgerPanelLayout.createSequentialGroup()
                                                .addGap(90, 90, 90)
                                                .addGroup(burgerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(burgerPanelLayout.createSequentialGroup()
                                                                .addComponent(burgerIDLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(burgerIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(burgerPanelLayout.createSequentialGroup()
                                                                .addComponent(burgerSauceIDLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(burgerSauceIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(burgerPanelLayout.createSequentialGroup()
                                                                .addComponent(burgerNameLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(burgerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(burgerPanelLayout.createSequentialGroup()
                                                                .addComponent(burgerMeatTypeLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(burgerMeatTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(burgerPanelLayout.createSequentialGroup()
                                                                .addComponent(burgerWeightLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(burgerWeightField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(burgerPanelLayout.createSequentialGroup()
                                                                .addComponent(burgerPriceLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(burgerPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(burgerPanelLayout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(insertBurgerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(updateBurgerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(deleteBurgerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(burgerShow, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
        );
        burgerPanelLayout.setVerticalGroup(
                burgerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(burgerPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(burgerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, burgerPanelLayout.createSequentialGroup()
                                                .addGroup(burgerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(burgerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(burgerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(burgerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(burgerMeatTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(burgerMeatTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(6, 6, 6)
                                                .addGroup(burgerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(burgerWeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(burgerWeightField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(burgerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(burgerPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(burgerPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(burgerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(burgerSauceIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(burgerSauceIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(burgerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(burgerIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(burgerIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(burgerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(insertBurgerButton)
                                                        .addComponent(updateBurgerButton)
                                                        .addComponent(deleteBurgerButton)
                                                        .addComponent(burgerShow))))
                                .addContainerGap(27, Short.MAX_VALUE))
        );

        showPanel.add(burgerPanel, "card2");

        drinkPriceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        drinkPriceLabel.setText("Drink price:");

        drinkVolumeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        drinkVolumeLabel.setText("Drink volume:");

        drinkNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        drinkNameLabel.setText("Drink name:");

        insertDrinkButton.setText("Insert");
        insertDrinkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertDrinkButtonActionPerformed(evt);
            }
        });

        updateDrinkButton.setText("Update");
        updateDrinkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDrinkButtonActionPerformed(evt);
            }
        });

        drinkIDLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        drinkIDLabel.setText("Drink ID:");

        deleteDrinkButton.setText("Delete");
        deleteDrinkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDrinkButtonActionPerformed(evt);
            }
        });

        drinkTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        drinkTypeLabel.setText("Drink type:");

        drinkTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Name ", "ID", "Type ", "Volume", "Price "
                }
        ));
        jScrollPane3.setViewportView(drinkTable);
        if (drinkTable.getColumnModel().getColumnCount() > 0) {
            drinkTable.getColumnModel().getColumn(2).setHeaderValue("Type ");
            drinkTable.getColumnModel().getColumn(3).setHeaderValue("Volume");
        }

        drinkShow.setText("Show");
        drinkShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drinkShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout drinksPanelLayout = new javax.swing.GroupLayout(drinksPanel);
        drinksPanel.setLayout(drinksPanelLayout);
        drinksPanelLayout.setHorizontalGroup(
                drinksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(drinksPanelLayout.createSequentialGroup()
                                .addGroup(drinksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(drinksPanelLayout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(insertDrinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(updateDrinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(deleteDrinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(drinkShow, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drinksPanelLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(drinksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(drinksPanelLayout.createSequentialGroup()
                                                                .addComponent(drinkIDLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(drinkIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(drinksPanelLayout.createSequentialGroup()
                                                                .addComponent(drinkNameLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(drinkNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(drinksPanelLayout.createSequentialGroup()
                                                                .addComponent(drinkTypeLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(drinkTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(drinksPanelLayout.createSequentialGroup()
                                                                .addComponent(drinkPriceLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(drinkPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(drinksPanelLayout.createSequentialGroup()
                                                                .addComponent(drinkVolumeLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(drinkVolumeField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(83, 83, 83)))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
        );
        drinksPanelLayout.setVerticalGroup(
                drinksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(drinksPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(drinksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(drinksPanelLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(drinksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(drinkNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(drinkNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(drinksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(drinkTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(drinkTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(6, 6, 6)
                                                .addGroup(drinksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(drinkPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(drinkPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(drinksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(drinkVolumeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(drinkVolumeField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(drinksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(drinkIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(drinkIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(38, 38, 38)
                                                .addGroup(drinksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(insertDrinkButton)
                                                        .addComponent(updateDrinkButton)
                                                        .addComponent(deleteDrinkButton)
                                                        .addComponent(drinkShow))
                                                .addGap(0, 23, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        showPanel.add(drinksPanel, "card2");

        saucePriceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        saucePriceLabel.setText("Sauce price:");

        sauceNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sauceNameLabel.setText("Sauce name:");

        insertSauceButton.setText("Insert");
        insertSauceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertSauceButtonActionPerformed(evt);
            }
        });

        updateSauceButton.setText("Update");
        updateSauceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSauceButtonActionPerformed(evt);
            }
        });

        deleteSauceButton.setText("Delete");
        deleteSauceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSauceButtonActionPerformed(evt);
            }
        });

        sauceQuantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sauceQuantityFieldActionPerformed(evt);
            }
        });

        sauceQuantityLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sauceQuantityLabel.setText("Sauce quantity:");

        sauceIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sauceIDFieldActionPerformed(evt);
            }
        });

        sauceIDLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sauceIDLabel.setText("Sauce ID:");

        sauceTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Name ", "ID", "Quantity", "Price "
                }
        ));
        jScrollPane4.setViewportView(sauceTable);

        sauceShow.setText("Show");
        sauceShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sauceShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout saucePanelLayout = new javax.swing.GroupLayout(saucePanel);
        saucePanel.setLayout(saucePanelLayout);
        saucePanelLayout.setHorizontalGroup(
                saucePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(saucePanelLayout.createSequentialGroup()
                                .addGroup(saucePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(saucePanelLayout.createSequentialGroup()
                                                .addGap(90, 90, 90)
                                                .addGroup(saucePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(saucePanelLayout.createSequentialGroup()
                                                                .addComponent(sauceIDLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(sauceIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(saucePanelLayout.createSequentialGroup()
                                                                .addComponent(sauceNameLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(sauceNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(saucePanelLayout.createSequentialGroup()
                                                                .addComponent(sauceQuantityLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(sauceQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(saucePanelLayout.createSequentialGroup()
                                                                .addComponent(saucePriceLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(saucePriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(saucePanelLayout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(insertSauceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(updateSauceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(deleteSauceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(sauceShow, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
        );
        saucePanelLayout.setVerticalGroup(
                saucePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(saucePanelLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(saucePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(sauceNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sauceNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(saucePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(sauceQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sauceQuantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(saucePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(saucePriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(saucePriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(saucePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(sauceIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sauceIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(saucePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(insertSauceButton)
                                        .addComponent(updateSauceButton)
                                        .addComponent(deleteSauceButton)
                                        .addComponent(sauceShow))
                                .addContainerGap(32, Short.MAX_VALUE))
                        .addGroup(saucePanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
        );

        showPanel.add(saucePanel, "card2");

        pizzaToppingMeatTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pizzaToppingMeatTypeLabel.setText("Pizza meat type:");

        pizzaToppingCheeseTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pizzaToppingCheeseTypeLabel.setText("Pizza cheese type:");

        pizzaToppingExtraLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pizzaToppingExtraLabel.setText("Extras:");

        insertPizzaTopping.setText("Insert");
        insertPizzaTopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertPizzaToppingActionPerformed(evt);
            }
        });

        updatePizzaTopping.setText("Update");
        updatePizzaTopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePizzaToppingActionPerformed(evt);
            }
        });

        deletePizzaTopping.setText("Delete");
        deletePizzaTopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePizzaToppingActionPerformed(evt);
            }
        });

        pizzaToppingTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Meat_type", "Cheese_type", "Extras"
                }
        ));
        jScrollPane5.setViewportView(pizzaToppingTable);

        pizzaToppingIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pizzaToppingIDFieldActionPerformed(evt);
            }
        });

        pizzaToppingIDLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pizzaToppingIDLabel.setText("Pizza ID:");

        pizzaToppingShow.setText("Show");
        pizzaToppingShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pizzaToppingShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pizzaToppingPanelLayout = new javax.swing.GroupLayout(pizzaToppingPanel);
        pizzaToppingPanel.setLayout(pizzaToppingPanelLayout);
        pizzaToppingPanelLayout.setHorizontalGroup(
                pizzaToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pizzaToppingPanelLayout.createSequentialGroup()
                                .addGroup(pizzaToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pizzaToppingPanelLayout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addComponent(insertPizzaTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(updatePizzaTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(deletePizzaTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(pizzaToppingShow, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pizzaToppingPanelLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(pizzaToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(pizzaToppingCheeseTypeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(pizzaToppingExtraLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(pizzaToppingMeatTypeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(pizzaToppingIDLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(18, 18, 18)
                                                .addGroup(pizzaToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(pizzaToppingIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pizzaToppingMeatTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pizzaToppingCheeseTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pizzaToppingExtraField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(77, 77, 77)))
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
        );
        pizzaToppingPanelLayout.setVerticalGroup(
                pizzaToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pizzaToppingPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(pizzaToppingPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(pizzaToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pizzaToppingMeatTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pizzaToppingMeatTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pizzaToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pizzaToppingCheeseTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pizzaToppingCheeseTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pizzaToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pizzaToppingExtraLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pizzaToppingExtraField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pizzaToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pizzaToppingIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pizzaToppingIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addGroup(pizzaToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(insertPizzaTopping)
                                        .addComponent(updatePizzaTopping)
                                        .addComponent(deletePizzaTopping)
                                        .addComponent(pizzaToppingShow))
                                .addGap(37, 37, 37))
        );

        showPanel.add(pizzaToppingPanel, "card2");

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(contentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(showPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(contentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(showPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void pizzaButtonActionPerformed(java.awt.event.ActionEvent evt) {

        showPanel.removeAll();
        showPanel.repaint();
        showPanel.revalidate();
        showPanel.add(pizzaPanel);

        showPanel.repaint();
        showPanel.revalidate();
    }

    private void burgerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showPanel.removeAll();
        showPanel.repaint();
        showPanel.revalidate();
        showPanel.add(burgerPanel);

        showPanel.repaint();
        showPanel.revalidate();
    }

    private void drinksButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        showPanel.removeAll();
        showPanel.repaint();
        showPanel.revalidate();
        showPanel.add(drinksPanel);

        showPanel.repaint();
        showPanel.revalidate();
    }

    private void sauceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        showPanel.removeAll();
        showPanel.repaint();
        showPanel.revalidate();
        showPanel.add(saucePanel);

        showPanel.repaint();
        showPanel.revalidate();
    }

    private void burgerSauceIDFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void insertBurgerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String dbURL = "jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username = "bd005";
        String password = "bd005";
        String burgerName = burgerNameField.getText();
        String burgerMeatType = burgerMeatTypeField.getText();
        String burgerWeight = burgerWeightField.getText();
        String burgerPrice = burgerPriceField.getText();
        String burgerSauceID = burgerSauceIDField.getText();
        if ((burgerName.length() > 0) && (burgerMeatType.length() > 0) && (Integer.parseInt(burgerWeight) > 0) && Integer.parseInt(burgerPrice) > 0 && Integer.parseInt(burgerSauceID) > 0) {

            try {
                Connection connection = DriverManager.getConnection(dbURL, username, password);
                Statement statement = connection.createStatement();
                String sql = "INSERT INTO burgers(burger_name,burger_meat_type,burger_weight,burger_price,sauce_id) VALUES('" + burgerName + "','" + burgerMeatType + "'," + Integer.parseInt(burgerWeight) + "," + Integer.parseInt(burgerPrice) + "," + Integer.parseInt(burgerSauceID) + ")";
                int result = statement.executeUpdate(sql);
                if (result > 0) {
                    System.out.println("Row inserted");
                }

                connection.close();
            } catch (SQLException e) {
                System.out.println("Not connected to database");
                e.printStackTrace();
            }
        } else
            System.out.println("reintroduceti datele");
    }

    private void updateBurgerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String dbURL = "jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username = "bd005";
        String password = "bd005";
        String burgerName = burgerNameField.getText();
        String burgerMeatType = burgerMeatTypeField.getText();
        String burgerWeight = burgerWeightField.getText();
        String burgerPrice = burgerPriceField.getText();
        String burgerSauceID = burgerSauceIDField.getText();
        String burgerID=burgerIDField.getText();
        if ((burgerName.length() > 0) && Integer.parseInt(burgerID)>0 &&(burgerMeatType.length() > 0)
                && (Integer.parseInt(burgerWeight) > 0) && Integer.parseInt(burgerPrice) > 0 && Integer.parseInt(burgerSauceID) > 0 ) {

            try {
                Connection connection = DriverManager.getConnection(dbURL, username, password);
                Statement statement = connection.createStatement();
                String sql="UPDATE burgers SET burger_name='"+burgerName+"',burger_meat_type='"+burgerMeatType
                        +"',burger_weight="+burgerWeight+",burger_price="+burgerPrice+",sauce_id="
                        +burgerSauceID+" WHERE burger_id="+burgerID;

                int result = statement.executeUpdate(sql);
                if (result > 0) {
                    System.out.println("Row updated");
                }

                connection.close();
            } catch (SQLException e) {
                System.out.println("Not connected to database");
                e.printStackTrace();
            }
        } else
            System.out.println("reintroduceti datele");
    }

    private void deleteBurgerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String dbURL = "jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username = "bd005";
        String password = "bd005";
        String burgerID=burgerIDField.getText();
        if (Integer.parseInt(burgerID)>0 ) {

            try {
                Connection connection = DriverManager.getConnection(dbURL, username, password);
                Statement statement = connection.createStatement();
                String sql="DELETE FROM burgers WHERE burger_id="+burgerID;

                int result = statement.executeUpdate(sql);
                if (result > 0) {
                    System.out.println("Row deleted");
                }

                connection.close();
            } catch (SQLException e) {
                System.out.println("Not connected to database");
                e.printStackTrace();
            }
        } else
            System.out.println("reintroduceti datele");
    }

    private void insertPizzaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String pizzaName=pizzaNameField.getText();
        String pizzaSize=pizzaSizeField.getText();
        String pizzaPrice=pizzaPriceField.getText();
        String pizzaDrinkID=pizzaDrinkIDField.getText();
        String dbURL="jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username="bd005";
        String password="bd005";
        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement=connection.createStatement();
            String sql="INSERT INTO pizza(pizza_name,pizza_size,pizza_price,drink_id) VALUES('"+pizzaName+"',"+Integer.parseInt(pizzaSize)+","+Integer.parseInt(pizzaPrice)+","+Integer.parseInt(pizzaDrinkID)+")";
            int result=statement.executeUpdate(sql);
            if(result>0){
                System.out.println("Row inserted");
            }

            connection.close();
        }catch (SQLException e){
            System.out.println("Not connected to database");
            e.printStackTrace();
        }
    }

    private void updatePizzaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String pizzaName = pizzaNameField.getText();
        String pizzaSize = pizzaSizeField.getText();
        String pizzaPrice = pizzaPriceField.getText();
        String pizzaDrinkID = pizzaDrinkIDField.getText();
        String pizzaID = pizzaIDField.getText();
        String dbURL = "jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username = "bd005";
        String password = "bd005";
        if ((pizzaName.length() > 0) && Integer.parseInt(pizzaID) > 0
                &&(Integer.parseInt(pizzaSize) > 0) && Integer.parseInt(pizzaPrice) > 0
                && Integer.parseInt(pizzaDrinkID) > 0) {
            try {
                Connection connection = DriverManager.getConnection(dbURL, username, password);
                Statement statement = connection.createStatement();
                String sql = "UPDATE pizza SET pizza_name='" + pizzaName+ "',pizza_size=" + Integer.parseInt(pizzaSize) + ",pizza_price=" + Integer.parseInt(pizzaPrice) + ",drink_id=" + Integer.parseInt(pizzaDrinkID) + " WHERE pizza_id=" + Integer.parseInt(pizzaID);

                int result = statement.executeUpdate(sql);
                if (result > 0) {
                    System.out.println("Row updated");
                }

                connection.close();
            } catch (SQLException e) {
                System.out.println("Not connected to database");
                e.printStackTrace();
            }
        } else
            System.out.println("Reintroduceti datele");
    }

    private void deletePizzaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String pizzaID = pizzaIDField.getText();
        String dbURL = "jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username = "bd005";
        String password = "bd005";
        if (Integer.parseInt(pizzaID) > 0) {
            try {
                Connection connection = DriverManager.getConnection(dbURL, username, password);
                Statement statement = connection.createStatement();
                String sql="DELETE FROM pizza WHERE pizza_id="+pizzaID;
                int result = statement.executeUpdate(sql);
                if (result > 0) {
                    System.out.println("Row deleted");
                }

                connection.close();
            } catch (SQLException e) {
                System.out.println("Not connected to database");
                e.printStackTrace();
            }
        } else
            System.out.println("Reintroduceti datele");
    }

    private void insertDrinkButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String drinkName = drinkNameField.getText();
        String drinkType = drinkTypeField.getText();
        String drinkPrice = drinkPriceField.getText();
        String drinkVolume = drinkVolumeField.getText();
        String dbURL = "jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username = "bd005";
        String password = "bd005";
        if ((drinkName.length() > 0) && (drinkType.length() > 0) && (Integer.parseInt(drinkPrice) > 0) && Integer.parseInt(drinkVolume) > 0) {
            try {
                Connection connection = DriverManager.getConnection(dbURL, username, password);
                Statement statement = connection.createStatement();
                String sql = "INSERT INTO drinks(drink_name,drink_type,drink_price,drink_volume) VALUES('"+ drinkName + "','" + drinkType + "'," + Integer.parseInt(drinkPrice) + "," + Integer.parseInt(drinkVolume) + ")";
                int result = statement.executeUpdate(sql);
                if (result > 0) {
                    System.out.println("Row inserted");
                }
                connection.close();
            } catch (SQLException e) {
                System.out.println("Not connected to database");
                e.printStackTrace();
            }
        } else
            System.out.println("Reintroduceti datele");
    }

    private void updateDrinkButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String drinkName = drinkNameField.getText();
        String drinkType = drinkTypeField.getText();
        String drinkPrice = drinkPriceField.getText();
        String drinkVolume = drinkVolumeField.getText();
        String drinkID = drinkIDField.getText();
        String dbURL = "jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username = "bd005";
        String password = "bd005";
        if ((drinkName.length() > 0) && Integer.parseInt(drinkID) > 0 && (drinkType.length() > 0) && (Integer.parseInt(drinkPrice) > 0) && Integer.parseInt(drinkVolume) > 0) {
            try {
                Connection connection = DriverManager.getConnection(dbURL, username, password);
                Statement statement = connection.createStatement();
                String sql = "UPDATE drinks SET drink_name='" + drinkName + "',drink_type='" + drinkType + "',drink_price=" + Integer.parseInt(drinkPrice) + ",drink_volume=" + Integer.parseInt(drinkVolume) +" WHERE drink_id=" + Integer.parseInt(drinkID);
                int result = statement.executeUpdate(sql);
                if (result > 0) {
                    System.out.println("Row updated");
                }

                connection.close();
            } catch (SQLException e) {
                System.out.println("Not connected to database");
                e.printStackTrace();
            }
        } else
            System.out.println("Reintroduceti datele");
    }

    private void deleteDrinkButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String drinkID = drinkIDField.getText();
        String dbURL = "jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username = "bd005";
        String password = "bd005";
        if (Integer.parseInt(drinkID) > 0) {
            try {
                Connection connection = DriverManager.getConnection(dbURL, username, password);
                Statement statement = connection.createStatement();
                String sql="DELETE FROM drinks WHERE drink_id="+drinkID;
                int result = statement.executeUpdate(sql);
                if (result > 0) {
                    System.out.println("Row deleted");
                }

                connection.close();
            } catch (SQLException e) {
                System.out.println("Not connected to database");
                e.printStackTrace();
            }
        } else
            System.out.println("Reintroduceti datele");
    }

    private void insertSauceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String sauceName = sauceNameField.getText();
        String saucePrice = saucePriceField.getText();
        String sauceQuantity = sauceQuantityField.getText();
        String dbURL = "jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username = "bd005";
        String password = "bd005";
        if ((sauceName.length() > 0) && (Integer.parseInt(saucePrice) > 0) && Integer.parseInt(sauceQuantity) > 0) {//isEmplty
            try {
                Connection connection = DriverManager.getConnection(dbURL, username, password);
                Statement statement = connection.createStatement();
                String sql = "INSERT INTO sauce(sauce_name,sauce_price,sauce_quantity) VALUES('"+ sauceName + "'," + Integer.parseInt(saucePrice) + "," + Integer.parseInt(sauceQuantity) +")";
                int result = statement.executeUpdate(sql);
                if (result > 0) {
                    System.out.println("Row inserted");
                }

                connection.close();
            } catch (SQLException e) {
                System.out.println("Not connected to database");
                e.printStackTrace();
            }
        } else
            System.out.println("Reintroduceti datele");
    }

    private void updateSauceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String sauceName = sauceNameField.getText();
        String saucePrice = saucePriceField.getText();
        String sauceQuantity = sauceQuantityField.getText();
        String sauceID = sauceIDField.getText();
        String dbURL = "jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username = "bd005";
        String password = "bd005";
        if ((sauceName.length() > 0) && Integer.parseInt(sauceID) > 0 && (Integer.parseInt(saucePrice) > 0) && Integer.parseInt(sauceQuantity) > 0) {
            try {
                Connection connection = DriverManager.getConnection(dbURL, username, password);
                Statement statement = connection.createStatement();
                String sql = "UPDATE sauce SET sauce_name='" + sauceName + "',sauce_Price='" + Integer.parseInt(saucePrice) + "',sauce_quantity=" + Integer.parseInt(sauceQuantity) + " WHERE sauce_id=" + Integer.parseInt(sauceID);
                int result = statement.executeUpdate(sql);
                if (result > 0) {
                    System.out.println("Row updated");
                }

                connection.close();
            } catch (SQLException e) {
                System.out.println("Not connected to database");
                e.printStackTrace();
            }
        } else
            System.out.println("Reintroduceti datele");
    }

    private void deleteSauceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String sauceID = sauceIDField.getText();
        String dbURL = "jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username = "bd005";
        String password = "bd005";
        if (Integer.parseInt(sauceID) > 0) {
            try {
                Connection connection = DriverManager.getConnection(dbURL, username, password);
                Statement statement = connection.createStatement();
                String sql = "DELETE FROM sauce WHERE sauce_id=" + Integer.parseInt(sauceID);
                int result = statement.executeUpdate(sql);
                if (result > 0) {
                    System.out.println("Row deleted");
                }

                connection.close();
            } catch (SQLException e) {
                System.out.println("Not connected to database");
                e.printStackTrace();
            }
        } else
            System.out.println("Reintroduceti datele");
    }

    private void sauceIDFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void sauceQuantityFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void burgerShowActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model=(DefaultTableModel)burgerTable.getModel();
        model.setRowCount(0);
        show_burgers();
    }

    private void pizzaShowActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model=(DefaultTableModel)pizzaTable.getModel();
        model.setRowCount(0);
        show_pizzas();
    }

    private void drinkShowActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model=(DefaultTableModel)drinkTable.getModel();
        model.setRowCount(0);
        show_drinks();
    }

    private void sauceShowActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model=(DefaultTableModel)sauceTable.getModel();
        model.setRowCount(0);
        show_sauce();
    }

    private void pizzaToppingButtonActionPerformed(java.awt.event.ActionEvent evt) {

        showPanel.removeAll();
        showPanel.repaint();
        showPanel.revalidate();
        showPanel.add(pizzaToppingPanel);

        showPanel.repaint();
        showPanel.revalidate();
    }

    private void insertPizzaToppingActionPerformed(java.awt.event.ActionEvent evt) {
        String pizzaMeatType=pizzaToppingMeatTypeField.getText();
        String pizzaCheeseType=pizzaToppingCheeseTypeField.getText();
        String pizzaExtras=pizzaToppingExtraField.getText();
        String pizzaID=pizzaToppingIDField.getText();

        String dbURL="jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username="bd005";
        String password="bd005";
        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement=connection.createStatement();
            String sql="Insert into pizzatopping values("+pizzaID+",'"+pizzaMeatType+"','"+pizzaCheeseType+"','"+pizzaExtras+"')";
            int result=statement.executeUpdate(sql);
            if(result>0){
                System.out.println("Row inserted");
            }

            connection.close();
        }catch (SQLException e){
            System.out.println("Not connected to database");
            e.printStackTrace();
        }
    }

    private void updatePizzaToppingActionPerformed(java.awt.event.ActionEvent evt) {
        String pizzaMeatType=pizzaToppingMeatTypeField.getText();
        String pizzaCheeseType=pizzaToppingCheeseTypeField.getText();
        String pizzaExtras=pizzaToppingExtraField.getText();
        String pizzaID=pizzaToppingIDField.getText();

        String dbURL="jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username="bd005";
        String password="bd005";
        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement=connection.createStatement();
            String sql = "UPDATE pizzatopping SET meat_type='" + pizzaMeatType + "',cheese_type='" + pizzaCheeseType + "',extra_topping='" + pizzaExtras + "' WHERE pizza_id=" + Integer.parseInt(pizzaID);
            int result=statement.executeUpdate(sql);
            if(result>0){
                System.out.println("Row updated");
            }

            connection.close();
        }catch (SQLException e){
            System.out.println("Not connected to database");
            e.printStackTrace();
        }
    }

    private void deletePizzaToppingActionPerformed(java.awt.event.ActionEvent evt) {
        String pizzaID=pizzaToppingIDField.getText();

        String dbURL="jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl";
        String username="bd005";
        String password="bd005";
        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement=connection.createStatement();
            String sql = "DELETE FROM pizzatopping WHERE pizza_id=" + Integer.parseInt(pizzaID);
            int result=statement.executeUpdate(sql);
            if(result>0){
                System.out.println("Row deleted");
            }

            connection.close();
        }catch (SQLException e){
            System.out.println("Not connected to database");
            e.printStackTrace();
        }
    }

    private void pizzaToppingShowActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model=(DefaultTableModel)pizzaToppingTable.getModel();
        model.setRowCount(0);
        show_pizzatopping();
    }

    private void pizzaToppingIDFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton burgerButton;
    private javax.swing.JTextField burgerIDField;
    private javax.swing.JLabel burgerIDLabel;
    private javax.swing.JTextField burgerMeatTypeField;
    private javax.swing.JLabel burgerMeatTypeLabel;
    private javax.swing.JTextField burgerNameField;
    private javax.swing.JLabel burgerNameLabel;
    private javax.swing.JPanel burgerPanel;
    private javax.swing.JTextField burgerPriceField;
    private javax.swing.JLabel burgerPriceLabel;
    private javax.swing.JTextField burgerSauceIDField;
    private javax.swing.JLabel burgerSauceIDLabel;
    private javax.swing.JButton burgerShow;
    private javax.swing.JTable burgerTable;
    private javax.swing.JTextField burgerWeightField;
    private javax.swing.JLabel burgerWeightLabel;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton deleteBurgerButton;
    private javax.swing.JButton deleteDrinkButton;
    private javax.swing.JButton deletePizzaButton;
    private javax.swing.JButton deletePizzaTopping;
    private javax.swing.JButton deleteSauceButton;
    private javax.swing.JTextField drinkIDField;
    private javax.swing.JLabel drinkIDLabel;
    private javax.swing.JTextField drinkNameField;
    private javax.swing.JLabel drinkNameLabel;
    private javax.swing.JTextField drinkPriceField;
    private javax.swing.JLabel drinkPriceLabel;
    private javax.swing.JButton drinkShow;
    private javax.swing.JTable drinkTable;
    private javax.swing.JTextField drinkTypeField;
    private javax.swing.JLabel drinkTypeLabel;
    private javax.swing.JTextField drinkVolumeField;
    private javax.swing.JLabel drinkVolumeLabel;
    private javax.swing.JButton drinksButton;
    private javax.swing.JPanel drinksPanel;
    private javax.swing.JButton insertBurgerButton;
    private javax.swing.JButton insertDrinkButton;
    private javax.swing.JButton insertPizzaButton;
    private javax.swing.JButton insertPizzaTopping;
    private javax.swing.JButton insertSauceButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton pizzaButton;
    private javax.swing.JTextField pizzaDrinkIDField;
    private javax.swing.JLabel pizzaDrinkIDLabel;
    private javax.swing.JTextField pizzaIDField;
    private javax.swing.JLabel pizzaIDLabel;
    private javax.swing.JTextField pizzaNameField;
    private javax.swing.JLabel pizzaNameLabel;
    private javax.swing.JPanel pizzaPanel;
    private javax.swing.JTextField pizzaPriceField;
    private javax.swing.JLabel pizzaPriceLabel;
    private javax.swing.JButton pizzaShow;
    private javax.swing.JTextField pizzaSizeField;
    private javax.swing.JLabel pizzaSizeLabel;
    private javax.swing.JTable pizzaTable;
    private javax.swing.JButton pizzaToppingButton;
    private javax.swing.JTextField pizzaToppingCheeseTypeField;
    private javax.swing.JLabel pizzaToppingCheeseTypeLabel;
    private javax.swing.JTextField pizzaToppingExtraField;
    private javax.swing.JLabel pizzaToppingExtraLabel;
    private javax.swing.JTextField pizzaToppingIDField;
    private javax.swing.JLabel pizzaToppingIDLabel;
    private javax.swing.JTextField pizzaToppingMeatTypeField;
    private javax.swing.JLabel pizzaToppingMeatTypeLabel;
    private javax.swing.JPanel pizzaToppingPanel;
    private javax.swing.JButton pizzaToppingShow;
    private javax.swing.JTable pizzaToppingTable;
    private javax.swing.JButton sauceButton;
    private javax.swing.JTextField sauceIDField;
    private javax.swing.JLabel sauceIDLabel;
    private javax.swing.JTextField sauceNameField;
    private javax.swing.JLabel sauceNameLabel;
    private javax.swing.JPanel saucePanel;
    private javax.swing.JTextField saucePriceField;
    private javax.swing.JLabel saucePriceLabel;
    private javax.swing.JTextField sauceQuantityField;
    private javax.swing.JLabel sauceQuantityLabel;
    private javax.swing.JButton sauceShow;
    private javax.swing.JTable sauceTable;
    private javax.swing.JPanel showPanel;
    private javax.swing.JButton updateBurgerButton;
    private javax.swing.JButton updateDrinkButton;
    private javax.swing.JButton updatePizzaButton;
    private javax.swing.JButton updatePizzaTopping;
    private javax.swing.JButton updateSauceButton;
    // End of variables declaration
}

