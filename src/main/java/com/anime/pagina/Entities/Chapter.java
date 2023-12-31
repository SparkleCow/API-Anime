package com.anime.pagina.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "chapters")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false,  length = 100)
    private String title;
    @Column(name = "serie_title", nullable = false,  length = 100)
    private String serieTitle;
    private Integer views = 0;
    @Column(name = "video_players")
    @ElementCollection
    private List<String> videoPlayers = new ArrayList<String>();

    public Chapter(String title, String serieTitle, List<String> videoPlayers) {
        this.title = title;
        this.serieTitle = serieTitle;
        this.videoPlayers = videoPlayers;
        this.views = 0;
    }

    public void viewCount(){
        this.views++;
    }
}
