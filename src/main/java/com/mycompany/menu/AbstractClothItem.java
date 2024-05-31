/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
ca21064
*/
package com.mycompany.menu;

public abstract class AbstractClothItem implements Shoppable {
    private String type;
    private String size;
    private double price;

    public AbstractClothItem(String type, String size, double price) {
        this.type = type;
        this.size = size;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void displayDetails() {
        System.out.println("Type: " + type);
        System.out.println("Size: " + size);
        System.out.println("Price: RM " + price);
    }
}



