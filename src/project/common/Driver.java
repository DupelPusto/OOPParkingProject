package project.common;

public class Driver {
    private String phonenumber;
    private String email;
    private String name;
    private String surname;


    public Driver(String name, String surname, String phonenumber, String email){
        setName(name);
        setSurname(surname);
        setPhonenumber(phonenumber);
        setEmail(email);

    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + ", " + getEmail() + ", " + getPhonenumber();
    }


    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


}
