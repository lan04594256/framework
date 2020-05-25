package com.lwl.common.controller.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lwl.common.common.entity.ErrorCode;
import com.lwl.common.common.entity.JsonResult;
import com.lwl.common.common.entity.PageParam;
import com.lwl.common.common.entity.SystemException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.List;

public class AbstractController<S extends IService<T>, T> {
    //如果注解成@Resource 会报错找不到bean
    @Autowired
    protected S baseService;
    private static final String paramAsc = "paramAsc";
    private static final String paramDesc = "paramDesc";
    private static final String Start = "Start";
    private static final String start = "start";
    private static final String End = "End";
    private static final String end = "end";

    public AbstractController() {
    }

    @RequestMapping(
            value = {"/getById/{id}"},
            method = {RequestMethod.GET}
    )
    @ApiOperation(
            value = "获取对象",
            notes = "作者：<a href=mailto:yangyanrui@yidianlife.com>xiaoyang</a>"
    )
    @ApiImplicitParam(
            paramType = "path",
            name = "id",
            value = "对象id",
            required = true,
            dataType = "Long"
    )
    public JsonResult<T> getById(@PathVariable("id") @NotNull Long id) {
        JsonResult<T> result = new JsonResult();
        T obj = this.baseService.getById(id);
        if (obj != null) {
            result.success(obj);
        } else {
            result.error("查询对象不存在！");
        }

        return result;
    }

    @RequestMapping(
            value = {"/insert"},
            method = {RequestMethod.POST}
    )
    @ApiOperation(
            value = "添加",
            notes = "作者：<a href=mailto:yangyanrui@yidianlife.com>xiaoyang</a>"
    )
    public JsonResult<T> insert(@RequestBody @Valid T entity) {
        JsonResult<T> result = new JsonResult();
        if (entity != null) {
            boolean rsg = this.baseService.save(entity);
            if (rsg) {
                result.success("添加成功");
            } else {
                result.error("添加失败！");
            }
        } else {
            result.error("请传入正确参数！");
        }

        return result;
    }

    @RequestMapping(
            value = {"/insertBatch"},
            method = {RequestMethod.POST}
    )
    @ApiOperation(
            value = "批量添加",
            notes = "作者：<a href=mailto:yangyanrui@yidianlife.com>xiaoyang</a>"
    )
    public JsonResult<T> insertBatch(@RequestBody @Valid List<T> entityList) {
        JsonResult<T> result = new JsonResult();
        if (entityList != null) {
            boolean rsg = this.baseService.saveBatch(entityList);
            if (rsg) {
                result.success("添加成功");
            } else {
                result.error("添加失败！");
            }
        } else {
            result.error("请传入正确参数！");
        }

        return result;
    }

    @RequestMapping(
            value = {"/updateById"},
            method = {RequestMethod.POST}
    )
    @ApiOperation(
            value = "根据id修改",
            notes = "作者：<a href=mailto:yangyanrui@yidianlife.com>xiaoyang</a>"
    )
    public JsonResult<T> updateById(@RequestBody @Valid T entity) {
        JsonResult<T> result = new JsonResult();
        if (entity != null) {
            boolean rsg = this.baseService.updateById(entity);
            if (rsg) {
                result.success("修改成功");
            } else {
                result.error("修改失败！");
            }
        } else {
            result.error("请传入正确参数！");
        }

        return result;
    }

    @RequestMapping(
            value = {"/updateBatchById"},
            method = {RequestMethod.POST}
    )
    @ApiOperation(
            value = "批量根据id修改",
            notes = "作者：<a href=mailto:yangyanrui@yidianlife.com>xiaoyang</a>"
    )
    public JsonResult<T> updateBatchById(@RequestBody @Valid List<T> entityList) {
        JsonResult<T> result = new JsonResult();
        if (entityList != null) {
            boolean rsg = this.baseService.updateBatchById(entityList);
            if (rsg) {
                result.success("修改成功");
            } else {
                result.error("修改失败！");
            }
        } else {
            result.error("请传入正确参数！");
        }

        return result;
    }

