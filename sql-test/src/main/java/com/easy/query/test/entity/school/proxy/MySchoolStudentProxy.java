package com.easy.query.test.entity.school.proxy;

import com.easy.query.core.expression.parser.core.available.TableAvailable;
import com.easy.query.core.proxy.AbstractProxyEntity;
import com.easy.query.core.proxy.SQLColumn;
import com.easy.query.core.proxy.SQLSelectAsExpression;
import com.easy.query.core.proxy.fetcher.AbstractFetcher;
import com.easy.query.core.proxy.core.EntitySQLContext;
import com.easy.query.test.entity.school.MySchoolStudent;
import com.easy.query.core.proxy.columns.SQLStringColumn;
import com.easy.query.core.proxy.columns.SQLNavigateColumn;
import com.easy.query.core.proxy.columns.SQLAnyColumn;

/**
 * this file automatically generated by easy-query, don't modify it
 * 当前文件是easy-query自动生成的请不要随意修改
 * 如果出现属性冲突请使用@ProxyProperty进行重命名
 *
 * @author xuejiaming
 */
public class MySchoolStudentProxy extends AbstractProxyEntity < MySchoolStudentProxy, MySchoolStudent > {

    private static final Class < MySchoolStudent > entityClass = MySchoolStudent .class;

    public static MySchoolStudentProxy createTable (){
        return new MySchoolStudentProxy ();
    }

    public MySchoolStudentProxy (){
    }

    /**
     *{@link MySchoolStudent#getId}
     */
    public SQLStringColumn < MySchoolStudentProxy, java.lang.String> id(){
    return getStringColumn("id", java.lang.String.class);
}

    /**
     *{@link MySchoolStudent#getClassId}
     */
    public SQLStringColumn < MySchoolStudentProxy, java.lang.String> classId(){
    return getStringColumn("classId", java.lang.String.class);
}

    /**
     *{@link MySchoolStudent#getName}
     */
    public SQLStringColumn < MySchoolStudentProxy, java.lang.String> name(){
    return getStringColumn("name", java.lang.String.class);
}

    /**
     *{@link MySchoolStudent#getSchoolClass}
     */
    public com . easy . query . test . entity . school . proxy . MySchoolClassProxy schoolClass() {
        return getNavigate(
            "schoolClass",
            new com . easy . query . test . entity . school . proxy . MySchoolClassProxy ()
        );
    }

    /**
     *{@link MySchoolStudent#getSchoolStudentAddress}
     */
    public com . easy . query . test . entity . school . proxy . MySchoolStudentAddressProxy schoolStudentAddress() {
        return getNavigate(
            "schoolStudentAddress",
            new com . easy . query . test . entity . school . proxy . MySchoolStudentAddressProxy ()
        );
    }


    @Override
    public Class < MySchoolStudent > getEntityClass (){
        return entityClass;
    }


    /**
     * 数据库列的简单获取
     * @return
     */
    public MySchoolStudentProxyFetcher FETCHER =
        new MySchoolStudentProxyFetcher (this, null, SQLSelectAsExpression.empty);


    public static class MySchoolStudentProxyFetcher extends AbstractFetcher<MySchoolStudentProxy, MySchoolStudent, MySchoolStudentProxyFetcher> {

        public MySchoolStudentProxyFetcher (MySchoolStudentProxy proxy, MySchoolStudentProxyFetcher prev, SQLSelectAsExpression sqlSelectAsExpression){
        super(proxy, prev, sqlSelectAsExpression);
    }


        /**
         *{@link MySchoolStudent#getId}
         */
        public MySchoolStudentProxyFetcher id() {
            return add(getProxy().id());
        }

        /**
         *{@link MySchoolStudent#getClassId}
         */
        public MySchoolStudentProxyFetcher classId() {
            return add(getProxy().classId());
        }

        /**
         *{@link MySchoolStudent#getName}
         */
        public MySchoolStudentProxyFetcher name() {
            return add(getProxy().name());
        }


        @Override
        protected MySchoolStudentProxyFetcher createFetcher(
            MySchoolStudentProxy cp,
            AbstractFetcher<MySchoolStudentProxy, MySchoolStudent, MySchoolStudentProxyFetcher> prev,
            SQLSelectAsExpression sqlSelectExpression
        ) {
            return new MySchoolStudentProxyFetcher (cp, this, sqlSelectExpression);
        }
    }

}
