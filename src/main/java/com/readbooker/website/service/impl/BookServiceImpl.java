package com.readbooker.website.service.impl;

import com.readbooker.website.model.entity.Book;
import com.readbooker.website.repository.BookRepository;
import com.readbooker.website.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;

  @Override
  public Book findBookById(long id) {
    return bookRepository.getOne(id);
  }

  @Override
  public List<Book> findTopsClickBooks(String label,int num) {
    return bookRepository.findAllOrderByClicksDesc(PageRequest.of(0,num));
  }

  @Override
  public List<Book> findTopsRecommentBooks(String label,int num) {
    return bookRepository.findAllOrderByRecommendsDesc(PageRequest.of(0,num));
  }
}
