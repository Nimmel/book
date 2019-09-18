package com.readbooker.website.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


/**
 * 章节
 */
@Data
@Entity
public class Chapter {
  private static final long serialVersionUID = 1001L;
  @Id // 主键
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  @Column(nullable = false)
  long bookId;
  @Column(nullable = false)
  String name;

  @CreatedDate
  private Date createTime;

  @LastModifiedDate
  private Date updateTime;
}
