package com.readbooker.website.service;

import com.readbooker.website.model.entity.Book;
import com.readbooker.website.model.vo.BookVo;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;

public interface BookService {
  Book findBookById(Long id);
  // 点击量前十
  Page<Book> findTopsClickBooks(String label,Integer num);
  // 推荐量前十
  Page<Book> findTopsRecommendBooks(String label,Integer num);

  Page<Book> findLastUpdateBooks(Integer num);

  Page<Book> findLastImportBooks(Integer num);

  @NonNull
  BookVo convertVo(@NonNull Book book);

  @NonNull
  List<BookVo> convertVos(@NonNull List<Book> book);




}
