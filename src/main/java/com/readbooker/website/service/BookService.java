package com.readbooker.website.service;

import com.readbooker.website.model.entity.Book;
import java.util.List;
import org.springframework.data.domain.Page;

public interface BookService {
  Book findBookById(Long id);
  // 点击量前十
  Page<Book> findTopsClickBooks(String label,Integer num);
  // 推荐量前十
  Page<Book> findTopsRecommendBooks(String label,Integer num);

}
