package com.readbooker.website.model.vo;

import com.readbooker.website.model.base.OutputConverter;
import com.readbooker.website.model.entity.Chapter;
import java.util.Date;
import lombok.Data;

@Data
public class ChapterVo implements OutputConverter<ChapterVo, Chapter> {
  long id;
  long bookId;
  String name;
  private Date createTime;
  private Date updateTime;

  String content;

  public long next(){
    return id+1;
  }

  public long before(){
    return id+1;
  }

}
