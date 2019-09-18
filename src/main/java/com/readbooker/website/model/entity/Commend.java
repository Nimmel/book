package com.readbooker.website.model.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public class Commend {
  long id;
  long capitalId;
  long userId;
  // 回复评论ID
  long refId;

//  @CreatedDate
//  private Date createTime;
}
