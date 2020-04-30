package com.soft1851.springboot.mbp.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author: zw_w
 * @Date: 2020/4/16 13:19
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class UserRole {
    private String name;
    private String roleName;
    private String pName;
}
