package com.anime.pagina.Controllers;

import com.anime.pagina.Entities.Serie;
import com.anime.pagina.Modelos.SerieDTO;
import com.anime.pagina.Service.ChaptersService;
import com.anime.pagina.Service.SeriesServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SeriesController {

    private ChaptersService chaptersService;
    private SeriesServiceImp seriesService;
    public SeriesController(ChaptersService chaptersService, SeriesServiceImp seriesService){
        this.chaptersService = chaptersService;
        this.seriesService = seriesService;
    }

    @GetMapping()
    public ResponseEntity<List<SerieDTO>> findAllSeriesDTO(){
        return ResponseEntity.ok(seriesService.findAllSeriesDTO());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Serie>> findAllSeries(){
        return ResponseEntity.ok(seriesService.findAllSeries());
    }



    @GetMapping("pollo")
    public ResponseEntity<Serie> findSerieByTitle(@PathVariable String title){
        return ResponseEntity.ok(seriesService.findByTitle(title));
    }
}
