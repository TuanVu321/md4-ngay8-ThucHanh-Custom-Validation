package com.codegym.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class PhoneNumber {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean supports(Class<?> clazz) {
        return PhoneNumber.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors error){
        PhoneNumber phoneNumber = (PhoneNumber) target;
        String number = phoneNumber.getNumber();
        ValidationUtils.rejectIfEmpty(error,"number","number.empty");
        if(number.length()>11||number.length()<10){
            error.rejectValue("number","number.length");
        }
        if(!number.startsWith("0")){
            error.rejectValue("number","number.startsWith");
        }
        if(!number.matches("(^$|[0-9]*$)")){
            error.rejectValue("number","number.matches");
        }
    }
}
