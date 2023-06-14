package zach1590.game_sales.pojos;

import lombok.Data;

@Data
public class AddReviewRequest {
    private String reviewBody;
    private long titleId;
}
