/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unipiloto.arquitecturas.testWS;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Sebastian Varela, Julian Baquero
 */

@XmlRootElement(name = "person")
@XmlType(propOrder= {"id","fullname","age","salario"})   
public class Person {
   private int id;
   private String fullname;
   private int age;
   private double salary;
   
   
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @XmlElement
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
   @XmlElement
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
   

    @XmlRootElement
    public static class TotalSalaryResponse {
        private int totalSalary;

        public TotalSalaryResponse() {
        }

        public TotalSalaryResponse(int totalSalary) {
            this.totalSalary = totalSalary;
        }

        public int getTotalSalary() {
            return totalSalary;
        }

        public void setTotalSalary(int totalSalary) {
            this.totalSalary = totalSalary;
        }
    }
   
   

}