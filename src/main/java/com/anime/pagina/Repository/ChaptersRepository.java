package com.anime.pagina.Repository;

import com.anime.pagina.Entities.Chapters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChaptersRepository extends JpaRepository<Chapters, Long> {
}
