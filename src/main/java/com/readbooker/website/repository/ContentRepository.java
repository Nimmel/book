package com.readbooker.website.repository;

import com.readbooker.website.model.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
    Content findContentByChapterId(long chapterId);
}
