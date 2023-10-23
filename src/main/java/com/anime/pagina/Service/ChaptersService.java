package com.anime.pagina.Service;

import com.anime.pagina.Entities.Chapters;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ChaptersService {

    List<Chapters> findAllChapters();
    Chapters findChaptersById(Long id);
    Chapters createChapters(Chapters chapters);
    Chapters updateChapters(Chapters chapters, Long id);
    Chapters deleteChapters(Long id);
}
