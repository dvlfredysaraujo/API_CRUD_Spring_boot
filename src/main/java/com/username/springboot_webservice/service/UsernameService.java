package com.username.springboot_webservice.service;

import com.username.springboot_webservice.entity.Username;

import java.util.List;
/* The UsernameService Interface acts as an abstraction for the business logic related to Username Entities*/
public interface UsernameService {


    /*This line declares a method named findAllUsername that return all Username objects of the database*/
    List<Username> findAllUsername();

    /*This line declares a method name findByIdUsername takes a Long as a parameter and returns a Username object*/
    Username findByIdUsername(Long id);

    /*This line declares a method named saveUsername that takes a Username as a parameters and returns a Username
    object. This method permit save or update a Username object in the database  */
    Username saveUsername(Username username);

    /*This line declare a method named updateUsername that takes a Username Object and returns a Username objects,
    it's similar to the method saveUsername. This method permit save or update a Username object in the database*/
    Username updateUsername(Username username);

    /*This line declares a method named deleteByIdUsername that takes Long as a parameter and delete a Username
    object*/
    void deleteByIdUsername(Long id);

}
