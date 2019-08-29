package com.readbooker.website.repository;

import com.readbooker.website.model.entity.Label;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label, Long> {

  List<Label> findAllByBookId(long id);

  List<Label> findAllByBookIdOrderByFlagAsc(long id);

}
