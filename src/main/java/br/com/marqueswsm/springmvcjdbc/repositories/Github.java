package br.com.marqueswsm.springmvcjdbc.repositories;

import br.com.marqueswsm.springmvcjdbc.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "github", url = "https://api.github.com")
public interface Github {
    @GetMapping("users/{username}")
    User getProfile(@RequestParam String username);
}
