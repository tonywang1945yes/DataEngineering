package backend.controller;


import backend.entity.Demo;
import backend.parameter.welcome.SignUpParameter;
import backend.parameter.welcome.UserLoginParameter;
import backend.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping(value = "/welcome")
public class WelcomeController {
    @Autowired
    WelcomeService service;

    public WelcomeController(){}

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public void addDemo(@RequestBody SignUpParameter param,
                        HttpServletRequest request, HttpServletResponse response){
        service.signUp(param);
        response.setStatus(201);

    }

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public void addDemo(@RequestBody UserLoginParameter param,
                        HttpServletRequest request, HttpServletResponse response){

        response.setStatus(service.userLogin(param));

    }

}
