package de.jgsoftware.lanserver.controller.interfaces;


import de.jgsoftware.lanserver.model.Desktoplayout;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/detaillabeldesktopentry")
public interface i_CtrDesktopLabel
{

    @GetMapping("/getloginlabel")
    ResponseEntity<List<Desktoplayout>> getLoginEntry();

    @GetMapping("/getloginlabel/{framename}")
    ResponseEntity<List<Desktoplayout>> getUserById(@PathVariable("framename") String framename);
}
