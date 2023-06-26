package zach1590.game_sales.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="genres")
public class Genre {
    @Id
    @Column(name="genreid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long genreId;

    @Column(name="genre", columnDefinition="TEXT")
    private String genre;

    @ManyToOne
    @JoinColumn(name="titleid")
    private Game game;

}
