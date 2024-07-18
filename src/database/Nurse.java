package database;

import java.io.Serializable;

public class Nurse extends Person implements Serializable{
    private String StaffID, department, shift;
    private double salary;

    public Nurse() {
    }

    public Nurse(String id, String name, int age, String gender, String address, String phone, String department, String shift, double salary) {
        super(id, name, age, gender, address, phone);
        this.department = department;
        this.shift = shift;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void print() {
        System.out.printf("|%4s  |%10s      |%4s |%9s |%12s  |%10s    |%11s |%6s |%8s |\n" ,super.getId(),super.getName(),super.getAge(),super.getGender(),super.getAddress(),super.getPhone(),department,shift,salary);
    }    
    
    
}


