/**
* @filename:HelloWord 2020-05-20 05:40:43
* @project common  V1.0
* Copyright(c) 2020 <a href=mailto:lanwenliang@yidianlife.com>蓝文良</a> Co. Ltd.
* All right reserved.
*/
package com.lwl.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
* <p>代码自动生成，请勿修改</p>
*
* <p>说明： 实体类</P>
* @version: V1.0
* @author: <a href=mailto:lanwenliang@yidianlife.com>蓝文良</a>
*
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class HelloWord implements Serializable {

private static final long serialVersionUID = 1589967643394L;
    @ApiModelProperty(name = "age", value = "")
    private Integer age;
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(name = "id", value = "")
    private Long id;
    @ApiModelProperty(name = "name", value = "")
    private String name;
    @ApiModelProperty(name = "language", value = "")
    private String language;

    @ApiModelProperty(name = "idBatch", value = "批量主键处理")
    @JSONField(serialize = false)
    @TableField(exist = false)
    private List<Long> idBatch;
    @ApiModelProperty(name = "paramAsc", value = "升序参数：age、id、name、language、")
    @JSONField(serialize = false)
    @TableField(exist = false)
    private String[] paramAsc;
    @ApiModelProperty(name = "paramDesc", value = "降序参数：age、id、name、language、")
    @JSONField(serialize = false)
    @TableField(exist = false)
    private String[] paramDesc;
}
