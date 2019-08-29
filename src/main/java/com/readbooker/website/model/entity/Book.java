package com.readbooker.website.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Book {
    private static final long serialVersionUID = 1001L;
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    long id;
    @Column
    long coverId;
    @NotEmpty(message = "书名不能为空")
    @Column(nullable = false, length = 100)
    String name;
    @NotEmpty(message = "人名不能为空")
    @Column(nullable=false)
    String author;
    @Column(nullable=false)
    String introduction;
    // 入库时间
    @Column(nullable=false)
    String insertTime;
    // 更新时间
    @Column(nullable=false)
    String updateTime;

    // 推荐：起点爬取
    @Column(nullable=true)
    long recommends;
    // 点击量 本站
    @Column(nullable=true)
    long clicks;
}
