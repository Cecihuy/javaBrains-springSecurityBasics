package io.javabrains.springsecurityjpa;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HomeResource {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(){
        return "<h1>Hello all</h1>";
    }
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public String user(){
        return "<h1>Hello user</h1>";
    }
    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public String admin(){
        return "<h1>Hello admin</h1>";
    }
}