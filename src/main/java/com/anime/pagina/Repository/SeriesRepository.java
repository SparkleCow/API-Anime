package com.anime.pagina.Repository;

import com.anime.pagina.Entities.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SeriesRepository extends JpaRepository<Serie, Long> {
    @Query("SELECT s FROM Serie s WHERE :searchGender MEMBER OF s.gender")
    List<Serie> findByGender(@Param("searchGender") String searchGender);
    Serie findByTitle (String title);
}
