package edu.lyon1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/")

public class RootController {

    @RequestMapping("/")
    public ModelAndView test(HttpServletRequest request, @RequestHeader HttpHeaders headers){
        ModelAndView mav = new ModelAndView();
        mav.addObject("titre", "IUT");
        mav.addObject("corps", "bonjour");
        mav.addObject("headers_etape2",headers.keySet());

        mav.setViewName("template");
         List<HttpHeader> listHeader = new ArrayList<>();
         HttpHeader toto = new HttpHeader("value","name");
                        mav.addObject("htpheader", toto.getValue());
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            String values = String.join(",", entry.getValue());
            listHeader.add(new HttpHeader(values,entry.getKey()));
        }

        mav.addObject("headers",listHeader);
        return mav;
    }
public class HttpHeader{

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public HttpHeader(String value, String name) {
        this.value = value;
        this.name = name;

    }
}



}

