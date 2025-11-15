package project.staff;



public class Security extends Staff {

    public Security(String name, String surname, int age, String position, int exp) {
        super(name, surname, age, position, exp);
        setCategory("Secure staff");
    }


    @Override
    public String doResponsibilities() {
        return "From security " + this.name + " " + this.surname + ": I will watch cameras from now";
    }

    @Override
    public String reportStatus() {
        return "From security " + this.name + " " + this.surname + ": I`m going to do a control review";
    }

    @Override
    public String inspectEquipment() {
        return "From security " + this.name + " " + this.surname + ": I have to inspect computers...I hope none of them are broken";
    }
}
