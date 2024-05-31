/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
ca21064
*/
package com.mycompany.menu;

public class Delivery {
    private double standardDeliveryFee = 1.0;
    private double expressDeliveryFee = 5.0;

    public double calculateDeliveryFee(int deliveryChoice) {
        if (deliveryChoice == 1) {
            return standardDeliveryFee;
        } else if (deliveryChoice == 2) {
            return expressDeliveryFee;
        } else {
            System.out.println("Invalid delivery option. Defaulting to Standard Delivery.");
            return standardDeliveryFee;
        }
    }
}



