package zach1590.game_sales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zach1590.game_sales.models.Game;
import zach1590.game_sales.models.Review;
import zach1590.game_sales.pojos.AddReviewRequest;
import zach1590.game_sales.repositories.GameRepository;
import zach1590.game_sales.repositories.ReviewRepository;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private GameRepository gameRepository;

    public List<Review> getReviewsByTitleId(long titleId) {
        return reviewRepository.findReviewsByTitleId(titleId);
    }

    public Review addReview(AddReviewRequest reviewReq) {
        Game reviewGame = gameRepository.findById(reviewReq.getTitleId()).get();
        Review review = new Review();

        review.setReviewBody(reviewReq.getReviewBody());
        review.setGame(reviewGame);

        return reviewRepository.save(review);
    }
}
