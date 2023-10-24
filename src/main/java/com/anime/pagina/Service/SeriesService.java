package com.anime.pagina.Service;

import com.anime.pagina.Entities.Serie;
import com.anime.pagina.Modelos.SerieDTO;
import java.util.List;

public interface SeriesService {
    List<Serie> findAllSeries();
    List<SerieDTO> findAllSeriesDTO();
    List<Serie> findAllSeriesByGender(String gender);
    Serie findSerieById(Long id);
    Serie findByTitle(String title);
    Serie createSerie(Serie serie);
    Serie updateSerie(Serie serie, Long id);
    Serie deleteSerie(Long id);
}
