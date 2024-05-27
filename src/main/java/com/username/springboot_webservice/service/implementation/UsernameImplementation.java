package com.username.springboot_webservice.service.implementation;

import com.username.springboot_webservice.entity.Username;
import com.username.springboot_webservice.repository.UsernameRepository;
import com.username.springboot_webservice.service.UsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* The @Service annotation is used to indicate that a particular class is a service component. The @Service
annotation is a specialization of the @Component annotation is typically used to mark class that contain the
business logic of an application
 */
@Service
public class UsernameImplementation implements UsernameService {


    @Autowired
    private UsernameRepository usernameRepository;


    /*Retrieves all username from the data source using the UsernameRepository*/
    @Override
    public List<Username> findAllUsername() {
        return usernameRepository.findAll();
    }


    /*Retrieves a username from the data source based on the provided username ID used the UsernameRepository*/
    @Override
    public Username findByIdUsername(Long id) {
        Optional<Username> optionalUsername = usernameRepository.findById(id);
        return optionalUsername.get();
    }

    /*Create a new Username by saving it in data source using the UsernameRepository*/
    @Override
    public Username saveUsername(Username username) {
        return usernameRepository.save(username);
    }

    /*Updates an existing Username in the data source using UsernameRepository*/
    @Override
    public Username updateUsername(Username username) {
        Username existingUsername = usernameRepository.findById(username.getId()).get();
        existingUsername.setFirstName(username.getFirstName());
        existingUsername.setLastName(username.getLastName());
        Username usernameUpdated = usernameRepository.save(existingUsername);
        return usernameUpdated;
    }

    /*Deletes an existing username in the data source based on the provided username ID using the UsernameRepository*/
    @Override
    public void deleteByIdUsername(Long id) {
        usernameRepository.deleteById(id);
    }
}
