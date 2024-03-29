package com.easy.query.core.basic.jdbc.executor.internal.unit.breaker;

import com.easy.query.core.sharding.context.StreamMergeContext;
import com.easy.query.core.util.EasyCollectionUtil;

import java.util.Collection;

/**
 * create time 2023/5/8 22:47
 * 文件说明
 *
 * @author xuejiaming
 */
public final class AnyCircuitBreaker extends AbstractCircuitBreaker{

    public static final CircuitBreaker INSTANCE=new AnyCircuitBreaker();

    @Override
    protected <TResult> boolean SequenceTerminated(StreamMergeContext streamMergeContext,Collection<TResult> results) {
        return EasyCollectionUtil.isNotEmpty(results);
    }

    @Override
    protected <TResult> boolean RandomTerminated(StreamMergeContext streamMergeContext,Collection<TResult> results) {
        return EasyCollectionUtil.isNotEmpty(results);
    }
}
