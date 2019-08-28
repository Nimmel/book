package com.readbooker.website.service;

import com.readbooker.website.model.entity.Book;
import java.util.List;

public interface BookService {
  Book findBookById(long id);
  // 点击量前十
  List<Book> findTopsClickBooks(String label,int num);
  // 推荐量前十
  List<Book> findTopsRecommentBooks(String label,int num);

}
