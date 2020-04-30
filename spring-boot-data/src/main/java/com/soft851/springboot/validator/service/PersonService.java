package com.soft851.springboot.validator.service;

import com.soft851.springboot.validator.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated@Slf4j
public class PersonService {
    public void validatePerson(@Valid Person person){
        log.info("service方法验证");
    }
}
