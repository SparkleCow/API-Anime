package com.anime.pagina.Modelos;

import java.util.List;

public record ChapterDTO(String title,
                         String serieTitle,
                         List<String> videoPlayers,
                         Integer views) {
}
