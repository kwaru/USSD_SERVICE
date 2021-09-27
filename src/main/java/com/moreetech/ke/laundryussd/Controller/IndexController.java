package com.moreetech.ke.laundryussd.Controller;

import com.moreetech.ke.laundryussd.Service.UssdRoutingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author momondi  on 9/26/2021
 **/
@RestController
public class IndexController {

@Autowired
private UssdRoutingService ussdRoutingService;

    /**
     * @param text: This shows the user input. It is an empty string in the first notification of a session. After that, it concatenates all the user input within the session with a "*" until the session ends
     * @param sessionId: A unique value generated when the session starts and sent every time a mobile subscriber response has been received.
     * @param serviceCode: This is the USSD code assigned to your application
     * @param phoneNumber: The number of mobile subscribers interacting with your ussd application.
     * @throws IOException
     * @return
     **/
    @PostMapping(path = "laundryservices")
    public String ussdIngress(@RequestParam String sessionId, @RequestParam String serviceCode,
                              @RequestParam String phoneNumber, @RequestParam String text) throws IOException {
        try {
            return ussdRoutingService.menuLevelRouter(sessionId, serviceCode, phoneNumber, text);
        } catch (IOException e) {
            //Gracefully shut down in case of error
            return "END Service is temporarily down";
        }
    }

    @GetMapping("/test/")
    public String testgetservice(@RequestParam("name") String  name){

        return "Hello "+ name+" !!";
    }

}
