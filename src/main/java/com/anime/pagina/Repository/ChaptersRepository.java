package com.anime.pagina.Repository;

import com.anime.pagina.Entities.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChaptersRepository extends JpaRepository<Chapter, Long> {
}
