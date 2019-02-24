package backend.controller;

import backend.entity.DataPackage;
import backend.entity.Demo;
import backend.parameter.data.DataAddParameter;
import backend.parameter.data.DataQueryParameter;
import backend.response.commonResponse.DataQueryResponse;
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


    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    public @ResponseBody
    DataQueryResponse getData(@PathVariable("page") int page,
                              @PathVariable("year") String year,
                              @PathVariable("dataName") String dataName,
                              @PathVariable("publicationDate") String publicationDate,
                              @PathVariable("responseInstitute") String responseInstitute,
                              @PathVariable("responsePerson") String responsePerson,
                              HttpServletRequest request, HttpServletResponse response){
        DataQueryParameter param =new DataQueryParameter(page,year,dataName,publicationDate,responseInstitute,responsePerson);
        DataQueryResponse res=dataService.searchData(param);
        response.setStatus(201);
        return  res;
    }


}
