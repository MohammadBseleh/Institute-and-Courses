package com.WebSer.institute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RestController ;
@RestController
@RequestMapping (value = "/hello")

public class HelloWorldSpringWeb {
    @GetMapping
   public String Hello()
    {
        return "Hello from Mohammad , update";
    }

}
