package com.readbooker.website.service;

import com.readbooker.website.model.entity.Chapter;
import com.readbooker.website.model.vo.ChapterVo;
import lombok.NonNull;

public interface ChapterService {

  Chapter getChapterById(long id);

  String getContentByChapterId(long cid);

}
