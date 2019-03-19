package backend.controller;


import backend.parameter.message.CorporationAddParameter;
import backend.parameter.message.CustomAddParameter;
import backend.parameter.message.MessageGetParameter;
import backend.parameter.message.MessageUpdateParameter;
import backend.response.commonResponse.CorporationQueryResponse;
import backend.response.commonResponse.CustomQueryResponse;
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
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public void updateImportance(@PathVariable("id") String id, @RequestBody MessageUpdateParameter param,
                                 HttpServletRequest request, HttpServletResponse response) {
        service.markImportance(id, param);
        response.setStatus(201);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    public void deleteMessage(@PathVariable("id") String id, HttpServletRequest request,
                              HttpServletResponse response) {
        service.deleteMsg(id);
        response.setStatus(201);
    }

    @RequestMapping(value = "/corporation",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    public @ResponseBody
    CorporationQueryResponse getCorporation(MessageGetParameter param,
                                            HttpServletRequest request, HttpServletResponse response) {
        CorporationQueryResponse res = service.getCorporationMsg(param);
        response.setStatus(201);
        return res;
    }

    @RequestMapping(value = "/custom",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    public @ResponseBody
    CustomQueryResponse getCustom(MessageGetParameter param,
                                  HttpServletRequest request, HttpServletResponse response) {
        CustomQueryResponse res = service.getCustomMsg(param);
        response.setStatus(201);
        return res;
    }

    @RequestMapping(value = "/total-message",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    public @ResponseBody
    int getCustom(MessageGetParameter param, HttpServletResponse response) {
        int res = service.getCustomMsg(param).getTotal();
        res += service.getCorporationMsg(param).getTotal();
        response.setStatus(201);
        return res;
    }

}