    @RequestMapping(
            value = {"/getPages"},
            method = {RequestMethod.POST}
    )
    @ApiOperation(
            value = "分页查询",
            notes = "分页查询返回[IPage<T>],作者：<a href=mailto:yangyanrui@yidianlife.com>xiaoyang</a>"
    )
    public JsonResult<IPage<T>> getPages(@RequestBody @Valid PageParam<T> pageParam) {
        JsonResult<IPage<T>> returnPage = new JsonResult();
        Page<T> page = new Page((long) pageParam.getPageNum(), (long) pageParam.getPageSize());
        QueryWrapper<T> queryWrapper = new QueryWrapper();
        this.createWrapper(pageParam.getParam(), queryWrapper);
        IPage<T> pageData = this.baseService.page(page, queryWrapper);
        returnPage.success(pageData);
        return returnPage;
    }

    private void createWrapper(Object obj, QueryWrapper<T> queryWrapper) {
        if (obj != null) {
            Class<? extends Object> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            if (fields != null) {
                Field[] var8 = fields;
                int var7 = fields.length;

                for (int var6 = 0; var6 < var7; ++var6) {
                    Field field = var8[var6];
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }

                    if (!Modifier.isFinal(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        try {
                            Object dstObject = (new PropertyDescriptor(field.getName(), clazz)).getReadMethod().invoke(obj);
                            if (dstObject != null && !"".equals(dstObject)) {
                                boolean flag = field.isAnnotationPresent(TableField.class);
                                if (flag) {
                                    TableField tableField = (TableField) field.getAnnotation(TableField.class);
                                    if (!tableField.exist()) {
                                        String[] strings;
                                        int i;
                                        if ("paramAsc".equals(field.getName()) && dstObject != null && dstObject instanceof String[]) {
                                            strings = (String[]) dstObject;

                                            for (i = 0; i < strings.length; ++i) {
                                                strings[i] = StringUtils.camelToUnderline(strings[i]);
                                            }

                                            queryWrapper.orderByAsc(strings);
                                        }

                                        if ("paramDesc".equals(field.getName()) && dstObject != null && dstObject instanceof String[]) {
                                            strings = (String[]) dstObject;

                                            for (i = 0; i < strings.length; ++i) {
                                                strings[i] = StringUtils.camelToUnderline(strings[i]);
                                            }

                                            queryWrapper.orderByDesc(strings);
                                        }

                                        if (dstObject instanceof Date) {
                                            if (field.getName().contains("Start")) {
                                                queryWrapper.ge(StringUtils.camelToUnderline(field.getName().replace("Start", "")), (Date) dstObject);
                                            }

                                            if (field.getName().contains("End")) {
                                                queryWrapper.le(StringUtils.camelToUnderline(field.getName().replace("End", "")), (Date) dstObject);
                                            }
                                        }
                                        continue;
                                    }
                                }

                                if (dstObject instanceof Date) {
                                    if (!field.getName().contains("start") && !field.getName().contains("Start")) {
                                        if ((field.getName().contains("end") || field.getName().contains("End")) && dstObject != null && !"".equals(dstObject)) {
                                            queryWrapper.le(StringUtils.camelToUnderline(field.getName()), (Date) dstObject);
                                        }
                                    } else if (dstObject != null && !"".equals(dstObject)) {
                                        queryWrapper.ge(StringUtils.camelToUnderline(field.getName()), (Date) dstObject);
                                    }
                                } else {
                                    queryWrapper.eq(StringUtils.camelToUnderline(field.getName()), dstObject);
                                }
                            }
                        } catch (IntrospectionException var14) {
                            throw new SystemException(ErrorCode.SYS_EXCEPTION.getCode(), "通用接口，条件构造封装报错！", var14);
                        } catch (IllegalAccessException var15) {
                            throw new SystemException(ErrorCode.SYS_EXCEPTION.getCode(), "通用接口，条件构造封装报错！", var15);
                        } catch (InvocationTargetException var16) {
                            throw new SystemException(ErrorCode.SYS_EXCEPTION.getCode(), "通用接口，条件构造封装报错！", var16);
                        }
                    }
                }
            }

        }
    }
}
