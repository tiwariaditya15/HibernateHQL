package com.aditya;
// Generated 29 Jan, 2019 4:42:11 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Employee generated by hbm2java
 */
public class Employee  implements java.io.Serializable {


     private int id;
     private String name;
     private String dept;
     private String designation;
     private Float salary;
     private Date dateofjoin;

    public Employee() {
    }

	
    public Employee(int id) {
        this.id = id;
    }
    public Employee(int id, String name, String dept, String designation, Float salary, Date dateofjoin) {
       this.id = id;
       this.name = name;
       this.dept = dept;
       this.designation = designation;
       this.salary = salary;
       this.dateofjoin = dateofjoin;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDept() {
        return this.dept;
    }
    
    public void setDept(String dept) {
        this.dept = dept;
    }
    public String getDesignation() {
        return this.designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public Float getSalary() {
        return this.salary;
    }
    
    public void setSalary(Float salary) {
        this.salary = salary;
    }
    public Date getDateofjoin() {
        return this.dateofjoin;
    }
    
    public void setDateofjoin(Date dateofjoin) {
        this.dateofjoin = dateofjoin;
    }




}

