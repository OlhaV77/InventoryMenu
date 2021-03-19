import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Menu {
    static int scanUserInputForFirstMenu() {
            System.out.println(1 + ". Add an item");
            System.out.println(2 + ". Display all items");
            System.out.println(3 + ". Quit");
            Scanner scan = new Scanner(System.in);
            System.out.println("Select menu 1, 2 or 3");
            return scan.nextInt();
        }

        static String scanName() {
            Scanner scan = new Scanner(System.in);
            System.out.print("Name:");
            return scan.next();

        }

        static double scanPrice() {
            Scanner scan = new Scanner(System.in);
            System.out.print("Price($):");
            return scan.nextDouble();
        }

        static int scanUserInputForDisplayMenu() {
            System.out.println();
            System.out.println("1:" + " Display in original order");
            System.out.println("2:" + " In accending order by price");
            System.out.println("3:" + " In accending by order name");
            System.out.println();
            Scanner scan = new Scanner(System.in);
            System.out.println("Select 1, 2 or 3 ");
            return scan.nextInt();
        }

        static void displayNameAndPrice(double[] itemPrices, String[] itemsName, int itemCount) {
            for (int i = 0; i < itemCount; i++) {
                System.out.println("Item: " + itemsName[i] + " " + itemPrices[i]);
            }
        }


        private static double[] splice(double[] itemPrices, int itemCount) {
            double[] newItemPrices = new double[itemCount];
            for (int i = 0; i < itemCount; i++) {
                newItemPrices[i] = itemPrices[i];
            }
            return newItemPrices;
        }

        private static String[] splice(String[] itemNames, int itemCount) {
            String[] newItemNames = new String[itemCount];
            for (int i = 0; i < itemCount; i++) {
                newItemNames[i] = itemNames[i];
            }
            return newItemNames;
        }




        public static void main(String[] args) {
            int addAnItem = 1;
            int displayItems = 2;
            int exitApp = 3;

            String[] itemNames = new String[100];
            double[] itemPrices = new double[100];
            int itemCount = 0;
            boolean shouldContinue = true;
            while (shouldContinue) {
                int userChoise = scanUserInputForFirstMenu();

                if (userChoise == addAnItem) {
                    itemNames[itemCount] = scanName();
                    itemPrices[itemCount] = scanPrice();
                    itemCount++;
                }
                if (userChoise == displayItems) {
                    for (int j = 0; j < itemCount; j++) {
                        System.out.println(itemNames[j] + " - " + itemPrices[j]);
                    }
                    int userChoiceOfSubMenu = scanUserInputForDisplayMenu();
                    int DisplayInOriginalOrder = 1;
                    int displayByPrice = 2;
                    int displayByName = 3;

                    if (userChoiceOfSubMenu == DisplayInOriginalOrder) {
                        displayNameAndPrice(itemPrices, itemNames, itemCount);
                    }

                    if (userChoiceOfSubMenu == displayByPrice) {
                        double[] splicedItemPrices = splice(itemPrices, itemCount);
                        String[] splicedItemNames = splice(itemNames, itemCount);
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
                        double[] splicedItemPrices = splice(itemPrices, itemCount);
                        String[] splicedItemNames = splice(itemNames, itemCount);
                    }
                }
                if (userChoise == exitApp) {
                    shouldContinue = false;
                }
                System.out.println();
            }
        }
    }



