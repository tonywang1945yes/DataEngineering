package backend.controller;


import backend.entity.Bill;
import backend.entity.Demo;
import backend.parameter.bill.BillAddParameter;
import backend.parameter.bill.BillQueryParameter;
import backend.response.commonResponse.BillQueryResponse;
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
                        HttpServletRequest request, HttpServletResponse response) {
        service.addBill(param);
        response.setStatus(201);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            produces = {"application/json", "application/xml"})
    public void updateDemo(@PathVariable("id") String id,
                           HttpServletRequest request, HttpServletResponse response) {
        service.sendBill(id);
        response.setStatus(201);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    public void deleteDemo(@PathVariable("id") String id, HttpServletRequest request,
                           HttpServletResponse response) {
        service.deleteBill(id);
        response.setStatus(201);
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    public @ResponseBody
    BillQueryResponse getBills(BillQueryParameter param,
                               HttpServletRequest request, HttpServletResponse response) {

        response.setStatus(201);
        return service.searchBills(param);
    }


}
