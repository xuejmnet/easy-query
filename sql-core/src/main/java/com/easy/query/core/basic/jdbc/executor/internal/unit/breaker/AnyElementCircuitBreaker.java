package com.easy.query.core.basic.jdbc.executor.internal.unit.breaker;

import com.easy.query.core.basic.jdbc.executor.internal.result.QueryExecuteResult;
import com.easy.query.core.sharding.context.StreamMergeContext;

import java.util.Collection;

/**
 * create time 2023/5/8 22:58
 * 文件说明
 *
 * @author xuejiaming
 */
public final class AnyElementCircuitBreaker extends AbstractCircuitBreaker{

    public static final CircuitBreaker INSTANCE=new AnyElementCircuitBreaker();
    @Override
    protected <TResult> boolean SequenceTerminated(StreamMergeContext streamMergeContext,Collection<TResult> results) {
        for (TResult result : results) {
            if(result instanceof QueryExecuteResult){
                if(((QueryExecuteResult)result).getStreamResultSet().hasElement()){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected <TResult> boolean RandomTerminated(StreamMergeContext streamMergeContext,Collection<TResult> results) {
        return false;
    }
}
