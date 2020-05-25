///**
//* @filename:CbUser 2019-12-16 09:12:35
//* @project ydsh-cbs  V1.0
//* Copyright(c) 2020 <a href=mailto:lanwenliang@yidianlife.com>蓝文良</a> Co. Ltd.
//* All right reserved.
//*/
//package com.lwl.common.entity;
//
//import com.alibaba.fastjson.annotation.JSONField;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableId;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.List;
//
///**
//* <p>代码自动生成，请勿修改</p>
//*
//* <p>说明： 卡包用户表实体类</P>
//* @version: V1.0
//* @author: <a href=mailto:lanwenliang@yidianlife.com>蓝文良</a>
//*
//*/
//@Data
//@EqualsAndHashCode(callSuper = false)
//public class CbUser implements Serializable {
//
//private static final long serialVersionUID = 1576458755136L;
//    @TableId(value = "id", type = IdType.AUTO)
//    @ApiModelProperty(name = "id", value = "主键ID")
//    private Long id;
//    @ApiModelProperty(name = "phone", value = "手机号码")
//    private String phone;
//    @ApiModelProperty(name = "verifyCode", value = "验证码")
//    private String verifyCode;
//    @ApiModelProperty(name = "platformId", value = "来源ID")
//    private Long platformId;
//    @ApiModelProperty(name = "platformName", value = "来源名称")
//    private String platformName;
//    @ApiModelProperty(name = "createTime", value = "创建时间")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date createTime;
//    @ApiModelProperty(name = "verifyCodeTime", value = "验证码更新时间")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date verifyCodeTime;
//    @ApiModelProperty(name = "status", value = "用户状态")
//    private Integer status;
//
//    @ApiModelProperty(name = "idBatch", value = "批量主键处理")
//    @JSONField(serialize = false)
//    @TableField(exist = false)
//    private List<Long> idBatch;
//    @ApiModelProperty(name = "createTimeStart", value = "时间条件参数开始--创建时间")
//    @TableField(exist = false)
//    @JSONField(serialize = false, format = "yyyy-MM-dd HH:mm:ss")
//    private Date createTimeStart;
//    @ApiModelProperty(name = "createTimeEnd", value = "时间条件参数结束--创建时间")
//    @TableField(exist = false)
//    @JSONField(serialize = false, format = "yyyy-MM-dd HH:mm:ss")
//    private Date createTimeEnd;
//    @ApiModelProperty(name = "paramAsc", value = "升序参数：id、phone、verifyCode、platformId、platformName、createTime、status、")
//    @JSONField(serialize = false)
//    @TableField(exist = false)
//    private String[] paramAsc;
//    @ApiModelProperty(name = "paramDesc", value = "降序参数：id、phone、verifyCode、platformId、platformName、createTime、status、")
//    @JSONField(serialize = false)
//    @TableField(exist = false)
//    private String[] paramDesc;
//}
