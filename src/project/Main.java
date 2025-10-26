package project;

import project.common.Parking;
import project.common.Transport;
import project.util.InputValidation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Parking.initParkplaces();
        consoleMenu();
    }

    static void consoleMenu(){
        Scanner s = new Scanner(System.in);
        while (true){

            int check;
            System.out.println("Main Menu\n");
            System.out.println("1. Add car to parking place");
            System.out.println("2. Show taken places");
            System.out.println("3. For admin");
            System.out.println("4. Exit");
            System.out.print("To select action, enter its number: ");

            check = InputValidation.integerValidation(s);

            switch (check){

                case 1:
                    Transport.addCar();
                    break;
                case 2:
                    Parking.showOccupied();
                    break;
                case 3:
                    Admin.adminAuthorization();
                    break;
                case 4:
                    System.out.println("Exit...");
                    System.exit(0);

            }

        }
    }

}
