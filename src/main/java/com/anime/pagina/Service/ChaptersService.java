package com.anime.pagina.Service;

import com.anime.pagina.Entities.Chapter;

import java.util.List;

public interface ChaptersService {

    List<Chapter> findAllChapters();
    Chapter findChapterById(Long id);
    Chapter createChapter(Chapter chapter);
    Chapter updateChapter(Chapter chapter, Long id);
    Chapter deleteChapter(Long id);
}
