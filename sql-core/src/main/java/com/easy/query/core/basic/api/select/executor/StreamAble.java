package com.easy.query.core.basic.api.select.executor;

import com.easy.query.core.basic.api.select.QueryAvailable;
import com.easy.query.core.basic.jdbc.executor.internal.enumerable.JdbcStreamResult;
import com.easy.query.core.basic.jdbc.executor.internal.enumerable.StreamIterable;
import com.easy.query.core.exception.EasyQuerySQLCommandException;
import com.easy.query.core.expression.lambda.SQLConsumer;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * create time 2023/10/20 23:07
 * 文件说明
 *
 * @author xuejiaming
 */
public interface StreamAble<T> extends QueryAvailable<T> {

    /**
     * 可迭代的流式结果集
     *
     * <blockquote><pre>
     *     {@code
     *
     * try(JdbcStreamResult<BlogEntity> streamResult = easyQuery.queryable(BlogEntity.class).toStreamResult(100)){
     *
     *             int i = 0;
     *             for (BlogEntity blog : streamResult.getStreamIterable()) {
     *                 String indexStr = String.valueOf(i);
     *                 Assert.assertEquals(indexStr, blog.getId());
     *                 Assert.assertEquals(indexStr, blog.getCreateBy());
     *                 Assert.assertEquals(begin.plusDays(i), blog.getCreateTime());
     *                 Assert.assertEquals(indexStr, blog.getUpdateBy());
     *                 i++;
     *             }
     *         } catch (SQLException e) {
     *             throw new RuntimeException(e);
     *         }
     * </pre></blockquote>
     *
     * @param fetchSize null表示不设置
     * @return
     */
   default JdbcStreamResult<T> toStreamResult(Integer fetchSize){
       return toStreamResult(s->{
           if(fetchSize!=null){
               s.setFetchSize(fetchSize);
           }
       });
   }
    JdbcStreamResult<T> toStreamResult(SQLConsumer<Statement> configurer);

    /**
     * 直接拉取数据
     * @param fetcher 如何消费拉取的数据
     * @return
     * @param <TR>
     */
    default <TR> TR streamBy(Function<Stream<T>,TR> fetcher,Integer fetchSize){
       return streamBy(fetcher,statement -> {statement.setFetchSize(fetchSize);});
    }

    /**
     * 请使用 {@link  #streamBy(Function, Integer)}
     * @param fetcher
     * @param fetchSize
     * @return
     * @param <TR>
     */
    @Deprecated
    default <TR> TR fetch(Function<Stream<T>,TR> fetcher,Integer fetchSize){
       return streamBy(fetcher,statement -> {statement.setFetchSize(fetchSize);});
    }
    /**
     * 直接拉取数据
     * @param fetcher 如何消费拉取的数据
     * @return
     * @param <TR>
     */
    default <TR> TR streamBy(Function<Stream<T>,TR> fetcher, SQLConsumer<Statement> configurer){
        try(JdbcStreamResult<T> streamResult = toStreamResult(configurer)){
            StreamIterable<T> streamIterable = streamResult.getStreamIterable();
            Stream<T> stream = StreamSupport.stream(streamIterable.spliterator(), false);
            return fetcher.apply(stream);
        }catch (SQLException sqlException){
            throw new EasyQuerySQLCommandException(sqlException);
        }
    }

    /**
     * 请使用 {@link  #streamBy(Function, Integer)}
     * @param fetcher
     * @param configurer
     * @return
     * @param <TR>
     */
    @Deprecated
    default <TR> TR fetch(Function<Stream<T>,TR> fetcher, SQLConsumer<Statement> configurer){
        return streamBy(fetcher,configurer);
    }

}
