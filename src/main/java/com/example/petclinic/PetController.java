
package com.example.petclinic;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PetController {

    @GetMapping("/hello")
    public String hello() {
        return "Welcome to the Pet Clinic!";
    }
}
