package org.example.proyecto_api.demo;

import lombok.RequiredArgsConstructor;
import org.example.proyecto_api.user.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {

    @PostMapping(value = "demo")
    public String welcome(@AuthenticationPrincipal User user) {
        return "Welcome to Proyecto";
    }

}
