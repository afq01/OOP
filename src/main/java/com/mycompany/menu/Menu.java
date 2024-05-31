/*
ca21064
*/

package com.mycompany.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static List<OrderItem> orders = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Are you an admin or a buyer?");
            System.out.println("1. Admin");
            System.out.println("2. Buyer");
            int userType = scanner.nextInt();

            if (userType == 1) {
                handleAdmin(scanner);
            } else if (userType == 2) {
                handleBuyer(scanner);
            } else {
                System.out.println("Invalid choice.");
            }
        } 
    }

    private static void handleAdmin(Scanner scanner) {
        System.out.println("Admin Panel");
        System.out.println("1. View all user grand totals");
        System.out.println("2. View all orders");
        System.out.println("3. Exit");
        int adminChoice = scanner.nextInt();

        if (adminChoice == 1) {
            viewAllUserGrandTotals();
        } else if (adminChoice == 2) {
            viewAllOrders();
        } else if (adminChoice == 3) {
            System.out.println("Exiting Admin Panel.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void handleBuyer(Scanner scanner) {
        System.out.println("Buyer Panel");
        System.out.println("Enter the number to the online shopping you want to open:");
        System.out.println("1. Cloth Shopping Online");
        System.out.println("2. Furniture Shopping Online");
        System.out.println("3. Electronic Shopping Online");
        System.out.println("4. Medical Shopping Online");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("Opening Cloth Shopping Online...");
                OrderItem orderItem = new OrderItem();
                while (true) {
                    System.out.println("Select Item Type:");
                    System.out.println("1. T-shirt");
                    System.out.println("2. Pant");
                    System.out.println("3. Checkout");
                    int itemType = scanner.nextInt();

                    if (itemType == 1) {
                        handleTshirtSelection(scanner, orderItem);
                    } else if (itemType == 2) {
                        handlePantSelection(scanner, orderItem);
                    } else if (itemType == 3) {
                        break;
                    } else {
                        System.out.println("Invalid choice.");
                    }
                }

                handleDeliverySelection(scanner, orderItem);
                orderItem.displayOrderDetails();
                orders.add(orderItem);
                System.out.println("Order added successfully. Total orders: " + orders.size()); // Confirmation print statement
            }
            case 2 -> System.out.println("Opening Furniture Shopping Online...");
            // Add code to open furniture system
            case 3 -> System.out.println("Opening Electronic Shopping Online...");
            // Add code to open electronic system
            case 4 -> System.out.println("Opening Medical Shopping Online...");
            // Add code to open medical system
            default -> System.out.println("Invalid choice. Please enter a number between 1 and 4.");
        }
    }

    private static void handleTshirtSelection(Scanner scanner, OrderItem orderItem) {
        System.out.println("Select Tshirt Type:");
        System.out.println("1. Baggy Tshirt");
        System.out.println("2. Hoodie");
        System.out.println("3. V-neck Shirt");
        int tshirtChoice = scanner.nextInt();
        String tshirtType = "";
        double tshirtPrice = 0;

        switch (tshirtChoice) {
            case 1 -> {
                tshirtType = "Baggy Tshirt";
                tshirtPrice = 80.0;
            }
            case 2 -> {
                tshirtType = "Hoodie";
                tshirtPrice = 60.0;
            }
            case 3 -> {
                tshirtType = "V-neck Shirt";
                tshirtPrice = 25.0;
            }
            default -> {
                System.out.println("Invalid choice for Tshirt type.");
                return;
            }
        }

        String size = getSizeFromUser(scanner);
        if (size.isEmpty()) return;

        System.out.println("Enter quantity:");
        int quantity = scanner.nextInt();

        Tshirt tshirt = new Tshirt(tshirtType, size, tshirtPrice);
        orderItem.addItem(tshirt, tshirtPrice, quantity);
    }

    private static void handlePantSelection(Scanner scanner, OrderItem orderItem) {
        System.out.println("Select Pant Type:");
        System.out.println("1. Cargo");
        System.out.println("2. Jean");
        System.out.println("3. Slack");
        int pantChoice = scanner.nextInt();
        String pantType = "";
        double pantPrice = 0;

        switch (pantChoice) {
            case 1 -> {
                pantType = "Cargo";
                pantPrice = 40.0;
            }
            case 2 -> {
                pantType = "Jean";
                pantPrice = 30.0;
            }
            case 3 -> {
                pantType = "Slack";
                pantPrice = 20.0;
            }
            default -> {
                System.out.println("Invalid choice for pant type.");
                return;
            }
        }

        String size = getSizeFromUser(scanner);
        if (size.isEmpty()) return;

        System.out.println("Enter quantity:");
        int quantity = scanner.nextInt();

        Pant pant = new Pant(pantType, size, pantPrice);
        orderItem.addItem(pant, pantPrice, quantity);
    }

    private static String getSizeFromUser(Scanner scanner) {
        System.out.println("Select Size:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        int sizeChoice = scanner.nextInt();
        String size = "";

        switch (sizeChoice) {
            case 1 -> size = "Small";
            case 2 -> size = "Medium";
            case 3 -> size = "Large";
            default -> {
                System.out.println("Invalid choice for size.");
                return "";
            }
        }
        return size;
    }

    private static void handleDeliverySelection(Scanner scanner, OrderItem orderItem) {
        System.out.println("\nChoose delivery option:");
        System.out.println("1. Standard Delivery (RM 1)");
        System.out.println("2. Express Delivery (RM 5)");
        int deliveryChoice = scanner.nextInt();
        Delivery delivery = new Delivery();
        double deliveryPrice = delivery.calculateDeliveryFee(deliveryChoice);
        orderItem.setDeliveryFee(deliveryPrice);
    }

    private static void viewAllUserGrandTotals() {
        double grandTotal = 0.0;
        for (OrderItem order : orders) {
            grandTotal += order.calculateGrandTotal();
        }
        System.out.println("Total of all user grand totals: RM " + grandTotal);
    }

    private static void viewAllOrders() {
        System.out.println("All Orders:");
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
        } else {
            for (OrderItem order : orders) {
                order.displayOrderDetails();
                System.out.println("-------------------");
            }
        }
    }
}





