package com.readbooker.website.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * 书籍标签
 */
@Data
@Entity
public class Label {
  private static final long serialVersionUID = 1001L;
  @Id // 主键
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
  long id;
  @Column(nullable = false)
  long bookId;
  @Column(nullable = false)
  String name;
  @NotEmpty(message = "标签级别")
  @Column(nullable = false)
  int flag;

}
