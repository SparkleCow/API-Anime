package com.anime.pagina.Service;

import com.anime.pagina.Entities.Chapter;
import com.anime.pagina.Repository.ChaptersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChaptersServiceImp implements ChaptersService {
    private ChaptersRepository chaptersRepository;

    public ChaptersServiceImp(ChaptersRepository chaptersRepository) {
        this.chaptersRepository = chaptersRepository;
    }

    @Override
    public List<Chapter> findAllChapters() {
        return chaptersRepository.findAll();
    }

    @Override
    public Chapter findChapterById(Long id) {
        Optional<Chapter> optionalChapters = chaptersRepository.findById(id);
        return optionalChapters.orElse(null);
    }

    @Override
    public Chapter createChapter(Chapter chapter) {
        return chaptersRepository.save(chapter);
    }

    @Override
    public Chapter updateChapter(Chapter chapter, Long id) {
        Optional<Chapter> optionalChapters = chaptersRepository.findById(id);
        if (optionalChapters.isPresent()) {
            chapter.setId(id);
            return chaptersRepository.save(chapter);
        }
        return null;
    }

    @Override
    public Chapter deleteChapter(Long id) {
        Optional<Chapter> optionalChapters = chaptersRepository.findById(id);
        if (optionalChapters.isPresent()) {
            chaptersRepository.deleteById(id);
            return optionalChapters.get();
        }
        return null;
    }
}
