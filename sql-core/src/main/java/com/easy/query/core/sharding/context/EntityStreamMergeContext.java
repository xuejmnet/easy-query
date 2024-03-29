package com.easy.query.core.sharding.context;

import com.easy.query.core.basic.jdbc.executor.ExecutorContext;
import com.easy.query.core.expression.executor.parser.ExecutionContext;
import com.easy.query.core.expression.executor.parser.PrepareParseResult;
import com.easy.query.core.util.EasyCollectionUtil;

/**
 * create time 2023/4/27 22:42
 * 文件说明
 *
 * @author xuejiaming
 */
public class EntityStreamMergeContext extends EasyStreamMergeContext{
    private final PrepareParseResult prepareParseResult;
    private final boolean isSharding;

    public EntityStreamMergeContext(ExecutorContext executorContext, ExecutionContext executionContext, PrepareParseResult prepareParseResult) {
        super(executorContext, executionContext);
        this.prepareParseResult = prepareParseResult;
        this.isSharding= prepareParseResult.isSharding();
    }

    @Override
    public boolean isSharding() {
        return isSharding;
    }

    @Override
    public boolean configReplica() {
        return easyQueryOption.getReplicaOption()!=null;
    }
}
