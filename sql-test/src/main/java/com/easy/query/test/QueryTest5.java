package com.easy.query.test;

import com.easy.query.api4j.func.LambdaSQLFunc;
import com.easy.query.api4j.select.Queryable10;
import com.easy.query.api4j.select.Queryable4;
import com.easy.query.api4j.select.Queryable5;
import com.easy.query.api4j.select.Queryable6;
import com.easy.query.api4j.select.Queryable7;
import com.easy.query.api4j.select.Queryable8;
import com.easy.query.api4j.select.Queryable9;
import com.easy.query.core.enums.AggregatePredicateCompare;
import com.easy.query.core.exception.EasyQuerySQLCommandException;
import com.easy.query.core.exception.EasyQuerySQLStatementException;
import com.easy.query.core.exception.EasyQuerySingleMoreElementException;
import com.easy.query.core.expression.parser.core.base.ColumnAsSelector;
import com.easy.query.core.func.SQLFunction;
import com.easy.query.test.dto.BlogEntityTest;
import com.easy.query.test.dto.TopicRequest;
import com.easy.query.test.dto.TopicTypeVO;
import com.easy.query.test.entity.BlogEntity;
import com.easy.query.test.entity.Topic;
import com.easy.query.test.func.SQLTestFunc;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/**
 * create time 2023/10/17 16:13
 * 文件说明
 *
 * @author xuejiaming
 */
public class QueryTest5 extends BaseTest {

