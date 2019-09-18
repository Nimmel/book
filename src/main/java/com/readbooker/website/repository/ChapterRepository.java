package com.readbooker.website.repository;

import com.readbooker.website.model.entity.Book;
import com.readbooker.website.model.entity.Chapter;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
  List<Chapter> findByBookIdOrderByIdAsc(Long bookId);

  Chapter findChapterById(long id);
}
