package com.lwl.common.common.dao.generator;


import com.lwl.common.common.enmu.DateType;

/**
 * @author Administrator
 */
public interface ITypeConvert {
    /**
     * @param var1
     * @param var2
     * @return
     */
    IColumnType processTypeConvert(DateType var1, String var2);
}
