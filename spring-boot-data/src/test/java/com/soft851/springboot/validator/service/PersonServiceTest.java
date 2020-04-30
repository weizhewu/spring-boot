package com.soft851.springboot.validator.service;

import com.soft851.springboot.validator.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import javax.validation.*;
import java.util.Set;

@SpringBootTest
class PersonServiceTest {
    @Resource
    private PersonService personService;

    @Test
    @ExceptionHandler(ConstraintViolationException.class)
    void validatePerson() {
        Person person= new Person();
        person.setId("123");
        person.setName("soft1851");
        person.setAge(18);
        person.setPhone("13111293508");
        person.setEmail("soft1851@qq.com");
        person.setSex("Woman");
        person.setRegion("China");
        person.setPhoneNumber("13111293508");
        personService.validatePerson(person);
    }

    @Test
    void checkManually(){
        //通过Validator工厂类获得的Validator实例，也可以通过注入的方式
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Person person = new Person();
        person.setId("123");
        person.setSex("Man22");
        person.setEmail("abc");
        person.setRegion("China");
        person.setPhoneNumber("13111293508");
        //对参数进行校验，得到一组结果
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        for (ConstraintViolation<Person> constraintViolation :violations){
            System.out.println(constraintViolation.getMessage());
        }

    }
}