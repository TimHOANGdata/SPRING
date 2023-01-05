package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("api")
public class DemoSessionController {
    
    @Autowired
    HttpSession httpSession;

    @PostMapping("session")
    public void writeSession(@RequestBody Personne personnse){
        httpSession.setAttribute("moi", personnse);
    }

    @GetMapping("session")
    public Personne readSession(){
        Personne personne = (Personne) httpSession.getAttribute("moi");
        return personne;
    }
}
