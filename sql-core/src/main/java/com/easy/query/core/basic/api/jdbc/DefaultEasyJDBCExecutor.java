package com.easy.query.core.basic.api.jdbc;

import com.easy.query.core.abstraction.EasyQueryRuntimeContext;
import com.easy.query.core.basic.jdbc.executor.EasyExecutor;
import com.easy.query.core.basic.jdbc.executor.ExecutorContext;
import com.easy.query.core.basic.jdbc.parameter.ConstSQLParameter;
import com.easy.query.core.basic.jdbc.parameter.SQLParameter;
import com.easy.query.core.util.ArrayUtil;

import java.util.List;

/**
 * @FileName: DefaultEasyJDBC.java
 * @Description: 文件说明
 * @Date: 2023/3/12 22:42
 * @Created by xuejiaming
 */
public class DefaultEasyJDBCExecutor implements EasyJDBCExecutor {
    private final EasyQueryRuntimeContext runtimeContext;

    public DefaultEasyJDBCExecutor(EasyQueryRuntimeContext runtimeContext){
        this.runtimeContext = runtimeContext;
    }


    @Override
    public <T> List<T> sqlQuery(String sql, Class<T> clazz, List<Object> parameters) {
        List<SQLParameter> sqlParameters = ArrayUtil.map(parameters, o -> new ConstSQLParameter(null, null, o));
        EasyExecutor easyExecutor = runtimeContext.getEasyExecutor();
        return easyExecutor.query(ExecutorContext.create(runtimeContext), clazz, sql, sqlParameters);
    }

    @Override
    public long sqlExecute(String sql, List<Object> parameters) {
        List<SQLParameter> sqlParameters = ArrayUtil.map(parameters, o -> new ConstSQLParameter(null, null, o));
        EasyExecutor easyExecutor = runtimeContext.getEasyExecutor();
        return easyExecutor.executeRows(ExecutorContext.create(runtimeContext), sql, sqlParameters);
    }
}