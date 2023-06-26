package zach1590.game_sales.models;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bestselling")
public class Game {
    
    @Id
    @Column(name="titleid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long titleId;

    @Column(name="titlename", columnDefinition="TEXT")
    private String titleName;

    @Column(name="sales")
    private long sales;

    @Column(name="series", columnDefinition="TEXT")
    private String series;

    @Column(name="platform", columnDefinition="TEXT")
    private String platform;

    @Column(name="initialreleasedate", columnDefinition="DATE")
    private Date initialReleaseDate;

    @Column(name="developer", columnDefinition="TEXT")
    private String developer;

    @Column(name="publisher", columnDefinition="TEXT")
    private String publisher;

    @Column(name="artwork", columnDefinition="TEXT")
    private String artwork;

    @Column(name="video", columnDefinition="TEXT")
    private String video;

    @Column(name="summary", columnDefinition="TEXT")
    private String summary;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name="titleid")
    private Set<Genre> genres;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name="titleid")
    private Set<Image> images;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name="titleid")
    private Set<Review> reviews;

    public Game(String titleName,
                long sales,
                String series,
                String platform,
                Date initialReleaseDate,
                String developer,
                String publisher,
                String artwork,
                String video,
                String summary
    ) {
        this.titleName = titleName;
        this.sales = sales;
        this.series = series;
        this.platform = platform;
        this.initialReleaseDate = initialReleaseDate;
        this.developer = developer;
        this.publisher = publisher;
        this.artwork = artwork;
        this.video = video;
        this.summary = summary;
    }
}
