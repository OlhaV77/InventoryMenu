package main.java;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Menu {
    int scanUserInputForFirstMenu() {
        System.out.println(1 + ". Add an item");
        System.out.println(2 + ". Display all items");
        System.out.println(3 + ". Quit");
        Scanner scan = new Scanner(System.in);
        System.out.println("Select menu 1, 2 or 3");
        return scan.nextInt();
    }

     String scanName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Name:");
        return scan.next();

    }

    double scanPrice() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Price($):");
        return scan.nextDouble();
    }

     int scanUserInputForDisplayMenu() {
        System.out.println();
        System.out.println("1:" + " Display in original order");
        System.out.println("2:" + " In accending order by price");
        System.out.println("3:" + " In accending by order name");
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.println("Select 1, 2 or 3 ");
        return scan.nextInt();
    }

     void displayNameAndPrice(double[] itemPrices, String[] itemsName, int itemCount) {
        for (int i = 0; i < itemCount; i++) {
            System.out.println("Item: " + itemsName[i] + " " + itemPrices[i]);
        }
    }


     double[] splice(double[] itemPrices, int itemCount) {
        double[] newItemPrices = new double[itemCount];
        for (int i = 0; i < itemCount; i++) {
            newItemPrices[i] = itemPrices[i];
        }
        return newItemPrices;
    }

    String[] splice(String[] itemNames, int itemCount) {
        String[] newItemNames = new String[itemCount];
        for (int i = 0; i < itemCount; i++) {
            newItemNames[i] = itemNames[i];
        }
        return newItemNames;
    }



}





