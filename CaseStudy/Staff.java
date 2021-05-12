package CaseStudy;

import java.io.Serializable;

public class Staff implements Serializable {
    private String name;
    private int age;
    private String hometown;
    private String position;
    private int salary;
    private int overtime;
    private String MSV;

    public Staff() {
    }

    public Staff(String name, int age, String hometown, String position, int salary, int overtime, int index) {
        this.name = name;
        this.age = age;
        this.hometown = hometown;
        this.position = position;
        this.salary = salary;
        this.overtime = overtime;
        String a = getString(name, position, index);
        this.MSV = a.replaceAll(" ", "_");
    }

    public String getString(String name, String position, int index) {
        int id = (int) Math.floor(Math.random()*10000)+9999;
        String a = name + " " + position + " " + index+" "+id;
        this.MSV = a.replaceAll(" ", "_");
        return a;
    }

    @Override
    public String toString() {
        return "Staff : " +
                " name = " + name +
                ", age = " + age +
                ", hometown = " + hometown +
                ", position = " + position +
                ", salary = " + salary +
                ", overtime = " + overtime +
                ", MSV = " + MSV;
    }

    public String getMSV() {
        return MSV;
    }

    public void setMSV(String MSV) {
        this.MSV = MSV;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

}
