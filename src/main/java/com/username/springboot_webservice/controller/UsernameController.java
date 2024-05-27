package com.username.springboot_webservice.controller;

import com.username.springboot_webservice.entity.Username;
import com.username.springboot_webservice.service.UsernameService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*The @RestController annotation is used to indicate that a particular class is a RESTful controller that
* handles incoming HTTP requests and produce HTTP responses in the form of the data objects (JSON, XML, etc)*/
@RestController

/*This line the @AllArgsConstructor provides a Constructor with all arguments*/
@AllArgsConstructor
/* The @RequestMapping annotation it allows you to define the URL pattern, HTTP methods, requests parameters
* headers and other details for mapping incoming requests*/
@RequestMapping("/api/usernames")
public class UsernameController {

    /*The @Autowired annotation is used to automatically inject the dependency of the UsernameService interface
    * into the UsernameController class */
    @Autowired
    private UsernameService usernameService;

    /* The @GetMapping annotation is used to map the HTTP GET request to the findAllUsernames() method */
    @GetMapping
    // http:localhost:8082/api/usernames
    private ResponseEntity<List<Username>> findAllUsernames(){
        List<Username> listUsername = usernameService.findAllUsername();
        return new ResponseEntity<>(listUsername, HttpStatus.OK);
    }

    /* The @GetMapping("{id}") annotation is used to map the HTTP GET requests with a path variable to the
    findByIdUsername() method */
    @GetMapping("{id}")
    // http:localhost:8082/api/usernames/1
    private ResponseEntity<Username> findByIdUsername(@PathVariable("id") Long idUsername){
        Username username = usernameService.findByIdUsername(idUsername);
        return new ResponseEntity<>(username, HttpStatus.OK);
    }

    /* The @PostMapping annotation is used to map the HTTP POST requests to the saveUsername() method */
    @PostMapping
    // http:localhost:8082/api/usernames
    private ResponseEntity<Username> saveUsername(@RequestBody Username username){
        Username createUsername = usernameService.saveUsername(username);
        return new ResponseEntity<>(createUsername, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    // http:localhost:8082/api/usernames/1
    private ResponseEntity<Username> updateUsername(@PathVariable("id") Long idUsername, @RequestBody Username username){
        username.setId(idUsername);
        Username updatedUsername = usernameService.updateUsername(username);
        return new ResponseEntity<>(updatedUsername, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    // http:localhost:8082/api/usernames/1
    private ResponseEntity<String> deleteUsername(@PathVariable Long id){
        usernameService.deleteByIdUsername(id);
        return new ResponseEntity<>("Username was deleted successfully", HttpStatus.OK);
    }


}
