package ua.ItHilell.homework3.main;

public class Main {
    public static void main(String[] args) {

        Employee employee = new Employee("Ban Nick Robinson", "manager", "bannick@gmail.com",
                "45-45-45", 42);
        System.out.println(employee.getFullName());
        System.out.println(employee.getPosition());
        System.out.println(employee.getEmail());
        System.out.println(employee.getPhoneNumber());
        System.out.println(employee.getAge());

        Car.start();

    }
}