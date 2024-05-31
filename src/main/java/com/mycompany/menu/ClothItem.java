/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
ca21064
*/
package com.mycompany.menu;

/**
 *
 * @author MOHAMMAD AFFIQ
 */
public class ClothItem {
    
    private String type;
    private String size;
    

    public ClothItem(String type, String size) {
        this.type = type;
        this.size = size;
    }
    
    public void displayDetails() {
        System.out.println("Type: " + type);
        System.out.println("Size: " + size);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    
}
