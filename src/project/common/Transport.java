package project.common;


import project.Database;
import project.util.InputValidation;


import java.util.Scanner;

public class Transport {
    private String carModel;
    private String carMark;
    private String carGovnumber;
    private short id = 0;
    private Driver driver;


    public Transport(String mark, String model, String carnumber){
        setCarMark(mark);
        setCarModel(model);
        setCarGovnumber(carnumber);
    }

    public static void addCar(){
        Scanner s = new Scanner(System.in);

        String mark;
        String model;
        String govnumber;

        System.out.println("Car info\n");
        System.out.print("Enter car mark: ");
        mark = s.nextLine();
        System.out.print("Enter car model: ");
        model = s.nextLine();
        System.out.print("Enter car government number: ");
        govnumber = s.nextLine();
        System.out.println();

        Transport transport = new Transport(mark, model, govnumber);

        String d_name;
        String d_surname;
        String d_email;
        String d_phonenumber;

        System.out.println("Driver info\n");
        System.out.print("Enter driver`s name: ");
        d_name = s.nextLine();
        System.out.print("Enter driver`s surname: ");
        d_surname = s.nextLine();
        System.out.print("Enter driver`s email: ");
        d_email = InputValidation.emailValidation(s);
        System.out.print("Enter driver`s phonenumber(+380...): ");

        d_phonenumber = InputValidation.phonenumberValidation(s);

        Driver driver = new Driver(d_name, d_surname, d_phonenumber,d_email);
//        driver.setTransport(transport);
        transport.setDriver(driver);
        Parking.addToParkPlace(transport);
        Database.counter.add(1);

    }

    public void showTransportInfo(){
        System.out.printf("\nTransport info: \nDriver: %s\nMark: %s\nModel: %s\nGovernment number: %s\nIs located on parking place № %d\n",
                driver.toString(), getCarMark(), getCarModel(),getCarGovnumber(), getId());
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setCarGovnumber(String carGovnumber) {
        this.carGovnumber = carGovnumber;
    }

    public void setId(short id) { this.id = id; }

    public void setCarMark(String carMark) { this.carMark = carMark; }

    public void setDriver(Driver driver) { this.driver = driver; }

    public String getCarGovnumber() {
        return carGovnumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarMark() { return carMark; }

    public short getId() { return id; }

}
