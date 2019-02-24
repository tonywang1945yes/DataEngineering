package backend.controller;

import backend.parameter.VerifyEmailParameter.SendMailParameter;
import backend.parameter.VerifyEmailParameter.VerifyMailParameter;
import backend.response.VerifyEmailResponse.EmailResponse;
import backend.service.RegMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController()
@RequestMapping("/email")
public class EmailController {


    @Autowired
    RegMailService service;

    @RequestMapping(value="/send-verification-email" ,
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"})
    public void sendMail(@RequestBody SendMailParameter param)throws Exception {
        service.InsertCode(param.getName(),param.getEmailAddress());
    }

    @RequestMapping(value = "/verification",
            method = RequestMethod.GET,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public EmailResponse verifyCode(@RequestBody VerifyMailParameter param,  HttpServletRequest request){
        if(service.checkCode(param.getEmailAddress(),param.getCode())){
            return new EmailResponse(true);
        }
        else {
            return new EmailResponse(false);
        }
    }

}
