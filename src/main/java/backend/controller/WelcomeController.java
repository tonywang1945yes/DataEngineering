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

    @RequestMapping(value = "/signup",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public void userSignUp(@RequestBody SignUpParameter param,
                        HttpServletRequest request, HttpServletResponse response){

        response.setStatus(service.signUp(param));

    }

    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public void userLogin(@RequestBody UserLoginParameter param,
                        HttpServletRequest request, HttpServletResponse response){

        response.setStatus(service.userLogin(param));

    }
    @RequestMapping(value = "/admin",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public void adminLogin(@RequestBody Demo demo,
                           HttpServletRequest request, HttpServletResponse response){
        System.out.println("admin login invoked");
        if(service.adminLogin(demo.getUsername(),demo.getPassword())) {
            response.setStatus(201);
        }else {
            response.setStatus(404);
        }
    }

}
