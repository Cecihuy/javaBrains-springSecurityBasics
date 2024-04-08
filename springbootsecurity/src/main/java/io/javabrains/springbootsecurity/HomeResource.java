package io.javabrains.springbootsecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(){
        return "<h1>Welcome</h1>";
    }
}
