package org.example.entities;

public class Employee {
    private String name;
    private String eMail;
    private Double salary;

    public Employee(){

    }
    public Employee(String name, String eMail, Double salary) {
        this.name = name;
        this.eMail = eMail;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
