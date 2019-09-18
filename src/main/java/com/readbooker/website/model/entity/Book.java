package com.readbooker.website.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
public class Book {
    private static final long serialVersionUID = 1001L;
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    long coverId;
    @NotEmpty(message = "书名不能为空")
    @Column(nullable = false, length = 100)
    String name;
    @NotEmpty(message = "人名不能为空")
    @Column(nullable=false)
    String author;
    @Column(nullable=false,length = 1000)
    String introduction;
    // 推荐：起点爬取
    @Column(nullable=true)
    long recommends;
    // 点击量 本站
    @Column(nullable=true)
    long clicks;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;
}
