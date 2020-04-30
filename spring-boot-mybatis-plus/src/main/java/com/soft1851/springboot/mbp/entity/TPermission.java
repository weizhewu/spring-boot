package com.soft1851.springboot.mbp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wzw
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_permission")
public class TPermission extends Model<TPermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父类id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 权限名称
     */
    @TableField("p_name")
    private String pName;

    /**
     * 类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 地址
     */
    @TableField("path")
    private String path;

    /**
     * 扩展字段1
     */
    @TableField("ex1")
    private String ex1;

    /**
     * 扩展字段2
     */
    @TableField("ex2")
    private Integer ex2;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
