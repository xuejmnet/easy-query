package com.easy.query.test.entity.proxy;

import com.easy.query.core.proxy.AbstractProxyEntity;
import com.easy.query.core.proxy.SQLSelectAsExpression;
import com.easy.query.core.proxy.columns.SQLAnyColumn;
import com.easy.query.core.proxy.columns.SQLDateTimeColumn;
import com.easy.query.core.proxy.columns.SQLNumberColumn;
import com.easy.query.core.proxy.columns.SQLStringColumn;
import com.easy.query.core.proxy.fetcher.AbstractFetcher;
import com.easy.query.test.entity.TopicTypeTest1;

/**
 * this file automatically generated by easy-query, don't modify it
 * 当前文件是easy-query自动生成的请不要随意修改
 * 如果出现属性冲突请使用@ProxyProperty进行重命名
 *
 * @author xuejiaming
 */
public class TopicTypeTest1Proxy extends AbstractProxyEntity < TopicTypeTest1Proxy, TopicTypeTest1 > {

    private static final Class < TopicTypeTest1 > entityClass = TopicTypeTest1 .class;

    public static TopicTypeTest1Proxy createTable () {
        return new TopicTypeTest1Proxy ();
    }

    public TopicTypeTest1Proxy () {
    }

    /**
     * {@link TopicTypeTest1#getId}
     */
    public SQLStringColumn < TopicTypeTest1Proxy, String> id(){
    return getStringColumn("id", String.class);
}

    /**
     * {@link TopicTypeTest1#getStars}
     */
    public SQLNumberColumn < TopicTypeTest1Proxy, Integer> stars(){
    return getNumberColumn("stars", Integer.class);
}

    /**
     * {@link TopicTypeTest1#getTitle}
     */
    public SQLStringColumn < TopicTypeTest1Proxy, String> title(){
    return getStringColumn("title", String.class);
}

    /**
     * {@link TopicTypeTest1#getTopicType}
     */
    public SQLAnyColumn < TopicTypeTest1Proxy, com.easy.query.test.enums.TopicTypeEnum> topicType(){
    return getAnyColumn("topicType", com.easy.query.test.enums.TopicTypeEnum.class);
}

    /**
     * {@link TopicTypeTest1#getCreateTime}
     */
    public SQLDateTimeColumn < TopicTypeTest1Proxy, java.time.LocalDateTime> createTime(){
    return getDateTimeColumn("createTime", java.time.LocalDateTime.class);
}


    @Override
    public Class < TopicTypeTest1 > getEntityClass () {
        return entityClass;
    }


    /**
     * 数据库列的简单获取
     * @return
     */
    public TopicTypeTest1ProxyFetcher FETCHER =
        new TopicTypeTest1ProxyFetcher (this, null, SQLSelectAsExpression.empty);


    public static class TopicTypeTest1ProxyFetcher extends AbstractFetcher<TopicTypeTest1Proxy, TopicTypeTest1, TopicTypeTest1ProxyFetcher> {

        public TopicTypeTest1ProxyFetcher (TopicTypeTest1Proxy proxy, TopicTypeTest1ProxyFetcher prev, SQLSelectAsExpression sqlSelectAsExpression) {
        super(proxy, prev, sqlSelectAsExpression);
    }


        /**
         * {@link TopicTypeTest1#getId}
         */
        public TopicTypeTest1ProxyFetcher id() {
            return add(getProxy().id());
        }

        /**
         * {@link TopicTypeTest1#getStars}
         */
        public TopicTypeTest1ProxyFetcher stars() {
            return add(getProxy().stars());
        }

        /**
         * {@link TopicTypeTest1#getTitle}
         */
        public TopicTypeTest1ProxyFetcher title() {
            return add(getProxy().title());
        }

        /**
         * {@link TopicTypeTest1#getTopicType}
         */
        public TopicTypeTest1ProxyFetcher topicType() {
            return add(getProxy().topicType());
        }

        /**
         * {@link TopicTypeTest1#getCreateTime}
         */
        public TopicTypeTest1ProxyFetcher createTime() {
            return add(getProxy().createTime());
        }


        @Override
        protected TopicTypeTest1ProxyFetcher createFetcher(
            TopicTypeTest1Proxy cp,
            AbstractFetcher<TopicTypeTest1Proxy, TopicTypeTest1, TopicTypeTest1ProxyFetcher> prev,
            SQLSelectAsExpression sqlSelectExpression
        ) {
            return new TopicTypeTest1ProxyFetcher (cp, this, sqlSelectExpression);
        }
    }

}
