package de.jgsoftware.lanserver.controller.interfaces;


import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import main.java.de.jgsoftware.lanserver.model.Users;
import main.java.de.jgsoftware.lanserver.model.Yourcompanydata;


/**
 *
 * @author hoscho
 */
public interface i_CtrUsers
{



    @RequestMapping("/")
    Principal user(Principal user);


    @PostMapping(value = "/user")
    ResponseEntity<String> getUserById(String token);


    @PostMapping("/loginclientuser")
    ResponseEntity<Users> loginclientuser(String username, String password);


    @RequestMapping("/getUserData")
    String getTestLogin();


    @PostMapping(value = "/createnewuser")
    ResponseEntity<Users> createUser(@RequestBody Users users);


    @PostMapping(value = "/deleteuser")
    ResponseEntity<Users> deleteuser(@RequestBody Users users);

    @GetMapping("/getCompanydata")
    ResponseEntity<List<Yourcompanydata>> getCompanydata();

    @GetMapping("/getuserdata")
    ResponseEntity<List<Users>> getAllUserData();

    @PostMapping(value = "/editcompanydata")
    Yourcompanydata editcompydata(@RequestBody Yourcompanydata ycomdata);

}
