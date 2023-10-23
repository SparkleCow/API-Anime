package com.anime.pagina.Service;

import com.anime.pagina.Entities.Chapters;
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
    public List<Chapters> findAllChapters() {
        return chaptersRepository.findAll();
    }

    @Override
    public Chapters findChaptersById(Long id) {
        Optional<Chapters> optionalChapters = chaptersRepository.findById(id);
        return optionalChapters.orElse(null);
    }

    @Override
    public Chapters createChapters(Chapters chapters) {
        return chaptersRepository.save(chapters);
    }

    @Override
    public Chapters updateChapters(Chapters chapters, Long id) {
        Optional<Chapters> optionalChapters = chaptersRepository.findById(id);
        if (optionalChapters.isPresent()) {
            chapters.setId(id);
            return chaptersRepository.save(chapters);
        }
        return null;
    }

    @Override
    public Chapters deleteChapters(Long id) {
        Optional<Chapters> optionalChapters = chaptersRepository.findById(id);
        if (optionalChapters.isPresent()) {
            chaptersRepository.deleteById(id);
            return optionalChapters.get();
        }
        return null;
    }
}
