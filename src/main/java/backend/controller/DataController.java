package backend.controller;

import backend.entity.DataPackage;
import backend.entity.Demo;
import backend.parameter.data.DataAddParameter;
import backend.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping(value = "/data")
public class DataController {

    @Autowired
    DataService dataService;

    public DataController() {
    }

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public void addData(@RequestBody DataAddParameter param,
                        HttpServletRequest request, HttpServletResponse response){
        dataService.addData(param);
        response.setStatus(201);
    }
}
