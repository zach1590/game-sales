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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="images")
public class Image {
    @Id
    @Column(name="imageid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long imageId;

    @Column(name="imagename", columnDefinition="TEXT")
    private String imageName;   // Filepath

    @ManyToOne
    @JoinColumn(name="titleid")
    @JsonIgnore
    private Game game;

}
