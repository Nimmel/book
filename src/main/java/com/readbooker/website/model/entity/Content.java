package com.readbooker.website.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Entity
public class Content {
  @Id // 主键
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  @Column(nullable = false)
  long chapterId;
  @Lob
  @Column(nullable = false,columnDefinition="TEXT")
  String content;
}
