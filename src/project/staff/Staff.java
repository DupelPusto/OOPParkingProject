package project.staff;

import project.util.InputValidation;

import java.util.InputMismatchException;
import java.util.Scanner;

import static project.Database.SIZE;
import static project.Database.cleaners;
import static project.Database.securitys;
import static project.Admin.admin;

public class Staff {
    protected String name;
    protected String surname;
    protected int age;
    protected String workPosition;
    protected int workExperience;
    protected String category;


    public Staff(String name, String surname, int age, String position, int exp){
        setName(name);
        setSurname(surname);
        setAge(age);
        setWorkPosition(position);
        setWorkExperience(exp);
    }


    public static void addStaffMenu(){
        Scanner s = new Scanner(System.in);
        int check;
        System.out.println("1. Add security");
        System.out.println("2. Add cleaner");

        check = InputValidation.integerValidation(s);

        switch (check){
            case 1:
                addStaff("security");
                break;
            case 2:
                addStaff("cleaner");
                break;
        }

    }

    public static void addStaff(String kind){
        Scanner s = new Scanner(System.in);
        String name;
        String surname;
        int age;
        String pos;
        int exp;

        System.out.printf("Add %s", kind);
        System.out.print("\nEnter name: ");
        name = s.nextLine();
        System.out.print("Enter surname: ");
        surname = s.nextLine();
        while(true){
            try{
                System.out.print("Enter age: ");
                age = s.nextInt();
                s.nextLine();
                System.out.print("Enter position: ");
                pos = s.nextLine();
                System.out.print("Enter work experience: ");
                exp = s.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("Incorrect number format, try again:");
                s.nextInt();
            }
        }

        if(kind.equals("security")){
            Security sec = new Security(name,surname,age,pos,exp);
            Security.addToMasSec(sec);
        }

        if (kind.equals("cleaner")){
            Cleaner cl = new Cleaner(name,surname,age,pos,exp);
            Cleaner.addToMasClean(cl);
        }

    }

    public static void staffControlPanel(){
        Scanner s = new Scanner(System.in);
        int check;

        while (true) {
            System.out.println("Staff control panel\n");
            System.out.println("1. Calculate salary");
            System.out.println("2. Get status");
            System.out.println("3. Make them to do their responsibilities");
            System.out.println("4. Make them to inspect their equipment");
            System.out.println("5. Exit to Admin menu");

            check = InputValidation.integerValidation(s);


            switch (check) {
                case 1:
                    for (int i = 0; i < SIZE; i++) {
                        if(securitys[i] != null){
                            System.out.println(Salary.computeSalary(securitys[i]));
                        }
                        if (cleaners[i] != null){
                            System.out.println(Salary.computeSalary(cleaners[i]));
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < SIZE; i++) {
                        if (cleaners[i] != null) {
                            System.out.println(cleaners[i].reportStatus());
                        }
                    }

                    for (int i = 0; i < SIZE; i++){
                        if (securitys[i] != null) {
                            System.out.println(securitys[i].reportStatus());
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < SIZE; i++) {
                        if (cleaners[i] != null) {
                            System.out.println(cleaners[i].doResponsibilities());
                        }
                    }
                    for (int i = 0; i < SIZE; i++) {
                        if (securitys[i] != null) {
                            System.out.println(securitys[i].doResponsibilities());
                        }
                    }
                    break;

                case 4:
                    for (int i = 0; i < SIZE; i++) {
                        if (cleaners[i] != null) {
                            System.out.println(cleaners[i].inspectEquipment());
                        }
                    }
                    for (int i = 0; i < SIZE; i++){
                        if (securitys[i] != null) {
                            System.out.println(securitys[i].inspectEquipment());
                        }
                    }
                    break;
                case 5:
                    admin();
                    return;
            }
        }
    }

    public String doResponsibilities(){
        return "from Staff";
    }

    public String reportStatus(){
        return "from Staff";
    }

    public String inspectEquipment(){
        return "from Staff";
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public void setSurname(String surname) { this.surname = surname; }

    public void setCategory(String category) { this.category = category; }

    public int getWorkExperience() { return workExperience; }

    public String getName() { return name; }

    public String getSurname() { return surname; }

    public String getWorkPosition() { return workPosition; }
}
