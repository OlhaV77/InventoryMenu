package main.java;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Menu {
    private double[] itemPrices;
    private String[] itemNames;

    Menu() {
        this.itemPrices = new double[100];
        this.itemNames = new String[100];
    }


    public void displayNameAndPrice( int itemCount) {
        for (int i = 0; i < itemCount; i++) {
            System.out.println("Item: " + itemNames[i] + " " + itemPrices[i]);
        }
    }


    public double[] splice( int itemCount) {
        double[] newItemPrices = new double[itemCount];
        for (int i = 0; i < itemCount; i++) {
            newItemPrices[i] = itemPrices[i];
            itemPrices = newItemPrices;
        }
        return itemPrices;
    }

    String[] splices(  int itemCount) {
        String[] newItemNames = new String[itemCount];
        for (int i = 0; i < itemCount; i++) {
            newItemNames[i] = itemNames[i];
            itemNames = newItemNames;
        }
        return itemNames;
    }


    public static void main(String[] args) {
        Menu menu = new Menu();
        Display display = new Display();

        int addAnItem = 1;
        int displayItems = 2;
        int exitApp = 3;


        int itemCount = 0;
        boolean shouldContinue = true;
        while (shouldContinue) {
            int userChoise = display.scanUserInputForFirstMenu();

            if (userChoise == addAnItem) {
                menu.itemNames[itemCount] = display.scanName();
                menu.itemPrices[itemCount] = display.scanPrice();
                itemCount++;
            }
            if (userChoise == displayItems) {
                for (int j = 0; j < itemCount; j++) {
                    System.out.println(menu.itemNames[j] + " - " + menu.itemPrices[j]);
                }
                int userChoiceOfSubMenu = display.scanUserInputForDisplayMenu();
                int DisplayInOriginalOrder = 1;
                int displayByPrice = 2;
                int displayByName = 3;

                if (userChoiceOfSubMenu == DisplayInOriginalOrder) {
                    menu.displayNameAndPrice( itemCount);
                }

                if (userChoiceOfSubMenu == displayByPrice) {
                    double[] splicedItemPrices = menu.splice( itemCount);
                    String[] splicedItemNames = menu.splices( itemCount);

                    SortedMap<Double, String> sm = new TreeMap<>();

                    for (int j = 0; j < splicedItemPrices.length; j++) {
                        for (j = 0; j < splicedItemNames.length; j++) {
                            sm.put(splicedItemPrices[j], (" - ") + splicedItemNames[j]);
                        }
                        for (Map.Entry mapElement : sm.entrySet()) {
                            double key = (double) mapElement.getKey();
                            String value = (String) mapElement.getValue();
                            System.out.println(key + " " + value);
                        }
                    }
                }
                if (userChoiceOfSubMenu == displayByName) {

                }
            }
            if (userChoise == exitApp) {
                shouldContinue = false;
            }
            System.out.println();
        }
    }
}








