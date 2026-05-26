package Entities;

public class Passenger {

    private String idNumber;       // cédula
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    private String passportNumber;
    private String nationality;

    public Passenger(String idNumber, String firstName, String lastName,
                     int age, String email, String phone,
                     String passportNumber, String nationality) {
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "\n--- PASSENGER INFO ---" +
                "\nID Number   : " + idNumber +
                "\nFull Name   : " + firstName + " " + lastName +
                "\nAge         : " + age +
                "\nEmail       : " + email +
                "\nPhone       : " + phone +
                "\nPassport    : " + passportNumber +
                "\nNationality : " + nationality;
    }
}
