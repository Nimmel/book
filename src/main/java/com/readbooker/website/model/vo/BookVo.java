package com.readbooker.website.model.vo;

import cn.hutool.core.date.DateUtil;
import com.readbooker.website.model.base.OutputConverter;
import com.readbooker.website.model.entity.Book;
import com.readbooker.website.model.entity.Chapter;
import com.readbooker.website.model.entity.Label;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class BookVo implements OutputConverter<BookVo, Book> {
    long id;
    long coverId;
    String name;
    String author;
    String introduction;
    // 更新时间
    Date updateTime;

    // 入库时间
    Date createTime;

    // 推荐：起点爬取
    long recommends;
    // 点击量 本站
    long clicks;

    // 封面url
    String coverUrl;
    // 主标签
    Label category;

    List<Label> labels;

    Chapter laterChapter;
    List<Chapter> chapters;

    public String format(Date date){
        return DateUtil.format(date,"yyyy-MM-dd HH:mm");
    }

}
