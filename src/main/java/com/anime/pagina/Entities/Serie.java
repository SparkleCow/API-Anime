package com.anime.pagina.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    private String description;
    @Column(name = "image", nullable = false)
    private String image;
    @ElementCollection
    private List<String> gender = new ArrayList<String>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="chapters_series", joinColumns = @JoinColumn(name = "serie_id"),
            inverseJoinColumns = @JoinColumn(name = "chapter_id"))
    private List<Chapter> chapters = new ArrayList<Chapter>();
}