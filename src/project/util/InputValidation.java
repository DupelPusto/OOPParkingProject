package project.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidation {

    private static final String PHONE_REGEX = "^\\+?380\\d{9}$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9]+([._-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+([.-]?[a-zA-Z0-9]+)*\\.[a-zA-Z]{2,4}$";

    public static int integerValidation(Scanner s){
        int res;

        while (true) {
            try {
                res = s.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect number format, try again: ");
            }
        }
        return res;
    }

    public static double doubleValidation(Scanner s){
        double res;

        while (true) {
            try {
                res = s.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect number format, try again: ");
            }
        }
        return res;
    }

    public static String phonenumberValidation(Scanner s){
        String res;
        while (true){
            res = s.nextLine();
            if(res.matches(PHONE_REGEX)){
                break;
            } else{
                System.out.println("Incorrect number format, try again");
            }
        }
        return res;
    }

    public static String emailValidation(Scanner s){
        String res;
        while (true){
            res = s.nextLine();
            if(res.matches(EMAIL_REGEX)){
                break;
            } else{
                System.out.println("Incorrect email format, try again");
            }
        }
        return res;
    }

}
