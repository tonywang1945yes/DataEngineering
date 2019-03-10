package backend.controller;


import backend.entity.Demo;
import backend.parameter.message.CorporationAddParameter;
import backend.parameter.message.CustomAddParameter;
import backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping(value = "/message")
public class MessageController {
    @Autowired
    MessageService service;

    public MessageController() {
    }

    @RequestMapping(value = "/corporation",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public void addBill(@RequestBody CorporationAddParameter param,
                        HttpServletRequest request, HttpServletResponse response) {
        service.addCorporation(param);
        response.setStatus(201);
    }

    @RequestMapping(value = "/custom",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public void addBill(@RequestBody CustomAddParameter param,
                        HttpServletRequest request, HttpServletResponse response) {
        service.addCustom(param);
        response.setStatus(201);
    }

    @RequestMapping(value = "/read/{id}",
            method = RequestMethod.PUT,
            produces = {"application/json", "application/xml"})
    public void updateStatus(@PathVariable("id") String id,
                           HttpServletRequest request, HttpServletResponse response) {
        service.markRead(id);
        response.setStatus(201);
    }

    @RequestMapping(value = "/importance/{id}",
            method = RequestMethod.PUT,
            produces = {"application/json", "application/xml"})
    public void updateImportance(@PathVariable("id") String id,
                           HttpServletRequest request, HttpServletResponse response) {
        service.markImportance(id);
        response.setStatus(201);
    }

}
