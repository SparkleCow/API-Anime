package com.anime.pagina.ChaptersTest;


import com.anime.pagina.Entities.Chapters;
import com.anime.pagina.Service.ChaptersService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ChaptersTest {

    @Autowired
    private ChaptersService chaptersService;

    @Test
    @DisplayName("Test for verify that Chapters can be created and found in the database.")
    public void testCreateAndFindChapters() {
        //Creating a chapter for our database.
        Chapters chapters = new Chapters();
        chapters.setTitle("Capitulo 01");
        chapters.setSerieTitle("Jujutsu Kaisen");
        chapters.getVideoPlayers().add("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        chapters.getVideoPlayers().add("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        chapters.getVideoPlayers().add("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        Chapters savedChapters = chaptersService.createChapters(chapters);
        Chapters foundChapters = chaptersService.findChaptersById(savedChapters.getId());
        //Checking results.
        assertNotNull(savedChapters.getId());
        assertNotNull(foundChapters);
        assertEquals("Capitulo 01", foundChapters.getTitle());
    }
}
