package com.easy.query.test.entity.school.dto.proxy;

import com.easy.query.core.expression.parser.core.available.TableAvailable;
import com.easy.query.core.proxy.AbstractProxyEntity;
import com.easy.query.core.proxy.SQLColumn;
import com.easy.query.core.proxy.SQLSelectAsExpression;
import com.easy.query.core.proxy.fetcher.AbstractFetcher;
import com.easy.query.core.proxy.core.EntitySQLContext;
import com.easy.query.test.entity.school.dto.SchoolClassVO;
import com.easy.query.core.proxy.columns.SQLStringColumn;
import com.easy.query.core.proxy.columns.SQLNavigateColumn;
import com.easy.query.core.proxy.columns.SQLQueryable;
import com.easy.query.core.proxy.columns.SQLAnyColumn;

/**
 * this file automatically generated by easy-query, don't modify it
 * 当前文件是easy-query自动生成的请不要随意修改
 * 如果出现属性冲突请使用@ProxyProperty进行重命名
 *
 * @author xuejiaming
 */
public class SchoolClassVOProxy extends AbstractProxyEntity < SchoolClassVOProxy, SchoolClassVO > {

    private static final Class < SchoolClassVO > entityClass = SchoolClassVO .class;

    public static SchoolClassVOProxy createTable (){
        return new SchoolClassVOProxy ();
    }

    public SchoolClassVOProxy (){
    }

    /**
     *{@link SchoolClassVO#getId}
     */
    public SQLStringColumn < SchoolClassVOProxy, java.lang.String> id(){
    return getStringColumn("id", java.lang.String.class);
}

    /**
     *{@link SchoolClassVO#getName}
     */
    public SQLStringColumn < SchoolClassVOProxy, java.lang.String> name(){
    return getStringColumn("name", java.lang.String.class);
}

    /**
     *{@link SchoolClassVO#getSchoolStudents}
     */
    public SQLQueryable < com . easy . query . test . entity . school . dto . proxy . SchoolStudentVOProxy, com.easy.query.test.entity.school.dto.SchoolStudentVO> schoolStudents(){
    return getNavigates(
        "schoolStudents",
        new com . easy . query . test . entity . school . dto . proxy . SchoolStudentVOProxy ()
    );
}

    /**
     *{@link SchoolClassVO#getSchoolTeachers}
     */
    public SQLQueryable < com . easy . query . test . entity . school . dto . proxy . SchoolTeacherVOProxy, com.easy.query.test.entity.school.dto.SchoolTeacherVO> schoolTeachers(){
    return getNavigates(
        "schoolTeachers",
        new com . easy . query . test . entity . school . dto . proxy . SchoolTeacherVOProxy ()
    );
}


    @Override
    public Class < SchoolClassVO > getEntityClass (){
        return entityClass;
    }


    /**
     * 数据库列的简单获取
     * @return
     */
    public SchoolClassVOProxyFetcher FETCHER = new SchoolClassVOProxyFetcher (this, null, SQLSelectAsExpression.empty);


    public static class SchoolClassVOProxyFetcher extends AbstractFetcher<SchoolClassVOProxy, SchoolClassVO, SchoolClassVOProxyFetcher> {

        public SchoolClassVOProxyFetcher (SchoolClassVOProxy proxy, SchoolClassVOProxyFetcher prev, SQLSelectAsExpression sqlSelectAsExpression){
        super(proxy, prev, sqlSelectAsExpression);
    }


        /**
         *{@link SchoolClassVO#getId}
         */
        public SchoolClassVOProxyFetcher id() {
            return add(getProxy().id());
        }

        /**
         *{@link SchoolClassVO#getName}
         */
        public SchoolClassVOProxyFetcher name() {
            return add(getProxy().name());
        }


        @Override
        protected SchoolClassVOProxyFetcher createFetcher(
            SchoolClassVOProxy cp,
            AbstractFetcher<SchoolClassVOProxy, SchoolClassVO, SchoolClassVOProxyFetcher> prev,
            SQLSelectAsExpression sqlSelectExpression
        ) {
            return new SchoolClassVOProxyFetcher (cp, this, sqlSelectExpression);
        }
    }

}
