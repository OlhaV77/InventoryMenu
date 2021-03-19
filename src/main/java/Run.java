package main.java;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Run  {
    public static void main(String[] args) {
        Menu menu = new Menu();
        int addAnItem = 1;
        int displayItems = 2;
        int exitApp = 3;

        String[] itemNames = new String[100];
        double[] itemPrices = new double[100];
        int itemCount = 0;
        boolean shouldContinue = true;
        while (shouldContinue) {
            int userChoise = menu.scanUserInputForFirstMenu();

            if (userChoise == addAnItem) {
                itemNames[itemCount] = menu.scanName();
                itemPrices[itemCount] = menu.scanPrice();
                itemCount++;
            }
            if (userChoise == displayItems) {
                for (int j = 0; j < itemCount; j++) {
                    System.out.println(itemNames[j] + " - " + itemPrices[j]);
                }
                int userChoiceOfSubMenu = menu.scanUserInputForDisplayMenu();
                int DisplayInOriginalOrder = 1;
                int displayByPrice = 2;
                int displayByName = 3;

                if (userChoiceOfSubMenu == DisplayInOriginalOrder) {
                    menu.displayNameAndPrice(itemPrices, itemNames, itemCount);
                }

                if (userChoiceOfSubMenu == displayByPrice) {
                    double[] splicedItemPrices = menu.splice(itemPrices, itemCount);
                    String[] splicedItemNames = menu.splice(itemNames, itemCount);
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
