/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unipiloto.ws.testWS.services;

import com.edu.unipiloto.arquitecturas.testWS.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.ToDoubleFunction;
import java.util.stream.DoubleStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Sebastian Varela, Julian Baquero
 */
@Path("/service")
public class service {

    private static Map<Integer, Person> people = new HashMap<>();

    static {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullname("Persona numero " + id);
            person.setAge(new Random().nextInt(40 + id));
            person.setSalary(person.getAge() * 1000 / 3); // Formula para calcular el salario
            people.put(id, person);
        }
    }

    public static Map<Integer, Person> getPeople() {
        return people;
    }

    public static void setPeople(Map<Integer, Person> people) {
        service.people = people;
    }
    
    
    //Desarrollo taller en clase  
    // Adicionar una nueva Persona a la lista (JSON)
    @POST
    @Path("/addPerson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Person> addPerson(List<Person> pr) {
        for (Person person : pr) {
            people.put(person.getId(), person);
        }
        return new ArrayList<>(people.values());
    }

    //Metodo que nos muestra la lista de persona, que nos regrese la lista (JSON)
    @GET
    @Path("/getAllPersonsInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsInJson() {
        return new ArrayList<Person>(people.values());
    }

    //Agregar peronas (JSON)
    @POST
    @Path("/addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPersonInJson(Person person) {
        System.out.println(person.getId());
        people.put(new Integer(person.getId()), person);
        return person;
    }
    
    
    // Modificando el codigo ----------------------------------------------------
    
    // Adicionar el atributo salario en la clase Persona calculado con la fórmula
    @Path("/addSalary")
    @PUT
    public void addSalary() {
        for (Person person : people.values()) {
            person.setSalary(person.getAge() * 1000 / 3);
        }
    }

    // Se realiza un  servicio REST que permita conocer el salario promedio (XML)
    @GET
    @Path("/averageSalary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response averageSalary() {
        double totalSalary = 0;
        for (Person person : people.values()) {
            totalSalary += person.getSalary();
        }
        double average = totalSalary/people.size();
        
         String message = "El promedio de los salarios es: " + totalSalary;
        return Response.ok().entity(message).build();   
        
    }
    

    // Se genera un servicio REST para mostrar la suma de los salarios de las personas (JSON)
    @GET
    @Path("/totalSalaries")
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalSalaries() {
        int totalSalary = 0;
        for (Person person : people.values()) {
            totalSalary += person.getSalary();
            
        }
        
        String message = "El salario total es: " + totalSalary;
        return Response.ok().entity(message).build();   
        
    }
    
// Metodo opcional para saber el promedio de los salarios: 
//     @GET
//    @Path("/averageSalary")
//    @Produces(MediaType.APPLICATION_XML)
//    public double averageSalary() {
//        double totalSalary = 0;
//        for (Person person : people.values()) {
//            totalSalary += person.getSalary();
//        }
//        return totalSalary / people.size();
//    }


}
