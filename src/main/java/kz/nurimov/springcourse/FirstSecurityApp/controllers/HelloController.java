package kz.nurimov.springcourse.FirstSecurityApp.controllers;

import kz.nurimov.springcourse.FirstSecurityApp.config.SecurityConfig;
import kz.nurimov.springcourse.FirstSecurityApp.models.Person;
import kz.nurimov.springcourse.FirstSecurityApp.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        System.out.println(personDetails.getPerson());
        return "hello";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}