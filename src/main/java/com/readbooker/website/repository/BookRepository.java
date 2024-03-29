package com.readbooker.website.repository;

import com.readbooker.website.model.entity.Book;
import com.readbooker.website.model.entity.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

//  @Query("这里写正常的SQL语句")
//  List<Book> findAllOrderByClicksDesc(Pageable pagable);
    Page<Book> findByOrderByRecommendsDesc(Pageable pagable);
    // 根据点击量倒排
    Page<Book> findByOrderByClicksDesc(Pageable pagable);
    // 根据更新时间倒排
    Page<Book> findByOrderByUpdateTimeDesc(Pageable pagable);
    // 根据入库时间排序
    Page<Book> findByOrderByCreateTimeDesc(Pageable pagable);

}
