package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.model.Users;
import de.jgsoftware.lanserver.model.Yourcompanydata;
import de.jgsoftware.lanserver.service.interfaces.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.List;

@RestController
public class CtrlUsers
{


    @Autowired
    iUserService userService;


    @RequestMapping("/")
    public Principal user(Principal user)
    {
        return user;
    }


    @PostMapping(value = "/user")
    public ResponseEntity<String> getUserById(String token)
    {

        token.getBytes(StandardCharsets.UTF_8);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @PostMapping("/loginclientuser")
    public ResponseEntity<Users> loginclientuser(String username, String password)
    {


        String user = username.toString();
        String pass = password.toString();


        return new ResponseEntity<Users>(HttpStatus.OK);
    }


    @RequestMapping("/getUserData")
    public String getTestLogin()
    {

        return "ok test string";
    }

    @PostMapping(value = "/createnewuser")
    public ResponseEntity<Users> createUser(@RequestBody Users users)
    {
        userService.getDuser().createnewuser(users);
        return new ResponseEntity<Users>(users, HttpStatus.OK);
    }

    @PostMapping(value = "/deleteuser")
    public ResponseEntity<Users> deleteuser(@RequestBody Users users)
    {


        Integer id = Integer.parseInt(String.valueOf(users.getId()));
        userService.getDuser().deleteusers(id);
        return new ResponseEntity<Users>(users, HttpStatus.OK);
    }


    @GetMapping("/getCompanydata")
    public ResponseEntity<List<Yourcompanydata>> getCompanydata()
    {

        List yourcompanydata = userService.getDuser().getYourCompanydata();

        return new ResponseEntity<List<Yourcompanydata>>(yourcompanydata, HttpStatus.OK);
    }


    // returns all users from database
    @GetMapping("/getuserdata")
    public ResponseEntity<List<Users>> getAllUserData()
    {

        List youruserdata = userService.getDuser().getAllUsers();

        return new ResponseEntity<List<Users>>(youruserdata, HttpStatus.OK);
    }


    /*
            edit company data
     */
    @PostMapping(value = "/editcompanydata")
    public Yourcompanydata editcompydata(@RequestBody Yourcompanydata ycomdata)
    {
         return userService.getDuser().edityourcompanydata(ycomdata);
    }
}
