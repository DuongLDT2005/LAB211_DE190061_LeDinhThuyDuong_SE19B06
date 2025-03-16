/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week7.view;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Validation;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week7.model.Fruit;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week7.model.FruitList;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week7.model.Order;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week7.model.OrderItem;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week7.model.OrderList;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class FruitListView {

    private FruitList fruitList = new FruitList();
    private OrderList orderList = new OrderList();

    public void addFruit() {
        do {
            int id = fruitList.getFruits().size() + 1;
            System.out.print("Fruit name: ");
            String name = Validation.inputString();
            System.out.print("Price: ");
            double price = Validation.inputPositiveDouble();
            System.out.print("Quantity: ");
            int quantity = Validation.inputPositiveInteger();
            System.out.print("Origin: ");
            String origin = Validation.inputString();
            Fruit fruit = new Fruit(id, quantity, name, origin, price);
            fruitList.addFruit(fruit);
            System.out.println("Create successfully!");
        } while (isContinued("Do you want to continue (Y/N)?"));
        displayFruits();
    }

    private boolean isContinued(String str) {
        System.out.println(str);
        String choice = Validation.inputStringInFormat(new String[]{"Y", "N"});
        return choice.equalsIgnoreCase("Y");
    }

    private void displayFruits() {
        System.out.printf("%-10s %-18s %-18s %-10s %-10s\n", "Item", "Fruit Name", "Origin", "Price", "Quantity");
        for (Fruit f : fruitList.getFruits()) {
            System.out.println(f);
        }
    }

    public void viewOrders() {
        if (orderList.getOrders().isEmpty()) {
            System.out.println("No order to view");
            return;
        }
        for (Order o : orderList.getOrders()) {
            System.out.println("Customer: " + o.getCustomerName());
            displayOrderItem(o.getItems());
            System.out.println("Total: " + o.getTotal() + "$");
            System.out.println();
        }
    }

    private void displayOrderItem(ArrayList<OrderItem> items) {
        System.out.printf("%-15s | %-10s | %-10s | %-10s\n", "Product", "Quantity", "Price", "Amount");
        for (OrderItem item : items) {
            System.out.println(item);
        }
    }

    public void shopping() {
        displayFruits();
        ArrayList<OrderItem> items = new ArrayList<>();
        int id = 1;
        do {
            System.out.print("Select: ");
            int selectedID = Validation.inputIntegerInRange(1, fruitList.getFruits().size());
            Fruit selectedFruit = fruitList.searchSelectedFruit(selectedID);
            if (selectedFruit.getQuantity() == 0) {
                System.out.println("This fruit is sold out!");
                return;
            }
            String name = selectedFruit.getName();
            System.out.println("You selected: " + name);
            System.out.print("Please input quantity: ");
            int quantity = Validation.inputIntegerInRange(0, selectedFruit.getQuantity());
            OrderItem item = new OrderItem(id, quantity, name, selectedFruit.getPrice());
            items.add(item);
            selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);
            id++;
        } while (!isContinued("Do you want to order now (Y/N)?"));
        Order order = new Order(items);
        displayOrderItem(items);
        System.out.println("Total: " + order.getTotal() + "$");
        System.out.print("Input your name: ");
        String customerName = Validation.inputString();
        order.setCustomerName(customerName);
        orderList.addOrder(order);
    }
}
