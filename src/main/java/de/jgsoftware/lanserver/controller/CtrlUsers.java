package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.dto.dtoUsers;
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

import de.jgsoftware.lanserver.controller.interfaces.i_CtrUsers;

/**
 *
 * @author hoscho
 */

@RestController
public class CtrlUsers implements i_CtrUsers
{


    @Autowired
    iUserService userService;



    @Override
    public Principal user(Principal user)
    {
        return user;
    }


    @Override
    public ResponseEntity<String> getUserById(String token)
    {

        token.getBytes(StandardCharsets.UTF_8);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Users> loginclientuser(String username, String password)
    {


        String user = username.toString();
        String pass = password.toString();


        return new ResponseEntity<Users>(HttpStatus.OK);
    }


    @Override
    public String getTestLogin()
    {

        return "ok test string";
    }

    @Override
    public ResponseEntity<Users> createUser(@RequestBody Users users)
    {

        userService.getDuser().createnewuser(users);
        return new ResponseEntity<Users>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Users> deleteuser(@RequestBody Users users)
    {


        Integer id = Integer.parseInt(String.valueOf(users.getId()));
        userService.getDuser().deleteusers(id);
        return new ResponseEntity<Users>(users, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<List<Yourcompanydata>> getCompanydata()
    {

        List yourcompanydata = userService.getDuser().getYourCompanydata();

        return new ResponseEntity<List<Yourcompanydata>>(yourcompanydata, HttpStatus.OK);
    }


    // returns all users from database
    @Override
    public ResponseEntity<List<Users>> getAllUserData()
    {

        List youruserdata = userService.getDuser().getAllUsers();

        return new ResponseEntity<List<Users>>(youruserdata, HttpStatus.OK);
    }


    /*
            edit company data
     */
    @Override
    public Yourcompanydata editcompydata(@RequestBody Yourcompanydata ycomdata)
    {
         return userService.getDuser().edityourcompanydata(ycomdata);
    }
}
