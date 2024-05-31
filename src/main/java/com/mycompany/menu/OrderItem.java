/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
ca21064
*/
package com.mycompany.menu;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private List<Shoppable> items;
    private double totalItemCost;
    private double deliveryFee;

    public OrderItem() {
        items = new ArrayList<>();
        totalItemCost = 0.0;
        deliveryFee = 0.0;
    }

    public void addItem(Shoppable item, double price, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(item);
        }
        totalItemCost += price * quantity;
    }

    public void setDeliveryFee(double fee) {
        this.deliveryFee = fee;
    }

    public double calculateGrandTotal() {
        return totalItemCost + deliveryFee;
    }

    public void displayOrderDetails() {
        System.out.println("Order Details:");
        for (Shoppable item : items) {
            item.displayDetails();
        }
        System.out.println("Total Item Cost: RM " + totalItemCost);
        System.out.println("Delivery Fee: RM " + deliveryFee);
        System.out.println("Grand Total: RM " + calculateGrandTotal());
    }
}



