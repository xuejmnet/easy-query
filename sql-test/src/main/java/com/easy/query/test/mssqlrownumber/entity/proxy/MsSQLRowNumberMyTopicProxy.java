package com.easy.query.test.mssqlrownumber.entity.proxy;

import com.easy.query.core.expression.parser.core.available.TableAvailable;
import com.easy.query.core.proxy.AbstractProxyEntity;
import com.easy.query.core.proxy.SQLColumn;
import com.easy.query.core.proxy.SQLSelectAsExpression;
import com.easy.query.core.proxy.fetcher.AbstractFetcher;
import com.easy.query.core.proxy.core.EntitySQLContext;
import com.easy.query.test.mssqlrownumber.entity.MsSQLRowNumberMyTopic;
import com.easy.query.core.proxy.columns.SQLStringColumn;
import com.easy.query.core.proxy.columns.SQLNumberColumn;
import com.easy.query.core.proxy.columns.SQLDateTimeColumn;

/**
 * this file automatically generated by easy-query, don't modify it
 * 当前文件是easy-query自动生成的请不要随意修改
 *
 * @author xuejiaming
 */
public class MsSQLRowNumberMyTopicProxy extends AbstractProxyEntity < MsSQLRowNumberMyTopicProxy, MsSQLRowNumberMyTopic > {

    private static final Class < MsSQLRowNumberMyTopic > entityClass = MsSQLRowNumberMyTopic .class;

    public static MsSQLRowNumberMyTopicProxy createTable () {
        return new MsSQLRowNumberMyTopicProxy ();
    }

    public MsSQLRowNumberMyTopicProxy () {
    }

    /**
     * {@link MsSQLRowNumberMyTopic#getId}
     */
    public SQLStringColumn < MsSQLRowNumberMyTopicProxy, java.lang.String> id(){
    return getStringColumn("id", java.lang.String.class);
}

    /**
     * {@link MsSQLRowNumberMyTopic#getStars}
     */
    public SQLNumberColumn < MsSQLRowNumberMyTopicProxy, java.lang.Integer> stars(){
    return getNumberColumn("stars", java.lang.Integer.class);
}

    /**
     * {@link MsSQLRowNumberMyTopic#getTitle}
     */
    public SQLStringColumn < MsSQLRowNumberMyTopicProxy, java.lang.String> title(){
    return getStringColumn("title", java.lang.String.class);
}

    /**
     * {@link MsSQLRowNumberMyTopic#getCreateTime}
     */
    public SQLDateTimeColumn < MsSQLRowNumberMyTopicProxy, java.time.LocalDateTime> createTime(){
    return getDateTimeColumn("createTime", java.time.LocalDateTime.class);
}


    @Override
    public Class < MsSQLRowNumberMyTopic > getEntityClass () {
        return entityClass;
    }


    /**
     * 数据库列的简单获取
     * @return
     */
    public MsSQLRowNumberMyTopicProxyFetcher FETCHER =
        new MsSQLRowNumberMyTopicProxyFetcher (this, null, SQLSelectAsExpression.empty);


    public static class MsSQLRowNumberMyTopicProxyFetcher extends AbstractFetcher<MsSQLRowNumberMyTopicProxy, MsSQLRowNumberMyTopic, MsSQLRowNumberMyTopicProxyFetcher> {

        public MsSQLRowNumberMyTopicProxyFetcher (MsSQLRowNumberMyTopicProxy proxy, MsSQLRowNumberMyTopicProxyFetcher prev, SQLSelectAsExpression sqlSelectAsExpression) {
        super(proxy, prev, sqlSelectAsExpression);
    }


        /**
         * {@link MsSQLRowNumberMyTopic#getId}
         */
        public MsSQLRowNumberMyTopicProxyFetcher id() {
            return add(getProxy().id());
        }

        /**
         * {@link MsSQLRowNumberMyTopic#getStars}
         */
        public MsSQLRowNumberMyTopicProxyFetcher stars() {
            return add(getProxy().stars());
        }

        /**
         * {@link MsSQLRowNumberMyTopic#getTitle}
         */
        public MsSQLRowNumberMyTopicProxyFetcher title() {
            return add(getProxy().title());
        }

        /**
         * {@link MsSQLRowNumberMyTopic#getCreateTime}
         */
        public MsSQLRowNumberMyTopicProxyFetcher createTime() {
            return add(getProxy().createTime());
        }


        @Override
        protected MsSQLRowNumberMyTopicProxyFetcher createFetcher(
            MsSQLRowNumberMyTopicProxy cp,
            AbstractFetcher<MsSQLRowNumberMyTopicProxy, MsSQLRowNumberMyTopic, MsSQLRowNumberMyTopicProxyFetcher> prev,
            SQLSelectAsExpression sqlSelectExpression
        ) {
            return new MsSQLRowNumberMyTopicProxyFetcher (cp, this, sqlSelectExpression);
        }
    }

}
