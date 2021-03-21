package main.java;

import java.util.Scanner;

public class Display {

    public int scanUserInputForFirstMenu() {
        System.out.println(1 + ". Add an item");
        System.out.println(2 + ". Display all items");
        System.out.println(3 + ". Quit");
        Scanner scan = new Scanner(System.in);
        System.out.println("Select menu 1, 2 or 3");
        return scan.nextInt();
    }

   public String scanName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Name:");
        return scan.next();

    }

    public double scanPrice() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Price($):");
        return scan.nextDouble();
    }

    public   int scanUserInputForDisplayMenu() {
        System.out.println();
        System.out.println("1:" + " Display in original order");
        System.out.println("2:" + " In accending order by price");
        System.out.println("3:" + " In accending by order name");
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.println("Select 1, 2 or 3 ");
        return scan.nextInt();
    }



}
