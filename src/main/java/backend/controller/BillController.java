package backend.controller;


import backend.entity.Demo;
import backend.parameter.bill.BillAddParameter;
import backend.service.BillService;
import backend.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping(value = "/bill")
public class BillController {
    @Autowired
    BillService service;

    public BillController() {
    }

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public void addBill(@RequestBody BillAddParameter param,
                        HttpServletRequest request, HttpServletResponse response){
        service.addBill(param);
        response.setStatus(201);
    }


}
