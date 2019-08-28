package com.readbooker.website.service.impl;

import com.readbooker.website.model.entity.Book;
import com.readbooker.website.repository.BookRepository;
import com.readbooker.website.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;

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

}
