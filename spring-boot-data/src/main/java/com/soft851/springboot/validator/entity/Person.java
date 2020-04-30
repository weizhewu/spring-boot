package com.soft851.springboot.validator.entity;

import com.soft851.springboot.validator.validator.PhoneNumber;
import com.soft851.springboot.validator.validator.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @NotNull(message = "Id 不能为空")
    private String id;

    @NotNull(message = "name 不能为空")
    private String name;

    @Min(18)
    private Integer age;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")
    private String phone;

    @NotNull(message = "email 不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

    @Pattern(regexp = "((^Man$|^Woman$|^UGM$))",message = "sex 值不在可选范围")
    @NotNull(message = "sex 不能为空")
    private String sex;

    @NotNull(message = "Region 不能为空")
    @Region(message = "Region 值不在可选范围内")
    private String region;

    @NotNull(message = "phoneNumber 不能为空")
    @PhoneNumber(message = "phoneNumber 格式不正确")
    private String phoneNumber;

}
