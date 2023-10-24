package com.anime.pagina.EntitiesTest;


import com.anime.pagina.Entities.Chapter;
import com.anime.pagina.Entities.Serie;
import com.anime.pagina.Service.ChaptersService;
import com.anime.pagina.Service.SeriesService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ChapterTest {

    @Autowired
    private ChaptersService chaptersService;
    @Autowired
    private SeriesService seriesService;

    @Test
    @DisplayName("Test for verify that Chapter can be created and found in the database.")
    public void testCreateAndFindChapters() {
        //Creating a chapter for our database.
        Chapter chapter = new Chapter();
        chapter.setTitle("Capitulo 01");
        chapter.setSerieTitle("Jujutsu Kaisen");
        chapter.getVideoPlayers().add("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        chapter.getVideoPlayers().add("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        chapter.getVideoPlayers().add("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        Chapter savedChapter = chaptersService.createChapter(chapter);
        Chapter foundChapter = chaptersService.findChapterById(savedChapter.getId());
        //Checking results.
        assertNotNull(savedChapter.getId());
        assertNotNull(foundChapter);
        assertEquals("Capitulo 01", foundChapter.getTitle());
    }
    @Test
    @DisplayName("Test for verify that Series can be created and found in the database.")
    public void testCreateAndFindSeries() {
        //Creating a serie for our database.
        Serie serie = new Serie();
        serie.setTitle("Jujutsu Kaisen");
        serie.setDescription("Buen anime, recomendado");
        List<String> videoPlayers = new ArrayList<>();
        videoPlayers.add("https://www.youtube.com/watch?v=eoJEn7MDht0");
        videoPlayers.add("https://www.youtube.com/watch?v=eoJEn7MDht0");
        Chapter capitulo = new Chapter(null, "Capitulo 1", "Jujutsu Kaisen",
                null,videoPlayers);
        serie.getChapters().add(capitulo);
        serie.setImage("https://pbs.twimg.com/media/FEzof1vVUAkEqp_?format=jpg&name=medium");
        serie.getGender().add("Accion");
        serie.getGender().add("Comedia");
        serie.getGender().add("Drama");
        Serie savedSerie = seriesService.createSerie(serie);
        Serie foundSerie = seriesService.findSerieById(savedSerie.getId());
        //Checking results.
        assertNotNull(savedSerie.getId());
        assertNotNull(foundSerie);
        assertEquals("Jujutsu Kaisen", foundSerie.getTitle());
    }

    @Test
    @DisplayName("Test for verify that Series can be find by its title and gender.")
    public void testFindSeriesByTitleAndGender() {
        //Creating a serie for our database.
        Serie serie = new Serie();
        serie.setTitle("Jujutsu Kaisen");
        serie.setDescription("Buen anime, recomendado");
        List<String> videoPlayers = new ArrayList<>();
        videoPlayers.add("https://www.youtube.com/watch?v=eoJEn7MDht0");
        videoPlayers.add("https://www.youtube.com/watch?v=eoJEn7MDht0");
        Chapter capitulo = new Chapter(null, "Capitulo 1", "Jujutsu Kaisen",
                null,videoPlayers);
        serie.getChapters().add(capitulo);
        serie.setImage("https://pbs.twimg.com/media/FEzof1vVUAkEqp_?format=jpg&name=medium");
        serie.getGender().add("Action");
        serie.getGender().add("Comedy");
        serie.getGender().add("Drama");
        seriesService.createSerie(serie);
        List<Serie> series = seriesService.findAllSeriesByGender("Action");
        assertNotNull(series);
        //Checking results.
        assertEquals(1, series.size());
        assertEquals("Jujutsu Kaisen", series.get(0).getTitle());
    }

    @Test
    @DisplayName("Update a serie adding a chapter.")
    public void testUpdateSerie() {
        //Creating a serie for database.
        Serie serie = new Serie();
        serie.setTitle("Jujutsu Kaisen");
        serie.setDescription("Buen anime, recomendado");
        List<String> videoPlayers = new ArrayList<>();
        videoPlayers.add("https://www.youtube.com/watch?v=eoJEn7MDht0");
        videoPlayers.add("https://www.youtube.com/watch?v=eoJEn7MDht0");
        Chapter capitulo = new Chapter(null, "Capitulo 1", "Jujutsu Kaisen",
                null,videoPlayers);
        serie.getChapters().add(capitulo);
        serie.setImage("https://pbs.twimg.com/media/FEzof1vVUAkEqp_?format=jpg&name=medium");
        serie.getGender().add("Action");
        serie.getGender().add("Comedy");
        serie.getGender().add("Drama");
        //Updating serie with a new chapter.
        Serie savedSerie = seriesService.createSerie(serie);
        List<String> videoPlayers2 = new ArrayList<>();
        videoPlayers.add("https://www.youtube.com/watch?v=eoJEn7MDht0");
        videoPlayers.add("https://www.youtube.com/watch?v=eoJEn7MDht0");
        savedSerie.getChapters().add(new Chapter("Capitulo 2", "Jujutsu Kaisen",videoPlayers2));
        seriesService.updateSerie(savedSerie, savedSerie.getId());
        //Checking results.
        assertEquals(2, seriesService.findSerieById(savedSerie.getId()).getChapters().size());
    }
}
