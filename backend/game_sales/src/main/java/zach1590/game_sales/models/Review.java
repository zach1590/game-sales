package zach1590.game_sales.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="reviews")
public class Review {
    @Id
    @Column(name="reviewid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long reviewId;

    @Column(name="review", columnDefinition="TEXT")
    private String reviewBody;

    @ManyToOne
    @JoinColumn(name="titleid")
    @JsonIgnore
    private Game game;

}
