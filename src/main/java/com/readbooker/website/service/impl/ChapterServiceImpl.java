package com.readbooker.website.service.impl;

import com.readbooker.website.model.entity.Chapter;
import com.readbooker.website.model.entity.Content;
import com.readbooker.website.repository.ChapterRepository;
import com.readbooker.website.repository.ContentRepository;
import com.readbooker.website.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ChapterServiceImpl implements ChapterService {
  @Autowired
  ChapterRepository chapterRepository;
  @Autowired
  ContentRepository contentTextRepository;

  @Override
  public Chapter getChapterById(long id) {
    return chapterRepository.findChapterById(id);
  }

  @Override
  public String getContentByChapterId(long cid) {

    Content content = contentTextRepository.findContentByChapterId(cid);
    if (null == content) {
      return "未知章节："+cid;
    }
    return content.getContent();
  }


}
