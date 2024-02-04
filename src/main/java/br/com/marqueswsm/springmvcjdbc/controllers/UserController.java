package br.com.marqueswsm.springmvcjdbc.controllers;

import br.com.marqueswsm.springmvcjdbc.domain.User;
import br.com.marqueswsm.springmvcjdbc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{username}")
    public User getUser(@PathVariable String username) {
        return userService.getUser(username);
    }

    @GetMapping("internal/{username}")
    public User getUserInternal(@PathVariable String username) {
        return userService.getUserInternal(username);
    }
}
