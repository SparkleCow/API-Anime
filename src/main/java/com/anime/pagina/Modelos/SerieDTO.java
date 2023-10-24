package com.anime.pagina.Modelos;

import java.util.List;

public record SerieDTO(String title,
                       String description,
                       String image,
                       List<String> gender) {
}
