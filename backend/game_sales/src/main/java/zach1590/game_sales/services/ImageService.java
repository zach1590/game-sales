package zach1590.game_sales.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zach1590.game_sales.models.Game;
import zach1590.game_sales.models.Image;
import zach1590.game_sales.pojos.AddImageRequest;
import zach1590.game_sales.repositories.GameRepository;
import zach1590.game_sales.repositories.ImageRepository;

@Service
public class ImageService {
    
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private GameRepository gameRepository;

    public List<Image> getImagesByTitleId(long titleId) {
        return imageRepository.findImagesByTitleId(titleId);
    }

    public String getImageById(long imageId) {
        Image gameImage = imageRepository.findImageById(imageId);
        return gameImage.getImageName();
    }

    public Image addImage(AddImageRequest imageReq) {
        Game imageGame = gameRepository.findById(imageReq.getTitleId()).get();
        Image image = new Image();

        image.setImageName(imageReq.getImageName());
        image.setGame(imageGame);

        return imageRepository.save(image);
    }

    public String determineImageName(long titleId) {
        // long count = imageRepository.findNumImages(titleId) + 1;
        Game imageGame = gameRepository.findById(titleId).get();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        return imageGame.getSeries() + timestamp.getTime();
    }
}
