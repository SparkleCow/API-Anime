package com.anime.pagina.Service;

import com.anime.pagina.Entities.Serie;
import com.anime.pagina.Modelos.SerieDTO;
import com.anime.pagina.Repository.SeriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesServiceImp implements SeriesService {
    private SeriesRepository seriesRepository;
    public SeriesServiceImp(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public List<Serie> findAllSeries() {
        return seriesRepository.findAll();
    }

    @Override
    public List<SerieDTO> findAllSeriesDTO() {
        return seriesRepository.findAll().stream().map(x->new SerieDTO(x.getTitle(),x.getDescription(),x.getImage(),x.getGender())).toList();
    }

    @Override
    public List<Serie> findAllSeriesByGender(String gender) {
        return seriesRepository.findByGender(gender);
    }

    @Override
    public Serie findSerieById(Long id) {
        Optional<Serie> optionalSerie= seriesRepository.findById(id);
        return optionalSerie.orElse(null);
    }

    @Override
    public Serie findByTitle(String title) {
        return seriesRepository.findByTitle(title);
    }

    @Override
    public Serie createSerie(Serie serie) {
        return seriesRepository.save(serie);
    }

    @Override
    public Serie updateSerie(Serie serie, Long id) {
        Optional<Serie> optionalSerie = seriesRepository.findById(id);
        if (optionalSerie.isPresent()) {
            serie.setId(id);
            return seriesRepository.save(serie);
        }
        return null;
    }

    @Override
    public Serie deleteSerie(Long id) {
        Optional<Serie> optionalSerie = seriesRepository.findById(id);
        if (optionalSerie.isPresent()) {
            seriesRepository.deleteById(id);
            return optionalSerie.get();
        }
        return null;
    }
}
