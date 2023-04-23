package com.easy.query.entity;

import com.easy.query.core.annotation.Column;
import com.easy.query.core.annotation.ShardingTableKey;
import com.easy.query.core.annotation.Table;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @FileName: Topic.java
 * @Description: 文件说明
 * @Date: 2023/3/16 21:26
 * @author xuejiaming
 */
@Data
@Table("t_topic_sharding")
@ToString
public class TopicSharding {

    @Column(primaryKey = true)
    @ShardingTableKey
    private String id;
    private Integer stars;
    private String title;
    private LocalDateTime createTime;
}
