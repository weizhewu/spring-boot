package com.soft851.springboot.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

public class RegionValidator implements ConstraintValidator<Region,String > {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext){
        HashSet<Object> regions = new HashSet<>();
        regions.add("China");
        regions.add("YunCheng");
        regions.add("NanJing");
        return regions.contains(s);
    }
}
