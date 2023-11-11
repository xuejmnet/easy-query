package com.easy.query.core.basic.extension.listener;

/**
 * create time 2023/11/10 23:04
 * 文件说明
 *
 * @author xuejiaming
 */
public class EmptyJdbcExecutorListener implements JdbcExecutorListener{
    @Override
    public boolean enable() {
        return false;
    }

    @Override
    public void onExecuteBefore(JdbcExecuteBeforeArg arg) {

    }

    @Override
    public void onExecuteAfter(JdbcExecuteAfterArg afterArg) {

    }
}
