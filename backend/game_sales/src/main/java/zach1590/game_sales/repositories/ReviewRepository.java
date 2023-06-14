package zach1590.game_sales.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import zach1590.game_sales.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    @Query(value = "SELECT * FROM reviews WHERE titleid = ?1", nativeQuery = true)
    List<Review> findReviewsByTitleId(long titleId);
}
