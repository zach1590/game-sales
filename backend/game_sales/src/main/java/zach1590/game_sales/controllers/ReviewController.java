package zach1590.game_sales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zach1590.game_sales.models.Review;
import zach1590.game_sales.pojos.AddReviewRequest;
import zach1590.game_sales.services.ReviewService;

@RestController
@RequestMapping(path="/api/v1/reviews")
@CrossOrigin(origins="*")
public class ReviewController {
    
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/bytitle/{titleId}")
    public ResponseEntity<List<Review>> getReviewsByTitleId(@PathVariable long titleId) {
        return new ResponseEntity<List<Review>>(
            reviewService.getReviewsByTitleId(titleId), 
            HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody AddReviewRequest reviewReq) {
        return new ResponseEntity<Review>(
            reviewService.addReview(reviewReq), 
            HttpStatus.OK
        );
    }
}
