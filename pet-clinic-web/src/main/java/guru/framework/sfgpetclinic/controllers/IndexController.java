package guru.framework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","index","index.html","12345"})
    public String index(){
        return "index";
    }

    @RequestMapping("/oups")
    public String findOwners(){
        return "notimplemented";
    }

}
