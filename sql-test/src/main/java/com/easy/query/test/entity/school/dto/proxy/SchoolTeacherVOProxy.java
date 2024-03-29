package com.easy.query.test.entity.school.dto.proxy;

import com.easy.query.core.proxy.AbstractProxyEntity;
import com.easy.query.core.proxy.SQLColumn;
import com.easy.query.core.proxy.SQLSelectAsExpression;
import com.easy.query.core.proxy.fetcher.AbstractFetcher;
import com.easy.query.test.entity.school.dto.SchoolTeacherVO;

/**
 * this file automatically generated by easy-query, don't modify it
 * 当前文件是easy-query自动生成的请不要随意修改
 *
 * @author xuejiaming
 */
public class SchoolTeacherVOProxy extends AbstractProxyEntity < SchoolTeacherVOProxy, SchoolTeacherVO > {

    private static final Class < SchoolTeacherVO > entityClass = SchoolTeacherVO .class;

    public static SchoolTeacherVOProxy createTable () {
        return new SchoolTeacherVOProxy ();
    }

    public SchoolTeacherVOProxy () {
    }

    /**
     * {@link SchoolTeacherVO#getId}
     */
    public SQLColumn < SchoolTeacherVOProxy, java.lang.String> id(){
    return get("id");
}

    /**
     * {@link SchoolTeacherVO#getName}
     */
    public SQLColumn < SchoolTeacherVOProxy, java.lang.String> name(){
    return get("name");
}


    @Override
    public Class < SchoolTeacherVO > getEntityClass () {
        return entityClass;
    }


    /**
     * 数据库列的简单获取
     * @return
     */
    public SchoolTeacherVOProxyFetcher FETCHER =
        new SchoolTeacherVOProxyFetcher (this, null, SQLSelectAsExpression.empty);


    public static class SchoolTeacherVOProxyFetcher extends AbstractFetcher<SchoolTeacherVOProxy, SchoolTeacherVO, SchoolTeacherVOProxyFetcher> {

        public SchoolTeacherVOProxyFetcher (SchoolTeacherVOProxy proxy, SchoolTeacherVOProxyFetcher prev, SQLSelectAsExpression sqlSelectAsExpression) {
        super(proxy, prev, sqlSelectAsExpression);
    }


        /**
         * {@link SchoolTeacherVO#getId}
         */
        public SchoolTeacherVOProxyFetcher id() {
            return add(getProxy().id());
        }

        /**
         * {@link SchoolTeacherVO#getName}
         */
        public SchoolTeacherVOProxyFetcher name() {
            return add(getProxy().name());
        }


        @Override
        protected SchoolTeacherVOProxyFetcher createFetcher(
            SchoolTeacherVOProxy cp,
            AbstractFetcher<SchoolTeacherVOProxy, SchoolTeacherVO, SchoolTeacherVOProxyFetcher> prev,
            SQLSelectAsExpression sqlSelectExpression
        ) {
            return new SchoolTeacherVOProxyFetcher (cp, this, sqlSelectExpression);
        }
    }

}
