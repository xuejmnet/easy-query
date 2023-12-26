package com.easy.query.core.proxy.core.draft.proxy;

import com.easy.query.core.proxy.AbstractProxyEntity;
import com.easy.query.core.proxy.SQLColumn;
import com.easy.query.core.proxy.SQLSelectAsExpression;
import com.easy.query.core.proxy.core.draft.Draft6;
import com.easy.query.core.proxy.fetcher.AbstractFetcher;
import com.easy.query.core.util.EasyObjectUtil;

/**
 * this file automatically generated by easy-query, don't modify it
 * 当前文件是easy-query自动生成的请不要随意修改
 *
 * @author xuejiaming
 */
public class Draft6Proxy<T1,T2,T3,T4,T5,T6> extends AbstractProxyEntity<Draft6Proxy<T1,T2,T3,T4,T5,T6>, Draft6<T1,T2,T3,T4,T5,T6>> {

    private static final Class<Draft6> entityClass = Draft6.class;

    public static <TR1,TR2,TR3,TR4,TR5,TR6> Draft6Proxy<TR1,TR2,TR3,TR4,TR5,TR6> createTable() {
        return new Draft6Proxy<>();
    }

    public Draft6Proxy() {
    }

    /**
     * {@link Draft6#getValue1}
     */
    public SQLColumn<Draft6Proxy<T1,T2,T3,T4,T5,T6>, T1> value1() {
        return get("value1");
    }

    /**
     * {@link Draft6#getValue2()}
     */
    public SQLColumn<Draft6Proxy<T1,T2,T3,T4,T5,T6>, T2> value2() {
        return get("value2");
    }
    /**
     * {@link Draft6#getValue3()}
     */
    public SQLColumn<Draft6Proxy<T1,T2,T3,T4,T5,T6>, T3> value3() {
        return get("value3");
    }
    /**
     * {@link Draft6#getValue4()}
     */
    public SQLColumn<Draft6Proxy<T1,T2,T3,T4,T5,T6>, T4> value4() {
        return get("value4");
    }
    /**
     * {@link Draft6#getValue5()}
     */
    public SQLColumn<Draft6Proxy<T1,T2,T3,T4,T5,T6>, T5> value5() {
        return get("value5");
    }
    /**
     * {@link Draft6#getValue6()}
     */
    public SQLColumn<Draft6Proxy<T1,T2,T3,T4,T5,T6>, T6> value6() {
        return get("value6");
    }


    @Override
    public Class<Draft6<T1,T2,T3,T4,T5,T6>> getEntityClass() {
        return EasyObjectUtil.typeCastNullable(entityClass);
    }


    /**
     * 数据库列的简单获取
     *
     * @return
     */
    public Draft6ProxyFetcher<T1,T2,T3,T4,T5,T6> FETCHER = new Draft6ProxyFetcher<>(this, null, SQLSelectAsExpression.empty);


    public static class Draft6ProxyFetcher<TF1,TF2,TF3,TF4,TF5,TF6> extends AbstractFetcher<Draft6Proxy<TF1,TF2,TF3,TF4,TF5,TF6>, Draft6<TF1,TF2,TF3,TF4,TF5,TF6>, Draft6ProxyFetcher<TF1,TF2,TF3,TF4,TF5,TF6>> {

        public Draft6ProxyFetcher(Draft6Proxy<TF1,TF2,TF3,TF4,TF5,TF6> proxy, Draft6ProxyFetcher<TF1,TF2,TF3,TF4,TF5,TF6> prev, SQLSelectAsExpression sqlSelectAsExpression) {
            super(proxy, prev, sqlSelectAsExpression);
        }


        /**
         * {@link Draft6#getValue1}
         */
        public Draft6ProxyFetcher<TF1,TF2,TF3,TF4,TF5,TF6> value1() {
            return add(getProxy().value1());
        }


        /**
         * {@link Draft6#getValue2}
         */
        public Draft6ProxyFetcher<TF1,TF2,TF3,TF4,TF5,TF6> value2() {
            return add(getProxy().value2());
        }
        /**
         * {@link Draft6#getValue3}
         */
        public Draft6ProxyFetcher<TF1,TF2,TF3,TF4,TF5,TF6> value3() {
            return add(getProxy().value3());
        }
        /**
         * {@link Draft6#getValue4}
         */
        public Draft6ProxyFetcher<TF1,TF2,TF3,TF4,TF5,TF6> value4() {
            return add(getProxy().value4());
        }
        /**
         * {@link Draft6#getValue5}
         */
        public Draft6ProxyFetcher<TF1,TF2,TF3,TF4,TF5,TF6> value5() {
            return add(getProxy().value5());
        }
        /**
         * {@link Draft6#getValue6}
         */
        public Draft6ProxyFetcher<TF1,TF2,TF3,TF4,TF5,TF6> value6() {
            return add(getProxy().value6());
        }


        @Override
        protected Draft6ProxyFetcher<TF1,TF2,TF3,TF4,TF5,TF6> createFetcher(
                Draft6Proxy<TF1,TF2,TF3,TF4,TF5,TF6> cp,
                AbstractFetcher<Draft6Proxy<TF1,TF2,TF3,TF4,TF5,TF6>, Draft6<TF1,TF2,TF3,TF4,TF5,TF6>, Draft6ProxyFetcher<TF1,TF2,TF3,TF4,TF5,TF6>> prev,
                SQLSelectAsExpression sqlSelectExpression
        ) {
            return new Draft6ProxyFetcher<>(cp, this, sqlSelectExpression);
        }
    }

}