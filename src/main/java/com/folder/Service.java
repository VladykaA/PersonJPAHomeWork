package com.folder;

import javax.persistence.*;
import java.util.List;

public class Service {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("person_jpa");;
    private static EntityManager em = emf.createEntityManager();

    public static void add(Person p){
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    public static Person updatePersonByName(String name){

        em.getTransaction().begin();
        TypedQuery<Person> query = em.createQuery("FROM Person m WHERE m.name = :tempName", Person.class);
        query.setParameter("tempName", name);
        Person personResult = query.getSingleResult();

        em.getTransaction().commit();
        em.close();
        emf.close();

        return personResult;
    }

    public static void deletePersonByName(String name){

        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM Person m WHERE m.name = :tempName");
        query.setParameter("tempName", name);

        query.executeUpdate();

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static List<Person> selectPersonByName (String name){
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT m FROM Person m WHERE m.name = :tempName");
        query.setParameter("tempName", name);

        @SuppressWarnings("unchecked")
        List<Person> list = (List<Person>)query.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();

        return list;
    }

    public static List<Person> selectPersonByAge (int age){
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT m FROM Person m WHERE m.age = :tempAge");
        query.setParameter("tempAge", age);

        @SuppressWarnings("unchecked")
        List<Person> list = (List<Person>)query.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();

        return list;
    }

    public static List<Person> selectPersonByAddress (Address address){
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT m FROM Person m WHERE m.address = :tempAddress");
        query.setParameter("tempAddress", address);

        @SuppressWarnings("unchecked")
        List<Person> list = (List<Person>)query.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();

        return list;
    }
}
