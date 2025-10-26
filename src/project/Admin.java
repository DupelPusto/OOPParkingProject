package project;

import project.staff.Staff;
import project.util.InputValidation;
import project.utilities.PublicUtilities;

import java.util.Scanner;

public class Admin {

    public static void admin(){
        Scanner s = new Scanner(System.in);
        int check;

        while (true) {

            System.out.println("\nAdmin menu\n");
            System.out.println("1. Statistic");
            System.out.println("2. Add staff");
            System.out.println("3. Staff control panel");
            System.out.println("4. Public utilities");
            System.out.println("5. Exit to main menu");

            check = InputValidation.integerValidation(s);

            switch (check) {
                case 1:
                    Database.counter.showStatistic();
                    break;
                case 2:
                    Staff.addStaffMenu();
                    break;
                case 3:
                    Staff.staffControlPanel();
                    return;
                case 4:
                    PublicUtilities.puMenu();
                    break;
                case 5:
                    Main.consoleMenu();
                    return;
            }
        }
    }

    static void adminAuthorization(){
        Scanner s = new Scanner(System.in);
        String login;
        String password;

        System.out.print("Enter login: ");
        login = s.nextLine();
        System.out.print("Enter password: ");
        password = s.nextLine();
        if(login.equals(Database.LOGIN) && password.equals(Database.PASSWORD)){
            admin();
        }else{
            System.out.println("Access denied");
        }

    }
}
