package com.sourabh.Restful_web_services.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {


    UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<user> retriveAll(){
        return userDaoService.getUsers();
    }

    @GetMapping("/users/{id}")
    public user getUserById(@PathVariable Integer id){
        user user=userDaoService.getUserById(id);
        if(user==null)
            throw new userNotFoundException("id: "+id);

     return userDaoService.getUserById(id);
    }
    @DeleteMapping("/users/{id}")
    public user DeleteUserById(@PathVariable Integer id){
        user user=userDaoService.getUserById(id);
        if(user==null)
            throw new userNotFoundException("id: "+id);
        else
            userDaoService.DeleteUserById(id);

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> CreateUser(@Valid @RequestBody  user user){

        user savedUser= userDaoService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
         return ResponseEntity.created(location).build();
    }
}
