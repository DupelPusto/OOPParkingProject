package project.utilities;


import project.Admin;
import project.util.InputValidation;

import java.util.Scanner;

import static project.Database.energy;
import static project.Database.water;

public abstract class PublicUtilities {
    String utilType;
    double utilPrice;
    double consumed;
    double consumeLimit;

    public PublicUtilities() {
    }



    protected abstract String computePayment();

    protected abstract String limitRemainingCompute();

    protected abstract String generateConsumptionReport();


    public static void puMenu(){
        Scanner s = new Scanner(System.in);
        int check;

        while (true) {
            System.out.println("\nPublic utilities");
            System.out.println("1. Energy info");
            System.out.println("2. Water info");
            System.out.println("3. Exit to admin menu");

            check = InputValidation.integerValidation(s);


            switch (check){

                case 1:
                    System.out.print("Enter consumed energy: ");
                    energy.setConsumed(InputValidation.doubleValidation(s));
                    System.out.println(energy.limitRemainingCompute());
                    System.out.println(energy.computePayment());
                    System.out.println(energy.generateConsumptionReport());
                    break;
                case 2:
                    System.out.print("Enter consumed water: ");
                    water.setConsumed(InputValidation.doubleValidation(s));
                    System.out.println(water.limitRemainingCompute());
                    System.out.println(water.computePayment());
                    System.out.println(water.generateConsumptionReport());
                    break;
                case 3:
                    Admin.admin();
                    return;
            }

        }
    }


    public void setUtilType(String utilType) { this.utilType = utilType; }

    public void setUtilPrice(double utilPrice) { this.utilPrice = utilPrice; }

    public void setConsumed(double consumed) { this.consumed = consumed; }

    public void setConsumeLimit(double consumeLimit) { this.consumeLimit = consumeLimit; }

    public double getUtilPrice() { return utilPrice; }
}
