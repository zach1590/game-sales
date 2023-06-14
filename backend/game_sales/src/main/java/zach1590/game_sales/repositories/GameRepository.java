package zach1590.game_sales.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import zach1590.game_sales.models.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Query(value = "SELECT * FROM bestselling ORDER BY sales DESC limit 10", 
            nativeQuery = true
    )
    List<Game> FindTop10Selling();
}
