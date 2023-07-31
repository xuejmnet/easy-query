package com.easy.query.core.basic.jdbc.executor.internal.enumerable;

import com.easy.query.core.basic.jdbc.executor.ExecutorContext;
import com.easy.query.core.basic.jdbc.executor.ResultMetadata;
import com.easy.query.core.basic.jdbc.executor.internal.merge.result.StreamResultSet;
import com.easy.query.core.basic.jdbc.types.EasyResultSet;
import com.easy.query.core.exception.EasyQueryException;
import com.easy.query.core.util.EasyStringUtil;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.NoSuchElementException;

/**
 * create time 2023/7/31 16:47
 * 文件说明
 *
 * @author xuejiaming
 */
public abstract class AbstractStreamIterator<T> implements StreamIterator<T> {

    protected final ExecutorContext context;
    protected final StreamResultSet streamResultSet;
    protected final ResultMetadata<T> resultMetadata;
    protected final EasyResultSet easyResultSet;
    protected boolean hasNext;
    private boolean isEnd = false;

    public AbstractStreamIterator(ExecutorContext context, StreamResultSet streamResult, ResultMetadata<T> resultMetadata) throws SQLException {
        this.context = context;
        this.streamResultSet = streamResult;
        this.resultMetadata = resultMetadata;
        this.easyResultSet = new EasyResultSet(streamResult);
        init();
    }

    @Override
    public boolean hasNext() {
        if (!hasNext) {
            if (isEnd) {
                return false;
            }
            hasNext = hasNext0();
            isEnd = !hasNext;
        }
        return hasNext;
    }

    private boolean hasNext0() {
        try {
            return easyResultSet.nextAndReset();
        } catch (SQLException e) {
            throw new EasyQueryException(e);
        }
    }

    @Override
    public T next() {
        if (!hasNext) {
            throw new NoSuchElementException();
        }
        try {
            this.hasNext = false;
            return next0();
        } catch (SQLException e) {
            throw new EasyQueryException(e);
        }
    }

    protected void init() throws SQLException {
        this.hasNext = streamResultSet.next();
        if (this.hasNext) {
            init0();
        }
        this.isEnd=!this.hasNext;
    }

    protected abstract void init0() throws SQLException;

    protected abstract T next0() throws SQLException;

    protected String getColName(ResultSetMetaData rsmd, int col) throws SQLException {
        String columnName = rsmd.getColumnLabel(col);
        if (EasyStringUtil.isEmpty(columnName)) {
            columnName = rsmd.getColumnName(col);
        }
        return columnName;
    }
}