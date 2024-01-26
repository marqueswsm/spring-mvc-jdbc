package br.com.marqueswsm.springmvcjdbc.githubUsers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @GetMapping("/github/user/{username}")
    public String getUser(@RequestParam(name = "username") String username) {
        return username;
    }
}
