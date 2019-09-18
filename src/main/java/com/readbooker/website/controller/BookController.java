package com.readbooker.website.controller;

import com.readbooker.website.model.entity.Book;
import com.readbooker.website.model.entity.Chapter;
import com.readbooker.website.model.vo.ChapterVo;
import com.readbooker.website.model.vo.ResultInfo;
import com.readbooker.website.service.BookService;
import com.readbooker.website.service.ChapterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class BookController {
  @Autowired
  private BookService bookService;
  @Autowired
  private ChapterService chapterService;
  // 目录
  @RequestMapping("/book/{id}")
  public String catalogure(Model model,@PathVariable long id){
    // 获取书籍信息
    Book book = bookService.findBookById(id);
    model.addAttribute("book",bookService.convertVo(book));
    return "catalogue";
  }

  @RequestMapping("/book")
  public String chapterContent(Model model,long bid,long cid){
    // 获取书籍信息
    Book book = bookService.findBookById(bid);
    model.addAttribute("book",bookService.convertVo(book));
    Chapter chapter = chapterService.getChapterById(cid);
    ChapterVo cvo = new ChapterVo().convertFrom(chapter);
    cvo.setContent(chapterService.getContentByChapterId(cid));
    model.addAttribute("chapter",cvo);
    return "content";
  }


  //@PathVariable long bookId
  @RequestMapping("/book/lastUpdate")
  public ResultInfo lastUpdate() {



    return null;
  }


}
