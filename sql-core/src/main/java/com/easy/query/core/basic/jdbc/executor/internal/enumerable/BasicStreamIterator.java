package com.easy.query.core.basic.jdbc.executor.internal.enumerable;

import com.easy.query.core.basic.jdbc.executor.internal.props.BasicJdbcProperty;
import com.easy.query.core.basic.jdbc.executor.internal.props.JdbcProperty;
import com.easy.query.core.basic.jdbc.executor.ExecutorContext;
import com.easy.query.core.basic.jdbc.executor.ResultMetadata;
import com.easy.query.core.basic.jdbc.executor.internal.merge.result.StreamResultSet;
import com.easy.query.core.basic.jdbc.types.JdbcTypeHandlerManager;
import com.easy.query.core.basic.jdbc.types.handler.JdbcTypeHandler;
import com.easy.query.core.util.EasyClassUtil;
import com.easy.query.core.util.EasyObjectUtil;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * create time 2023/7/31 17:22
 * 文件说明
 *
 * @author xuejiaming
 */
public class BasicStreamIterator<T> extends AbstractMapToStreamIterator<T>{
    private JdbcProperty dataReader;
    private JdbcTypeHandler handler;
    public BasicStreamIterator(ExecutorContext context, StreamResultSet streamResult, ResultMetadata<T> resultMetadata) throws SQLException {
        super(context, streamResult, resultMetadata);
    }

    @Override
    protected void init0() throws SQLException {
        ResultSetMetaData rsmd = streamResultSet.getMetaData();
        int columnCount = rsmd.getColumnCount();
        if (columnCount != 1) {
            throw new SQLException("result set column count:" + EasyClassUtil.getSimpleName(resultMetadata.getResultClass()) + ",expect one column");
        }
        this.dataReader=new BasicJdbcProperty(0,resultMetadata.getResultClass());
        JdbcTypeHandlerManager easyJdbcTypeHandler = context.getRuntimeContext().getJdbcTypeHandlerManager();
        this.handler = easyJdbcTypeHandler.getHandler(resultMetadata.getResultClass());
    }

    @Override
    protected T mapTo() throws SQLException {
        Object value = handler.getValue(dataReader, streamResultSet);
        return EasyObjectUtil.typeCastNullable(value);
    }

}
