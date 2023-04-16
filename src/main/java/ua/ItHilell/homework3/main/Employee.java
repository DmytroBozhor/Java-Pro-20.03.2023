package ua.ItHilell.homework3.main;

public class Employee {

    final private String fullName;
    final private String position;
    final private String email;
    final private String phoneNumber; // Номер будет в формате "45-45-45", то есть с использование тире. Поэтому формат - String
    final private int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }
}
