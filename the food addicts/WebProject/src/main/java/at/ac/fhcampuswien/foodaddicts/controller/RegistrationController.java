package at.ac.fhcampuswien.foodaddicts.controller;

import at.ac.fhcampuswien.foodaddicts.model.RegistrationRequest;
import at.ac.fhcampuswien.foodaddicts.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;


    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request).getId().toString();
    }
}
