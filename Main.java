import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int select;


        String[][] Items = {
            {"ID","Item","Price"},
            // {"1","Burger","P120.00"},
            // {"2","Cheese Burger","P145.00"},
            {// KINDLY INSERT YOUR RESTAURANT ITEMS HERE WITH THE PRICES 
                }
        };

        String[] real = {
        // INSERT YOUR ITEMS HERE
        };

        double[] hi = {
        // INSERT YOUR PRICES HERE
        };

        int[] quan = new int[20];
        double tosal = 0;
        double tocount = 0;
        double toin = 0;

        do {
            System.out.println("===========================================================");
            System.out.println("KRISPY BERNIE RESTAURANT");
            System.out.println("===========================================================");
            System.out.println(" ");
            System.out.println("[1] Create New Order\n[2] View Restaurant Menu\n[3] View Sales Summary\n[4] Exit");
            System.out.print("\nEnter your Choice: ");
            select = scan.nextInt();

            switch (select) {
                case 1:
                    String choices = "Y";
                    double total = 0;
                    double service = 0;
                    int choice = 0;





                    while (choice < 3) {
                        System.out.print("Enter Item Number: ");
                        int ItemNum = scan.nextInt();

                        if (ItemNum < 1 || ItemNum > 8) {
                            System.out.println("Invalid Item, Please try again.");
                            continue;
                        }

                        int idx = ItemNum - 1;
                        System.out.println("Selected: " + real[idx]);

                        System.out.print("Enter Quantity: ");
                        int quantity = scan.nextInt();
                        System.out.println(quantity + "x " + real[idx] + " added to order.");

                        quan[idx] += quantity;
                        total += hi[idx] * quantity;

                        System.out.print("\n[1] Add another item\n[2] Proceed to check out\n[3] Cancel order\nEnter your choice: ");
                        choice = scan.nextInt();

                        if (choice == 2 || choice == 3 ) {
                            break;
                        } else if (choice != 1) {
                            System.out.println("Invalid Choice, Order cancelled.");
                            choice = 3;
                            break;
                        }
                    }

                    if (choice == 3) {
                        System.out.println("Cancelling order");
                        break;
                    }



                    System.out.print("[1] Dine in\n[2] Take out\nChoose your option: ");
                    choice = scan.nextInt();


                    if (choice == 1) {
                        service = total * .05;
                    }
                    else {
                        service = 0;
                    }


                    double sertal = total + service;


                    System.out.println("==========================RECEIPT==========================");
                    for (int i = 0; i < 8; i++) {
                        if (quan[i] > 0) {
                            System.out.println(quan[i] + "x " + real[i] + " " + hi[i] * quan[i]);
                        }
                    }


                    System.out.println("SUBTOTAL: " + total);
                    System.out.println("SERVICE CHARGE: " + service);
                    System.out.println("DISCOUNT: 0.00");
                    System.out.println("TOTAL:" + sertal);


                    double PWD = total * .2;
                    double ttotal = sertal - PWD;


                    System.out.print("Are you a PWD or a Senior Citizen? (Y/N): ");
                    choices = scan.next();


                    if (choices.equalsIgnoreCase("Y")) {
                        System.out.println("==========================KRISPY BERNIE==========================");

                        for (int i = 0; i < 8; i++) {
                            if (quan[i] > 0) {
                                System.out.println(quan[i] + "x " + real[i] + " " + hi[i] * quan[i]);
                            }
                            System.out.println("*****************************************************************");
                        }
                        System.out.println("SUBTOTAL: " + total);
                        System.out.println("SERVICE CHARGE: " + service);
                        System.out.println("DISCOUNT: " + PWD);
                        System.out.println("TOTAL:" + ttotal);
                        tosal += ttotal;
                        tocount += PWD;
                        toin += service;
                    } else {
                        System.out.println("==========================KRISPY BERNIE==========================");
                        for (int i = 0; i < 8; i++) {
                            if (quan[i] > 0) {
                                System.out.println(quan[i] + "x " + real[i] + " " + hi[i] * quan[i]);
                            }
                        }
                        System.out.println("SUBTOTAL: " + total);
                        System.out.println("SERVICE CHARGE: " + service);
                        System.out.println("DISCOUNT: 0.00");
                        System.out.println("TOTAL:" + sertal);
                        tosal += sertal;
                        toin += service;
                    }

                    System.out.println("Enter ");

                    break;

                case 2:
                    for (String[] row : Items) {
                        for (String itm : row) {
                            System.out.print(itm + "\t");
                        }
                        System.out.println(" ");
                    }
                    break;

                case 3:
                    System.out.println("==========================SALES SUMMARY==========================");
                    for (int i = 0; i < 8; i++) {
                        System.out.println(quan[i] + "x " + real[i]);

                    }

                    int best = 0;
                    for (int i = 0; i < 8; i++) {
                        if (quan[i] > quan[best]) {
                            best = i;
                        }
                    }

                    System.out.println("===============================BEST SELLING ITEM=========================");
                    if (quan[best] == 0 ) {
                        System.out.println("no sold item yet");
                    } else {
                        System.out.println("BEST SELLING ITEM: " + real[best] + " (" + quan[best] + ")");
                    }

                    System.out.println("========================================================================");
                    System.out.println("\n==============================================TOTAL SALES SUMMARY=============================================");
                    System.out.println("TOTAL SALES: " + tosal);
                    System.out.println("TOTAL DISCOUNTED FOR PWD/SENIOR CITIZENS: " + tocount);
                    System.out.println("TOTAL SERVICE CHARGE: " + toin);
                    break;

                case 4:
                    System.out.println("=========================================================================");
                    System.out.println("THANK YOU FOR VISITING BERNIE BERN BERN");
                    System.out.println("=========================================================================");
                    break;
            }
        }
        while (select < 4);



    }
}
