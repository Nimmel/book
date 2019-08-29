package com.readbooker.website.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.readbooker.website.model.entity.Book;
import com.readbooker.website.model.entity.Label;
import com.readbooker.website.model.vo.BookVo;
import com.readbooker.website.repository.BookRepository;
import com.readbooker.website.repository.LabelRepository;
import com.readbooker.website.service.BookService;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private LabelRepository labelRepository;

  @Override
  public Book findBookById(Long id) {
    return bookRepository.getOne(id);
  }

  @Override
  public Page<Book> findTopsClickBooks(String label,Integer num) {
    return bookRepository.findByOrderByClicksDesc(PageRequest.of(0,num));

  }

  @Override
  public Page<Book> findTopsRecommendBooks(String label,Integer num) {
    return bookRepository.findByOrderByRecommendsDesc(PageRequest.of(0,num));
  }

  @Override
  public BookVo convertTo(Book book) {
    Assert.notNull(book, "Journal must not be null");
    BookVo bv = new BookVo().convertFrom(book);
    // 关联id的内容
    List<Label> labels = labelRepository.findAllByBookIdOrderByFlagAsc(bv.getId());
    if(CollectionUtil.isNotEmpty(labels)){
      bv.setCategory(labels.get(0));
      bv.setLabels(labels);
    }
    return bv;

  }

  @Override
  public List<BookVo> convertToList(List<Book> books) {
    Assert.notNull(books, "books must not be null");
    List<BookVo> bookVos = new LinkedList<>();
    for (Book book : books) {
      bookVos.add(convertTo(book));
    }
    return bookVos;
  }

}