    private Queryable10<Topic, Topic, Topic, Topic, Topic, Topic, Topic, Topic, Topic, Topic> baseQueryable1() {
        TopicRequest topicRequest = new TopicRequest();
        topicRequest.setCreateTimeBegin(LocalDateTime.now());
        Queryable10<Topic, Topic, Topic, Topic, Topic, Topic, Topic, Topic, Topic, Topic> topicTopicTopicTopicTopicTopicTopicTopicTopicTopicQueryable10 = easyQuery.queryable(Topic.class)
                .leftJoin(Topic.class, (t, t1) -> t.eq(t1, Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t2(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t3(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t4(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t5(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t6(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t7(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t8(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t9(), Topic::getId, Topic::getId))
                .where(o -> o.eq(Topic::getId, 1))
                .where(false, o -> o.eq(Topic::getId, 1))
                .whereById("1")
                .whereById(false, "1")
                .whereById(Collections.singletonList("1"))
                .whereById(false, Collections.singletonList("1"))
                .whereObject(topicRequest)
                .whereObject(false, topicRequest)
                .whereMerge(o -> {
                    o.t().eq(Topic::getId, "1");
                    o.t().eq(false, Topic::getId, "1");
                    o.t().ne(Topic::getId, "1");
                    o.t().ne(false, Topic::getId, "1");
                    o.t().ge(Topic::getId, "1");
                    o.t().ge(false, Topic::getId, "1");
                    o.t().gt(Topic::getId, "1");
                    o.t().gt(false, Topic::getId, "1");
                    o.t().le(Topic::getId, "1");
                    o.t().le(false, Topic::getId, "1");
                    o.t().lt(Topic::getId, "1");
                    o.t().lt(false, Topic::getId, "1");
                    o.t().like(Topic::getId, "1");
                    o.t().like(false, Topic::getId, "1");
                    o.t().notLike(Topic::getId, "1");
                    o.t().notLike(false, Topic::getId, "1");
                    o.t().likeMatchLeft(Topic::getId, "1");
                    o.t().likeMatchLeft(false, Topic::getId, "1");
                    o.t().likeMatchRight(Topic::getId, "1");
                    o.t().likeMatchRight(false, Topic::getId, "1");
                    o.t().notLikeMatchLeft(Topic::getId, "1");
                    o.t().notLikeMatchLeft(false, Topic::getId, "1");
                    o.t().notLikeMatchRight(Topic::getId, "1");
                    o.t().notLikeMatchRight(false, Topic::getId, "1");
                })
                .limit(1, 2)
                .orderByAsc(o -> o.column(Topic::getCreateTime))
                .orderByDesc(o -> o.column(Topic::getCreateTime))
                .orderByAsc(false, o -> o.column(Topic::getCreateTime))
                .orderByDesc(false, o -> o.column(Topic::getCreateTime))
                .orderByAscMerge(o -> o.t().column(Topic::getCreateTime))
                .orderByDescMerge(o -> o.t().column(Topic::getCreateTime))
                .orderByAscMerge(false, o -> o.t().column(Topic::getCreateTime))
                .orderByDescMerge(false, o -> o.t().column(Topic::getCreateTime))
                .groupByMerge(o -> o.t().column(Topic::getId))
                .groupByMerge(false, o -> o.t().column(Topic::getId))
                .havingMerge(o -> o.t().count(Topic::getId, AggregatePredicateCompare.GE, 1))
                .havingMerge(false, o -> o.t().count(Topic::getId, AggregatePredicateCompare.GE, 1));
        return topicTopicTopicTopicTopicTopicTopicTopicTopicTopicQueryable10;
    }

    private Queryable9<Topic, Topic, Topic, Topic, Topic, Topic, Topic, Topic, Topic> baseQueryable2() {
        TopicRequest topicRequest = new TopicRequest();
        topicRequest.setCreateTimeBegin(LocalDateTime.now());
        return easyQuery.queryable(Topic.class)
                .leftJoin(Topic.class, (t, t1) -> t.eq(t1, Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t2(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t3(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t4(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t5(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t6(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t7(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t8(), Topic::getId, Topic::getId))
                .where(o -> o.eq(Topic::getId, 1))
                .where(false, o -> o.eq(Topic::getId, 1))
                .whereById("1")
                .whereById(false, "1")
                .whereById(Collections.singletonList("1"))
                .whereById(false, Collections.singletonList("1"))
                .whereObject(topicRequest)
                .whereObject(false, topicRequest)
                .whereMerge(o -> {
                    o.t().eq(Topic::getId, "1");
                    o.t().eq(false, Topic::getId, "1");
                    o.t().ne(Topic::getId, "1");
                    o.t().ne(false, Topic::getId, "1");
                    o.t().ge(Topic::getId, "1");
                    o.t().ge(false, Topic::getId, "1");
                    o.t().gt(Topic::getId, "1");
                    o.t().gt(false, Topic::getId, "1");
                    o.t().le(Topic::getId, "1");
                    o.t().le(false, Topic::getId, "1");
                    o.t().lt(Topic::getId, "1");
                    o.t().lt(false, Topic::getId, "1");
                    o.t().like(Topic::getId, "1");
                    o.t().like(false, Topic::getId, "1");
                    o.t().notLike(Topic::getId, "1");
                    o.t().notLike(false, Topic::getId, "1");
                    o.t().likeMatchLeft(Topic::getId, "1");
                    o.t().likeMatchLeft(false, Topic::getId, "1");
                    o.t().likeMatchRight(Topic::getId, "1");
                    o.t().likeMatchRight(false, Topic::getId, "1");
                    o.t().notLikeMatchLeft(Topic::getId, "1");
                    o.t().notLikeMatchLeft(false, Topic::getId, "1");
                    o.t().notLikeMatchRight(Topic::getId, "1");
                    o.t().notLikeMatchRight(false, Topic::getId, "1");
                })
                .limit(1, 2)
                .orderByAsc(o -> o.column(Topic::getCreateTime))
                .orderByDesc(o -> o.column(Topic::getCreateTime))
                .orderByAsc(false, o -> o.column(Topic::getCreateTime))
                .orderByDesc(false, o -> o.column(Topic::getCreateTime))
                .orderByAscMerge(o -> o.t().column(Topic::getCreateTime))
                .orderByDescMerge(o -> o.t().column(Topic::getCreateTime))
                .orderByAscMerge(false, o -> o.t().column(Topic::getCreateTime))
                .orderByDescMerge(false, o -> o.t().column(Topic::getCreateTime))
                .groupByMerge(o -> o.t().column(Topic::getId))
                .groupByMerge(false, o -> o.t().column(Topic::getId))
                .havingMerge(o -> o.t().count(Topic::getId, AggregatePredicateCompare.GE, 1))
                .havingMerge(false, o -> o.t().count(Topic::getId, AggregatePredicateCompare.GE, 1));
    }

    private Queryable8<Topic, Topic, Topic, Topic, Topic, Topic, Topic, Topic> baseQueryable3() {
        TopicRequest topicRequest = new TopicRequest();
        topicRequest.setCreateTimeBegin(LocalDateTime.now());
        return easyQuery.queryable(Topic.class)
                .leftJoin(Topic.class, (t, t1) -> t.eq(t1, Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t2(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t3(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t4(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t5(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t6(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t7(), Topic::getId, Topic::getId))
                .where(o -> o.eq(Topic::getId, 1))
                .where(false, o -> o.eq(Topic::getId, 1))
                .whereById("1")
                .whereById(false, "1")
                .whereById(Collections.singletonList("1"))
                .whereById(false, Collections.singletonList("1"))
                .whereObject(topicRequest)
                .whereObject(false, topicRequest)
                .whereMerge(o -> {
                    o.t().eq(Topic::getId, "1");
                    o.t().eq(false, Topic::getId, "1");
                    o.t().ne(Topic::getId, "1");
                    o.t().ne(false, Topic::getId, "1");
                    o.t().ge(Topic::getId, "1");
                    o.t().ge(false, Topic::getId, "1");
                    o.t().gt(Topic::getId, "1");
                    o.t().gt(false, Topic::getId, "1");
                    o.t().le(Topic::getId, "1");
                    o.t().le(false, Topic::getId, "1");
                    o.t().lt(Topic::getId, "1");
                    o.t().lt(false, Topic::getId, "1");
                    o.t().like(Topic::getId, "1");
                    o.t().like(false, Topic::getId, "1");
                    o.t().notLike(Topic::getId, "1");
                    o.t().notLike(false, Topic::getId, "1");
                    o.t().likeMatchLeft(Topic::getId, "1");
                    o.t().likeMatchLeft(false, Topic::getId, "1");
                    o.t().likeMatchRight(Topic::getId, "1");
                    o.t().likeMatchRight(false, Topic::getId, "1");
                    o.t().notLikeMatchLeft(Topic::getId, "1");
                    o.t().notLikeMatchLeft(false, Topic::getId, "1");
                    o.t().notLikeMatchRight(Topic::getId, "1");
                    o.t().notLikeMatchRight(false, Topic::getId, "1");
                })
                .limit(1, 2)
                .orderByAsc(o -> o.column(Topic::getCreateTime))
                .orderByDesc(o -> o.column(Topic::getCreateTime))
                .orderByAsc(false, o -> o.column(Topic::getCreateTime))
                .orderByDesc(false, o -> o.column(Topic::getCreateTime))
                .orderByAscMerge(o -> o.t().column(Topic::getCreateTime))
                .orderByDescMerge(o -> o.t().column(Topic::getCreateTime))
                .orderByAscMerge(false, o -> o.t().column(Topic::getCreateTime))
                .orderByDescMerge(false, o -> o.t().column(Topic::getCreateTime))
                .groupByMerge(o -> o.t().column(Topic::getId))
                .groupByMerge(false, o -> o.t().column(Topic::getId))
                .havingMerge(o -> o.t().count(Topic::getId, AggregatePredicateCompare.GE, 1))
                .havingMerge(false, o -> o.t().count(Topic::getId, AggregatePredicateCompare.GE, 1));
    }

    private Queryable7<Topic, Topic, Topic, Topic, Topic, Topic, Topic> baseQueryable4() {
        TopicRequest topicRequest = new TopicRequest();
        topicRequest.setCreateTimeBegin(LocalDateTime.now());
        return easyQuery.queryable(Topic.class)
                .leftJoin(Topic.class, (t, t1) -> t.eq(t1, Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t2(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t3(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t4(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t5(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t6(), Topic::getId, Topic::getId))
                .where(o -> o.eq(Topic::getId, 1))
                .where(false, o -> o.eq(Topic::getId, 1))
                .whereById("1")
                .whereById(false, "1")
                .whereById(Collections.singletonList("1"))
                .whereById(false, Collections.singletonList("1"))
                .whereObject(topicRequest)
                .whereObject(false, topicRequest)
                .whereMerge(o -> {
                    o.t().eq(Topic::getId, "1");
                    o.t().eq(false, Topic::getId, "1");
                    o.t().ne(Topic::getId, "1");
                    o.t().ne(false, Topic::getId, "1");
                    o.t().ge(Topic::getId, "1");
                    o.t().ge(false, Topic::getId, "1");
                    o.t().gt(Topic::getId, "1");
                    o.t().gt(false, Topic::getId, "1");
                    o.t().le(Topic::getId, "1");
                    o.t().le(false, Topic::getId, "1");
                    o.t().lt(Topic::getId, "1");
                    o.t().lt(false, Topic::getId, "1");
                    o.t().like(Topic::getId, "1");
                    o.t().like(false, Topic::getId, "1");
                    o.t().notLike(Topic::getId, "1");
                    o.t().notLike(false, Topic::getId, "1");
                    o.t().likeMatchLeft(Topic::getId, "1");
                    o.t().likeMatchLeft(false, Topic::getId, "1");
                    o.t().likeMatchRight(Topic::getId, "1");
                    o.t().likeMatchRight(false, Topic::getId, "1");
                    o.t().notLikeMatchLeft(Topic::getId, "1");
                    o.t().notLikeMatchLeft(false, Topic::getId, "1");
                    o.t().notLikeMatchRight(Topic::getId, "1");
                    o.t().notLikeMatchRight(false, Topic::getId, "1");
                })
                .limit(1, 2)
                .orderByAsc(o -> o.column(Topic::getCreateTime))
                .orderByDesc(o -> o.column(Topic::getCreateTime))
                .orderByAsc(false, o -> o.column(Topic::getCreateTime))
                .orderByDesc(false, o -> o.column(Topic::getCreateTime))
                .orderByAscMerge(o -> o.t().column(Topic::getCreateTime))
                .orderByDescMerge(o -> o.t().column(Topic::getCreateTime))
                .orderByAscMerge(false, o -> o.t().column(Topic::getCreateTime))
                .orderByDescMerge(false, o -> o.t().column(Topic::getCreateTime))
                .groupByMerge(o -> o.t().column(Topic::getId))
                .groupByMerge(false, o -> o.t().column(Topic::getId))
                .havingMerge(o -> o.t().count(Topic::getId, AggregatePredicateCompare.GE, 1))
                .havingMerge(false, o -> o.t().count(Topic::getId, AggregatePredicateCompare.GE, 1));
    }

    private Queryable6<Topic, Topic, Topic, Topic, Topic, Topic> baseQueryable5() {
        TopicRequest topicRequest = new TopicRequest();
        topicRequest.setCreateTimeBegin(LocalDateTime.now());
        return easyQuery.queryable(Topic.class)
                .leftJoin(Topic.class, (t, t1) -> t.eq(t1, Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t2(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t3(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t4(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t5(), Topic::getId, Topic::getId))
                .where(o -> o.eq(Topic::getId, 1))
                .where(false, o -> o.eq(Topic::getId, 1))
                .whereById("1")
                .whereById(false, "1")
                .whereById(Collections.singletonList("1"))
                .whereById(false, Collections.singletonList("1"))
                .whereObject(topicRequest)
                .whereObject(false, topicRequest)
                .whereMerge(o -> {
                    o.t().eq(Topic::getId, "1");
                    o.t().eq(false, Topic::getId, "1");
                    o.t().ne(Topic::getId, "1");
                    o.t().ne(false, Topic::getId, "1");
                    o.t().ge(Topic::getId, "1");
                    o.t().ge(false, Topic::getId, "1");
                    o.t().gt(Topic::getId, "1");
                    o.t().gt(false, Topic::getId, "1");
                    o.t().le(Topic::getId, "1");
                    o.t().le(false, Topic::getId, "1");
                    o.t().lt(Topic::getId, "1");
                    o.t().lt(false, Topic::getId, "1");
                    o.t().like(Topic::getId, "1");
                    o.t().like(false, Topic::getId, "1");
                    o.t().notLike(Topic::getId, "1");
                    o.t().notLike(false, Topic::getId, "1");
                    o.t().likeMatchLeft(Topic::getId, "1");
                    o.t().likeMatchLeft(false, Topic::getId, "1");
                    o.t().likeMatchRight(Topic::getId, "1");
                    o.t().likeMatchRight(false, Topic::getId, "1");
                    o.t().notLikeMatchLeft(Topic::getId, "1");
                    o.t().notLikeMatchLeft(false, Topic::getId, "1");
                    o.t().notLikeMatchRight(Topic::getId, "1");
                    o.t().notLikeMatchRight(false, Topic::getId, "1");
                })
                .limit(1, 2)
                .orderByAsc(o -> o.column(Topic::getCreateTime))
                .orderByDesc(o -> o.column(Topic::getCreateTime))
                .orderByAsc(false, o -> o.column(Topic::getCreateTime))
                .orderByDesc(false, o -> o.column(Topic::getCreateTime))
                .orderByAscMerge(o -> o.t().column(Topic::getCreateTime))
                .orderByDescMerge(o -> o.t().column(Topic::getCreateTime))
                .orderByAscMerge(false, o -> o.t().column(Topic::getCreateTime))
                .orderByDescMerge(false, o -> o.t().column(Topic::getCreateTime))
                .groupByMerge(o -> o.t().column(Topic::getId))
                .groupByMerge(false, o -> o.t().column(Topic::getId))
                .havingMerge(o -> o.t().count(Topic::getId, AggregatePredicateCompare.GE, 1))
                .havingMerge(false, o -> o.t().count(Topic::getId, AggregatePredicateCompare.GE, 1));
    }

    private Queryable5<Topic, Topic, Topic, Topic, Topic> baseQueryable6() {
        TopicRequest topicRequest = new TopicRequest();
        topicRequest.setCreateTimeBegin(LocalDateTime.now());
        return easyQuery.queryable(Topic.class)
                .leftJoin(Topic.class, (t, t1) -> t.eq(t1, Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t2(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t3(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t4(), Topic::getId, Topic::getId))
                .where(o -> o.eq(Topic::getId, 1))
                .where(false, o -> o.eq(Topic::getId, 1))
                .whereById("1")
                .whereById(false, "1")
                .whereById(Collections.singletonList("1"))
                .whereById(false, Collections.singletonList("1"))
                .whereObject(topicRequest)
                .whereObject(false, topicRequest)
                .whereMerge(o -> {
                    o.t().eq(Topic::getId, "1");
                    o.t().eq(false, Topic::getId, "1");
                    o.t().ne(Topic::getId, "1");
                    o.t().ne(false, Topic::getId, "1");
                    o.t().ge(Topic::getId, "1");
                    o.t().ge(false, Topic::getId, "1");
                    o.t().gt(Topic::getId, "1");
                    o.t().gt(false, Topic::getId, "1");
                    o.t().le(Topic::getId, "1");
                    o.t().le(false, Topic::getId, "1");
                    o.t().lt(Topic::getId, "1");
                    o.t().lt(false, Topic::getId, "1");
                    o.t().like(Topic::getId, "1");
                    o.t().like(false, Topic::getId, "1");
                    o.t().notLike(Topic::getId, "1");
                    o.t().notLike(false, Topic::getId, "1");
                    o.t().likeMatchLeft(Topic::getId, "1");
                    o.t().likeMatchLeft(false, Topic::getId, "1");
                    o.t().likeMatchRight(Topic::getId, "1");
                    o.t().likeMatchRight(false, Topic::getId, "1");
                    o.t().notLikeMatchLeft(Topic::getId, "1");
                    o.t().notLikeMatchLeft(false, Topic::getId, "1");
                    o.t().notLikeMatchRight(Topic::getId, "1");
                    o.t().notLikeMatchRight(false, Topic::getId, "1");
                })
                .limit(1, 2)
                .orderByAsc(o -> o.column(Topic::getCreateTime))
                .orderByDesc(o -> o.column(Topic::getCreateTime))
                .orderByAsc(false, o -> o.column(Topic::getCreateTime))
                .orderByDesc(false, o -> o.column(Topic::getCreateTime))
                .orderByAscMerge(o -> o.t().column(Topic::getCreateTime))
                .orderByDescMerge(o -> o.t().column(Topic::getCreateTime))
                .orderByAscMerge(false, o -> o.t().column(Topic::getCreateTime))
                .orderByDescMerge(false, o -> o.t().column(Topic::getCreateTime))
                .groupByMerge(o -> o.t().column(Topic::getId))
                .groupByMerge(false, o -> o.t().column(Topic::getId))
                .havingMerge(o -> o.t().count(Topic::getId, AggregatePredicateCompare.GE, 1))
                .havingMerge(false, o -> o.t().count(Topic::getId, AggregatePredicateCompare.GE, 1));
    }

    private Queryable4<Topic, Topic, Topic, Topic> baseQueryable7() {
        TopicRequest topicRequest = new TopicRequest();
        topicRequest.setCreateTimeBegin(LocalDateTime.now());
        return easyQuery.queryable(Topic.class)
                .leftJoin(Topic.class, (t, t1) -> t.eq(t1, Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t2(), Topic::getId, Topic::getId))
                .leftJoinMerge(Topic.class, o -> o.t().eq(o.t3(), Topic::getId, Topic::getId))
                .where(o -> o.eq(Topic::getId, 1))
                .where(false, o -> o.eq(Topic::getId, 1))
                .whereById("1")
                .whereById(false, "1")
                .whereById(Collections.singletonList("1"))
                .whereById(false, Collections.singletonList("1"))
                .whereObject(topicRequest)
                .whereObject(false, topicRequest)
                .whereMerge(o -> {
                    o.t().eq(Topic::getId, "1");
                    o.t().eq(false, Topic::getId, "1");
                    o.t().ne(Topic::getId, "1");
                    o.t().ne(false, Topic::getId, "1");
                    o.t().ge(Topic::getId, "1");
                    o.t().ge(false, Topic::getId, "1");
                    o.t().gt(Topic::getId, "1");
                    o.t().gt(false, Topic::getId, "1");
                    o.t().le(Topic::getId, "1");
                    o.t().le(false, Topic::getId, "1");
                    o.t().lt(Topic::getId, "1");
                    o.t().lt(false, Topic::getId, "1");
                    o.t().like(Topic::getId, "1");
                    o.t().like(false, Topic::getId, "1");
                    o.t().notLike(Topic::getId, "1");
                    o.t().notLike(false, Topic::getId, "1");
                    o.t().likeMatchLeft(Topic::getId, "1");
                    o.t().likeMatchLeft(false, Topic::getId, "1");
                    o.t().likeMatchRight(Topic::getId, "1");
                    o.t().likeMatchRight(false, Topic::getId, "1");
                    o.t().notLikeMatchLeft(Topic::getId, "1");
                    o.t().notLikeMatchLeft(false, Topic::getId, "1");
                    o.t().notLikeMatchRight(Topic::getId, "1");
                    o.t().notLikeMatchRight(false, Topic::getId, "1");
                })
                .limit(1, 2)
                .orderByAsc(o -> o.column(Topic::getCreateTime))
                .orderByDesc(o -> o.column(Topic::getCreateTime))
                .orderByAsc(false, o -> o.column(Topic::getCreateTime))
                .orderByDesc(false, o -> o.column(Topic::getCreateTime))
                .orderByAscMerge(o -> o.t().column(Topic::getCreateTime))
                .orderByDescMerge(o -> o.t().column(Topic::getCreateTime))
                .orderByAscMerge(false, o -> o.t().column(Topic::getCreateTime))
                .orderByDescMerge(false, o -> o.t().column(Topic::getCreateTime))
                .groupByMerge(o -> o.t().column(Topic::getId))
                .groupByMerge(false, o -> o.t().column(Topic::getId))
                .havingMerge(o -> o.t().count(Topic::getId, AggregatePredicateCompare.GE, 1))
                .havingMerge(false, o -> o.t().count(Topic::getId, AggregatePredicateCompare.GE, 1));
    }

    @Test
    public void joinTest1() {
        String sql = baseQueryable1().selectMerge(Topic.class, o -> {
            o.t().column(Topic::getId);
            o.t().columnCountAs(Topic::getId, Topic::getStars);
        }).toSQL();
        Assert.assertEquals("SELECT t.`id`,COUNT(t.`id`) AS `stars` FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` LEFT JOIN `t_topic` t4 ON t.`id` = t4.`id` LEFT JOIN `t_topic` t5 ON t.`id` = t5.`id` LEFT JOIN `t_topic` t6 ON t.`id` = t6.`id` LEFT JOIN `t_topic` t7 ON t.`id` = t7.`id` LEFT JOIN `t_topic` t8 ON t.`id` = t8.`id` LEFT JOIN `t_topic` t9 ON t.`id` = t9.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1", sql);

    }

    @Test
    public void joinTest1_1() {
        Supplier<Exception> f = () -> {
            try {
                baseQueryable1().asTable("a123").sumBigDecimalOrDefault(Topic::getStars,BigDecimal.ZERO);
            }catch (Exception ex){
                return ex;
            }
            return null;
        };
        Exception exception = f.get();
        Assert.assertNotNull(exception);
        Assert.assertTrue(exception instanceof EasyQuerySQLCommandException);
        EasyQuerySQLCommandException easyQuerySQLCommandException = (EasyQuerySQLCommandException) exception;
        Assert.assertTrue(easyQuerySQLCommandException.getCause() instanceof EasyQuerySQLStatementException);
        EasyQuerySQLStatementException easyQuerySQLStatementException = (EasyQuerySQLStatementException) easyQuerySQLCommandException.getCause();
        Assert.assertEquals("SELECT SUM(t.`stars`) FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` LEFT JOIN `t_topic` t4 ON t.`id` = t4.`id` LEFT JOIN `t_topic` t5 ON t.`id` = t5.`id` LEFT JOIN `t_topic` t6 ON t.`id` = t6.`id` LEFT JOIN `t_topic` t7 ON t.`id` = t7.`id` LEFT JOIN `t_topic` t8 ON t.`id` = t8.`id` LEFT JOIN `a123` t9 ON t.`id` = t9.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1",easyQuerySQLStatementException.getSQL());
    }
    @Test
    public void joinTest1_2() {
        Supplier<Exception> f = () -> {
            try {
                baseQueryable1().asTable("a123").sumOrDefault(Topic::getStars,BigDecimal.ZERO);
            }catch (Exception ex){
                return ex;
            }
            return null;
        };
        Exception exception = f.get();
        Assert.assertNotNull(exception);
        Assert.assertTrue(exception instanceof EasyQuerySQLCommandException);
        EasyQuerySQLCommandException easyQuerySQLCommandException = (EasyQuerySQLCommandException) exception;
        Assert.assertTrue(easyQuerySQLCommandException.getCause() instanceof EasyQuerySQLStatementException);
        EasyQuerySQLStatementException easyQuerySQLStatementException = (EasyQuerySQLStatementException) easyQuerySQLCommandException.getCause();
        Assert.assertEquals("SELECT SUM(t.`stars`) FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` LEFT JOIN `t_topic` t4 ON t.`id` = t4.`id` LEFT JOIN `t_topic` t5 ON t.`id` = t5.`id` LEFT JOIN `t_topic` t6 ON t.`id` = t6.`id` LEFT JOIN `t_topic` t7 ON t.`id` = t7.`id` LEFT JOIN `t_topic` t8 ON t.`id` = t8.`id` LEFT JOIN `a123` t9 ON t.`id` = t9.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1",easyQuerySQLStatementException.getSQL());
    }
    @Test
    public void joinTest1_3() {
        Supplier<Exception> f = () -> {
            try {
                baseQueryable1().asTable("a123").avgBigDecimalOrNull(Topic::getStars);
            }catch (Exception ex){
                return ex;
            }
            return null;
        };
        Exception exception = f.get();
        Assert.assertNotNull(exception);
        Assert.assertTrue(exception instanceof EasyQuerySQLCommandException);
        EasyQuerySQLCommandException easyQuerySQLCommandException = (EasyQuerySQLCommandException) exception;
        Assert.assertTrue(easyQuerySQLCommandException.getCause() instanceof EasyQuerySQLStatementException);
        EasyQuerySQLStatementException easyQuerySQLStatementException = (EasyQuerySQLStatementException) easyQuerySQLCommandException.getCause();
        Assert.assertEquals("SELECT AVG(t.`stars`) FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` LEFT JOIN `t_topic` t4 ON t.`id` = t4.`id` LEFT JOIN `t_topic` t5 ON t.`id` = t5.`id` LEFT JOIN `t_topic` t6 ON t.`id` = t6.`id` LEFT JOIN `t_topic` t7 ON t.`id` = t7.`id` LEFT JOIN `t_topic` t8 ON t.`id` = t8.`id` LEFT JOIN `a123` t9 ON t.`id` = t9.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1",easyQuerySQLStatementException.getSQL());
    }
    @Test
    public void joinTest1_4() {
        Supplier<Exception> f = () -> {
            try {
                baseQueryable1().asTable("a123").avgBigDecimalOrDefault((t,t1,t2,t3,t4,t5,t6,t7,t8,t9)->t2.column(Topic::getStars),BigDecimal.ZERO);
            }catch (Exception ex){
                return ex;
            }
            return null;
        };
        Exception exception = f.get();
        Assert.assertNotNull(exception);
        Assert.assertTrue(exception instanceof EasyQuerySQLCommandException);
        EasyQuerySQLCommandException easyQuerySQLCommandException = (EasyQuerySQLCommandException) exception;
        Assert.assertTrue(easyQuerySQLCommandException.getCause() instanceof EasyQuerySQLStatementException);
        EasyQuerySQLStatementException easyQuerySQLStatementException = (EasyQuerySQLStatementException) easyQuerySQLCommandException.getCause();
        Assert.assertEquals("SELECT AVG(t2.`stars`) FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` LEFT JOIN `t_topic` t4 ON t.`id` = t4.`id` LEFT JOIN `t_topic` t5 ON t.`id` = t5.`id` LEFT JOIN `t_topic` t6 ON t.`id` = t6.`id` LEFT JOIN `t_topic` t7 ON t.`id` = t7.`id` LEFT JOIN `t_topic` t8 ON t.`id` = t8.`id` LEFT JOIN `a123` t9 ON t.`id` = t9.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1",easyQuerySQLStatementException.getSQL());
    }
    @Test
    public void joinTest1_5() {
        Supplier<Exception> f = () -> {
            try {
                baseQueryable1().asTable("a123").avgBigDecimalOrNull((t,t1,t2,t3,t4,t5,t6,t7,t8,t9)->t2.column(Topic::getStars));
            }catch (Exception ex){
                return ex;
            }
            return null;
        };
        Exception exception = f.get();
        Assert.assertNotNull(exception);
        Assert.assertTrue(exception instanceof EasyQuerySQLCommandException);
        EasyQuerySQLCommandException easyQuerySQLCommandException = (EasyQuerySQLCommandException) exception;
        Assert.assertTrue(easyQuerySQLCommandException.getCause() instanceof EasyQuerySQLStatementException);
        EasyQuerySQLStatementException easyQuerySQLStatementException = (EasyQuerySQLStatementException) easyQuerySQLCommandException.getCause();
        Assert.assertEquals("SELECT AVG(t2.`stars`) FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` LEFT JOIN `t_topic` t4 ON t.`id` = t4.`id` LEFT JOIN `t_topic` t5 ON t.`id` = t5.`id` LEFT JOIN `t_topic` t6 ON t.`id` = t6.`id` LEFT JOIN `t_topic` t7 ON t.`id` = t7.`id` LEFT JOIN `t_topic` t8 ON t.`id` = t8.`id` LEFT JOIN `a123` t9 ON t.`id` = t9.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1",easyQuerySQLStatementException.getSQL());
    }
    @Test
    public void joinTest1_6() {
        Supplier<Exception> f = () -> {
            try {
                baseQueryable1().asTable("a123").avgOrNull((t,t1,t2,t3,t4,t5,t6,t7,t8,t9)->t2.column(Topic::getStars));
            }catch (Exception ex){
                return ex;
            }
            return null;
        };
        Exception exception = f.get();
        Assert.assertNotNull(exception);
        Assert.assertTrue(exception instanceof EasyQuerySQLCommandException);
        EasyQuerySQLCommandException easyQuerySQLCommandException = (EasyQuerySQLCommandException) exception;
        Assert.assertTrue(easyQuerySQLCommandException.getCause() instanceof EasyQuerySQLStatementException);
        EasyQuerySQLStatementException easyQuerySQLStatementException = (EasyQuerySQLStatementException) easyQuerySQLCommandException.getCause();
        Assert.assertEquals("SELECT AVG(t2.`stars`) FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` LEFT JOIN `t_topic` t4 ON t.`id` = t4.`id` LEFT JOIN `t_topic` t5 ON t.`id` = t5.`id` LEFT JOIN `t_topic` t6 ON t.`id` = t6.`id` LEFT JOIN `t_topic` t7 ON t.`id` = t7.`id` LEFT JOIN `t_topic` t8 ON t.`id` = t8.`id` LEFT JOIN `a123` t9 ON t.`id` = t9.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1",easyQuerySQLStatementException.getSQL());
    }
    @Test
    public void joinTest1_7() {
        Supplier<Exception> f = () -> {
            try {
                baseQueryable1().asTable("a123").avgOrDefault((t,t1,t2,t3,t4,t5,t6,t7,t8,t9)->t2.column(Topic::getStars),0d);
            }catch (Exception ex){
                return ex;
            }
            return null;
        };
        Exception exception = f.get();
        Assert.assertNotNull(exception);
        Assert.assertTrue(exception instanceof EasyQuerySQLCommandException);
        EasyQuerySQLCommandException easyQuerySQLCommandException = (EasyQuerySQLCommandException) exception;
        Assert.assertTrue(easyQuerySQLCommandException.getCause() instanceof EasyQuerySQLStatementException);
        EasyQuerySQLStatementException easyQuerySQLStatementException = (EasyQuerySQLStatementException) easyQuerySQLCommandException.getCause();
        Assert.assertEquals("SELECT AVG(t2.`stars`) FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` LEFT JOIN `t_topic` t4 ON t.`id` = t4.`id` LEFT JOIN `t_topic` t5 ON t.`id` = t5.`id` LEFT JOIN `t_topic` t6 ON t.`id` = t6.`id` LEFT JOIN `t_topic` t7 ON t.`id` = t7.`id` LEFT JOIN `t_topic` t8 ON t.`id` = t8.`id` LEFT JOIN `a123` t9 ON t.`id` = t9.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1",easyQuerySQLStatementException.getSQL());
    }
    @Test
    public void joinTest1_8() {
        Supplier<Exception> f = () -> {
            try {
                baseQueryable1().asTable("a123").avgFloatOrDefault((t,t1,t2,t3,t4,t5,t6,t7,t8,t9)->t2.column(Topic::getStars),0f);
            }catch (Exception ex){
                return ex;
            }
            return null;
        };
        Exception exception = f.get();
        Assert.assertNotNull(exception);
        Assert.assertTrue(exception instanceof EasyQuerySQLCommandException);
        EasyQuerySQLCommandException easyQuerySQLCommandException = (EasyQuerySQLCommandException) exception;
        Assert.assertTrue(easyQuerySQLCommandException.getCause() instanceof EasyQuerySQLStatementException);
        EasyQuerySQLStatementException easyQuerySQLStatementException = (EasyQuerySQLStatementException) easyQuerySQLCommandException.getCause();
        Assert.assertEquals("SELECT AVG(t2.`stars`) FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` LEFT JOIN `t_topic` t4 ON t.`id` = t4.`id` LEFT JOIN `t_topic` t5 ON t.`id` = t5.`id` LEFT JOIN `t_topic` t6 ON t.`id` = t6.`id` LEFT JOIN `t_topic` t7 ON t.`id` = t7.`id` LEFT JOIN `t_topic` t8 ON t.`id` = t8.`id` LEFT JOIN `a123` t9 ON t.`id` = t9.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1",easyQuerySQLStatementException.getSQL());
    }
    @Test
    public void joinTest1_9() {
        Supplier<Exception> f = () -> {
            try {
                baseQueryable1().asTable("a123").avgFloatOrNull((t,t1,t2,t3,t4,t5,t6,t7,t8,t9)->t2.column(Topic::getStars));
            }catch (Exception ex){
                return ex;
            }
            return null;
        };
        Exception exception = f.get();
        Assert.assertNotNull(exception);
        Assert.assertTrue(exception instanceof EasyQuerySQLCommandException);
        EasyQuerySQLCommandException easyQuerySQLCommandException = (EasyQuerySQLCommandException) exception;
        Assert.assertTrue(easyQuerySQLCommandException.getCause() instanceof EasyQuerySQLStatementException);
        EasyQuerySQLStatementException easyQuerySQLStatementException = (EasyQuerySQLStatementException) easyQuerySQLCommandException.getCause();
        Assert.assertEquals("SELECT AVG(t2.`stars`) FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` LEFT JOIN `t_topic` t4 ON t.`id` = t4.`id` LEFT JOIN `t_topic` t5 ON t.`id` = t5.`id` LEFT JOIN `t_topic` t6 ON t.`id` = t6.`id` LEFT JOIN `t_topic` t7 ON t.`id` = t7.`id` LEFT JOIN `t_topic` t8 ON t.`id` = t8.`id` LEFT JOIN `a123` t9 ON t.`id` = t9.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1",easyQuerySQLStatementException.getSQL());
    }

    @Test
    public void joinTest2() {
        String sql = baseQueryable2().selectMerge(Topic.class, o -> {
            o.t().column(Topic::getId);
            o.t().columnCountAs(Topic::getId, Topic::getStars);
        }).toSQL();
        Assert.assertEquals("SELECT t.`id`,COUNT(t.`id`) AS `stars` FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` LEFT JOIN `t_topic` t4 ON t.`id` = t4.`id` LEFT JOIN `t_topic` t5 ON t.`id` = t5.`id` LEFT JOIN `t_topic` t6 ON t.`id` = t6.`id` LEFT JOIN `t_topic` t7 ON t.`id` = t7.`id` LEFT JOIN `t_topic` t8 ON t.`id` = t8.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1", sql);
    }

    @Test
    public void joinTest3() {
        String sql = baseQueryable3().selectMerge(Topic.class, o -> {
            o.t().column(Topic::getId);
            o.t().columnCountAs(Topic::getId, Topic::getStars);
        }).toSQL();
        Assert.assertEquals("SELECT t.`id`,COUNT(t.`id`) AS `stars` FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` LEFT JOIN `t_topic` t4 ON t.`id` = t4.`id` LEFT JOIN `t_topic` t5 ON t.`id` = t5.`id` LEFT JOIN `t_topic` t6 ON t.`id` = t6.`id` LEFT JOIN `t_topic` t7 ON t.`id` = t7.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1", sql);
    }

    @Test
    public void joinTest4() {
        String sql = baseQueryable4().selectMerge(Topic.class, o -> {
            o.t().column(Topic::getId);
            o.t().columnCountAs(Topic::getId, Topic::getStars);
        }).toSQL();
        Assert.assertEquals("SELECT t.`id`,COUNT(t.`id`) AS `stars` FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` LEFT JOIN `t_topic` t4 ON t.`id` = t4.`id` LEFT JOIN `t_topic` t5 ON t.`id` = t5.`id` LEFT JOIN `t_topic` t6 ON t.`id` = t6.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1", sql);
    }

    @Test
    public void joinTest5() {
        String sql = baseQueryable5().selectMerge(Topic.class, o -> {
            o.t().column(Topic::getId);
            o.t().columnCountAs(Topic::getId, Topic::getStars);
        }).toSQL();
        Assert.assertEquals("SELECT t.`id`,COUNT(t.`id`) AS `stars` FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` LEFT JOIN `t_topic` t4 ON t.`id` = t4.`id` LEFT JOIN `t_topic` t5 ON t.`id` = t5.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1", sql);
    }

    @Test
    public void joinTest6() {
        String sql = baseQueryable6().selectMerge(Topic.class, o -> {
            o.t().column(Topic::getId);
            o.t().columnCountAs(Topic::getId, Topic::getStars);
        }).toSQL();
        Assert.assertEquals("SELECT t.`id`,COUNT(t.`id`) AS `stars` FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` LEFT JOIN `t_topic` t4 ON t.`id` = t4.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1", sql);
    }

    @Test
    public void joinTest7() {
        String sql = baseQueryable7().selectMerge(Topic.class, o -> {
            o.t().column(Topic::getId);
            o.t().columnCountAs(Topic::getId, Topic::getStars);
        }).toSQL();
        Assert.assertEquals("SELECT t.`id`,COUNT(t.`id`) AS `stars` FROM `t_topic` t LEFT JOIN `t_topic` t1 ON t.`id` = t1.`id` LEFT JOIN `t_topic` t2 ON t.`id` = t2.`id` LEFT JOIN `t_topic` t3 ON t.`id` = t3.`id` WHERE t.`id` = ? AND t.`id` = ? AND t.`id` = ? AND t.`create_time` > ? AND t.`id` = ? AND t.`id` <> ? AND t.`id` >= ? AND t.`id` > ? AND t.`id` <= ? AND t.`id` < ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` LIKE ? AND t.`id` LIKE ? AND t.`id` NOT LIKE ? AND t.`id` NOT LIKE ? GROUP BY t.`id` HAVING COUNT(t.`id`) >= ? ORDER BY t.`create_time` ASC,t.`create_time` DESC,t.`create_time` ASC,t.`create_time` DESC LIMIT 2 OFFSET 1", sql);
    }

    @Test
    public void test1() {
        Integer integer = easyQuery.queryable("select 1", Integer.class)
                .firstOrNull();
        Assert.assertEquals(1, (int) integer);
        String sql = easyQuery.queryable("select 1", Integer.class).toSQL();
        Assert.assertEquals("SELECT * FROM (select 1) t", sql);
    }

    @Test
    public void test2() {
        {
            String sql = easyQuery.queryable(Topic.class)
                    .select(o -> o.columnAll()).toSQL();

            Assert.assertEquals("SELECT `id`,`stars`,`title`,`create_time` FROM `t_topic`", sql);
        }
        {
            String sql = easyQuery.queryable(Topic.class)
                    .select(Topic.class, o -> o.columnAll().column(Topic::getAlias)).toSQL();

            Assert.assertEquals("SELECT t.`id`,t.`stars`,t.`title`,t.`create_time`,t.`alias` FROM `t_topic` t", sql);
        }
        {
            String sql = easyQuery.queryable(Topic.class)
                    .select(o -> o.columnAll().column(Topic::getAlias)).toSQL();

            Assert.assertEquals("SELECT `id`,`stars`,`title`,`create_time`,`alias` FROM `t_topic`", sql);
        }
        {
            String sql = easyQuery.queryable(Topic.class).toSQL();

            Assert.assertEquals("SELECT `id`,`stars`,`title`,`create_time` FROM `t_topic`", sql);
        }
        {
            String sql = easyQuery.queryable(Topic.class).select(Topic.class, o -> {
                LambdaSQLFunc<Topic> fx = o.fx();
                SQLFunction ifNull = fx.valueOrDefault(Topic::getStars, 1);
                o.sqlFuncAs(fx.sum(ifNull), Topic::getStars);
            }).toSQL();

            Assert.assertEquals("SELECT SUM(IFNULL(t.`stars`,?)) AS `stars` FROM `t_topic` t", sql);
        }
        {
            String sql = easyQuery.queryable(Topic.class).select(Topic.class, o -> {
                LambdaSQLFunc<Topic> fx = o.fx();
                SQLFunction ifNull = fx.valueOrDefault(Topic::getStars, 1);
                o.sqlFuncAs(fx.sum(ifNull).distinct(true), Topic::getStars);
            }).toSQL();

            Assert.assertEquals("SELECT SUM(DISTINCT IFNULL(t.`stars`,?)) AS `stars` FROM `t_topic` t", sql);
//
//            easyEntityQuery.queryable(Topic.class)
//                    .where(topic -> topic.id().eq("123"))
//                    .select(topic -> new AnonymousTypeNameProxy().adapter(r->{
//        r.name().set(topic.createTime());
//        r.age().set(topic.stars());
//        })

//)
//            easyQueryClient.queryable(Topic.class)
//                    .where(o->{
//                        SQLFunc fx = o.fx();
//                        o.eq(fx.nullOrDefault("id","12"),"123");
//                    })
        }
        {
            String sql = easyQuery.queryable(Topic.class)
                    .select(TopicTypeVO.class, o -> {

                        o.sqlNativeSegment("ROW_NUMBER() OVER(ORDER BY {0})", c -> {
                            c.expression(Topic::getCreateTime).setPropertyAlias(TopicTypeVO::getTitle);
                        });

                        o.columnAll().columnIgnore(Topic::getTitle);


                    }).toSQL();

            Assert.assertEquals("SELECT ROW_NUMBER() OVER(ORDER BY t.`create_time`) AS `title`,t.`id`,t.`stars`,t.`create_time` FROM `t_topic` t", sql);
        }
        {
            ArrayList<String> columns = new ArrayList<>();
            columns.add("id");
            columns.add("title");
            columns.add("stars");
            String sql = easyQuery.queryable(Topic.class)
                    .select(TopicTypeVO.class, o -> {
                        ColumnAsSelector<Topic, TopicTypeVO> columnAsSelector = o.getColumnAsSelector();
                        for (String column : columns) {
                            columnAsSelector.column(column);
                        }

                    }).toSQL();

            Assert.assertEquals("SELECT t.`id`,t.`title`,t.`stars` FROM `t_topic` t", sql);
        }
        {

            String sql = easyQuery.queryable(Topic.class)
                    .select(TopicTypeVO.class, o -> {
                        o.column(Topic::getId);
                        o.column(Topic::getTitle);
                        o.column(Topic::getStars);

                    }).toSQL();

            Assert.assertEquals("SELECT t.`id`,t.`title`,t.`stars` FROM `t_topic` t", sql);
        }
        {

            String sql = easyQueryClient.queryable(Topic.class)
                    .select(TopicTypeVO.class, o -> {
                        o.column("id");
                        o.column("title");
                        o.column("stars");

                    }).toSQL();

            Assert.assertEquals("SELECT t.`id`,t.`title`,t.`stars` FROM `t_topic` t", sql);
        }
        {
            ArrayList<String> columns = new ArrayList<>();
            columns.add("id");
            columns.add("title");
            String sql = easyQuery.queryable(Topic.class)
                    .select(TopicTypeVO.class, o -> {
                        ColumnAsSelector<Topic, TopicTypeVO> columnAsSelector = o.getColumnAsSelector();
                        for (String column : columns) {
                            columnAsSelector.column(column);
                        }

                    }).toSQL();

            Assert.assertEquals("SELECT t.`id`,t.`title` FROM `t_topic` t", sql);
        }
    }

    @Test
    public void groupTest5_2() {
        Supplier<Exception> x = () -> {
            try {

                BlogEntity blogEntity = easyQuery.queryable(BlogEntity.class)
                        .groupBy(o -> o.column(BlogEntity::getId))
                        .select(BlogEntity.class, o -> o
                                .columnAs(BlogEntity::getId, BlogEntity::getId)
                                .columnSum(BlogEntity::getScore, c -> c.distinct(true).nullDefault(BigDecimal.ZERO))
                                .columnCount(BlogEntity::getOrder, c -> c.distinct(true).nullDefault(BigDecimal.ONE))
                                .columnAvg(BlogEntity::getStatus, c -> c.distinct(true).nullDefault(BigDecimal.valueOf(3)))
                        ).singleOrNull();
            } catch (Exception ex) {
                return ex;
            }
            return null;
        };
        Exception exception = x.get();
        Assert.assertNotNull(exception);
        Assert.assertTrue(exception instanceof EasyQuerySingleMoreElementException);
    }
    @Test
    public void joinTestx() {
        Supplier<Exception> f = () -> {
            try {
                Long aLong = easyQuery
                        .queryable(Topic.class)
                        .asTable("a123")
                        .innerJoin(BlogEntity.class, (t, t1) -> t.eq(t1, Topic::getId, BlogEntity::getId))
                        .where((t, t1) -> t1.isNotNull(BlogEntity::getTitle))
                        .groupBy((t, t1) -> t1.columnFunc(SQLTestFunc.ifNULL(BlogEntity::getId)))
                        .select(BlogEntity.class, (t, t1) -> t1.columnFuncAs(SQLTestFunc.ifNULL(BlogEntity::getId), BlogEntity::getId).columnSum(BlogEntity::getScore))
                        .distinct()
                        .select(Long.class, o -> o.columnCount(BlogEntity::getId)).firstOrNull();
            }catch (Exception ex){
                return ex;
            }
            return null;
        };
        Exception exception = f.get();
        Assert.assertNotNull(exception);
        Assert.assertTrue(exception instanceof EasyQuerySQLCommandException);
        EasyQuerySQLCommandException easyQuerySQLCommandException = (EasyQuerySQLCommandException) exception;
        Assert.assertTrue(easyQuerySQLCommandException.getCause() instanceof EasyQuerySQLStatementException);
        EasyQuerySQLStatementException easyQuerySQLStatementException = (EasyQuerySQLStatementException) easyQuerySQLCommandException.getCause();
        Assert.assertEquals("SELECT COUNT(t2.`id`) AS `id` FROM (SELECT DISTINCT IFNULL(t1.`id`,'') AS `id`,SUM(t1.`score`) AS `score` FROM `a123` t INNER JOIN `t_blog` t1 ON t1.`deleted` = ? AND t.`id` = t1.`id` WHERE t1.`title` IS NOT NULL GROUP BY IFNULL(t1.`id`,'')) t2 LIMIT 1",easyQuerySQLStatementException.getSQL());
    }
    @Test
    public void joinTestx1() {
        Supplier<Exception> f = () -> {
            try {

                List<BlogEntityTest> list = easyQuery.queryable(BlogEntity.class)
                        .select(BlogEntityTest.class).toList();

                List<BlogEntityTest> list1 = easyQuery.queryable(BlogEntity.class)
                        .asTable("a123")
                        .select(BlogEntityTest.class).toList();
            }catch (Exception ex){
                return ex;
            }
            return null;
        };
        Exception exception = f.get();
        Assert.assertNotNull(exception);
        Assert.assertTrue(exception instanceof EasyQuerySQLCommandException);
        EasyQuerySQLCommandException easyQuerySQLCommandException = (EasyQuerySQLCommandException) exception;
        Assert.assertTrue(easyQuerySQLCommandException.getCause() instanceof EasyQuerySQLStatementException);
        EasyQuerySQLStatementException easyQuerySQLStatementException = (EasyQuerySQLStatementException) easyQuerySQLCommandException.getCause();
        Assert.assertEquals("SELECT t.`title`,t.`content`,t.`url`,t.`star`,t.`publish_time`,t.`score`,t.`status`,t.`order`,t.`is_top`,t.`top` FROM `a123` t WHERE t.`deleted` = ?",easyQuerySQLStatementException.getSQL());
    }
}
