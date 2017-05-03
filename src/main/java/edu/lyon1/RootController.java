package edu.lyon1;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/")
public class RootController {

    @RequestMapping("/")
    public ModelAndView test(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("titre", "IUT");
        mav.addObject("corps", "bonjour");

        mav.setViewName("template");
         List<String> listHeader = Collections.list(request.getHeaderNames());

         mav.addObject("headers",listHeader);


        return mav;
    }

}

