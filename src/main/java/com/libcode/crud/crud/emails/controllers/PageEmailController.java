package com.libcode.crud.crud.emails.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libcode.crud.crud.emails.entities.Email;
import com.libcode.crud.crud.emails.repository.EmailRepository;

@RestController
@RequestMapping("/api")
public class PageEmailController {

    @Autowired
    private EmailRepository emailRepository;

    @GetMapping("/test/{email}")
    public Email comprobarEmail(@PathVariable String email) {
        Random random = new Random();
        Email emailToSave = new Email(email,random.nextBoolean());
        
        //Agregar logica para guardar el objeto emailToSave en la base de datos
        // y al mismo tiempo regresar el objeto guardado
        //Y retornarlo en lugar de new Email();
        

        return emailRepository.save(emailToSave);
    }
    
}
