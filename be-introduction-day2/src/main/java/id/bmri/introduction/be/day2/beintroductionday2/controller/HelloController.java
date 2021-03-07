package id.bmri.introduction.be.day2.beintroductionday2.controller;

import id.bmri.introduction.be.day2.beintroductionday2.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/hello")
@RestController
public class HelloController {

    @GetMapping("v1/gereeting")
    public String greeting(){
        return "Hello Word";
    }

    @GetMapping("v1/gereeting/{name}")
    public String greetingWithName(@PathVariable String name, @RequestParam String age){

        return "Hello " + name +" your age is " + age;
    }

    @PostMapping("v1/greeting/save-name")
    public String greetingPost(@RequestBody String name){
    return "Hello " + name;
    }

    @PostMapping("v1/greeting/save-object")
    public String greetingWithObject(@RequestBody Person person){
        return "Hello " + person.getName() +" your age is " + person.getAge();
    }

    @PostMapping("v1/greeting/respon-entity")
    public ResponseEntity greetingWithResponseEntity(@RequestBody Person person){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
