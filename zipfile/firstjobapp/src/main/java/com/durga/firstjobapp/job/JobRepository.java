package com.durga.firstjobapp.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.CrudRepository;
//We are using jpa repository instead of CrudRepository because it provides extra functions or methods than it

@Repository // marks the class as a spring bean. This class handles CRUD operations
public interface JobRepository extends JpaRepository<Job,Long> {
    // @Repository is not necessary to add if we are extending using JpaRepository or CrudRepository as they have inbuilt @NoRepositoryBean
    // But if we are not using JpaRepository or CrudRepository as extends then we have to mark it with @Repository if we want it to interact with database
    // The upper case is used when we create our own DAO(Data Access Objects)
    // Some professional coders still mark it with @Repository to make it more readable and easy to understand
}
// Summary of this interface
/*
*  This tiny interface is our Dta Access Object(DAO) for the Job entity
*  Because it extends JpaRepository<Job, Long> Spring Boot provides all the standard CRUD operations for the Job table.
*  we never write the implementation of this interface like other interfaces
*  Spring boot generates a proxy class behind the scenes that implements this interface
*  This proxy uses Hibernate to talk to the database
* Spring Boot handles the ORM mapping, queries, transactions, and exception translation for you.
*  */