package com.springapp.mvc;

//import com.springapp.mvc.ssss.MyWhiteboard;
import org.slf4j.Marker;
import org.slf4j.spi.LocationAwareLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Created by Sergio on 04.05.14.
 */

@Controller
@RequestMapping(value = "/messages")
public class MessagesController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String messages(HttpSession session){
       // MyWhiteboard myWhiteboard = new MyWhiteboard();


        //myWhiteboard.onOpen(session);

        //String ss = session.getAttribute("ss").toString();

        return "messages";
    }
}
