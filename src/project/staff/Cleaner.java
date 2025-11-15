package project.staff;

public class Cleaner extends Staff {

    public Cleaner(String name, String surname, int age, String position, int exp) {
        super(name, surname, age, position, exp);
        setCategory("Cleaning staff");
    }


    @Override
    public String doResponsibilities() {
        return "From cleaner " + this.name + " " + this.surname + ": I will clean the floor from now";
    }

    @Override
    public String reportStatus() {
        return "From cleaner " + this.name + " " + this.surname + ": I`m going to have a lunch";
    }

    @Override
    public String inspectEquipment() {
        return "From cleaner " + this.name + " " + this.surname + ": I have to inspect my equipment, maybe one of them is broken";
    }
}
