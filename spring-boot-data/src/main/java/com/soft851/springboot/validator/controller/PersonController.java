package com.soft851.springboot.validator.controller;

import com.soft851.springboot.validator.annotation.ControllerWebLog;
import com.soft851.springboot.validator.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api")
@Slf4j
@Validated
public class PersonController {

    @PostMapping("/person")
//    @RequestMapping(value = "person")
    @ControllerWebLog(name = "getHello",isSaved = true)
    public ResponseEntity<Person> savePerson(@RequestBody @Valid Person person, HttpServletRequest request){
        log.info("控制层获得参数："+person);
        log.info("控制层获得参数："+request);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Integer> getPersonById(@Valid @PathVariable("id") @Size(min = 6,message = "id不能小于6位") String id){
        return ResponseEntity.ok().body(Integer.parseInt(id));
    }

    @GetMapping("/person")
    public ResponseEntity<String> getPersonByName(@Valid @RequestParam("name") @Size(max = 10,message = "name长度超出范围") String name){
        return ResponseEntity.ok().body(name);
    }
}
