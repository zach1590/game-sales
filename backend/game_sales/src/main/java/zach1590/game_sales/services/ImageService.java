package zach1590.game_sales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zach1590.game_sales.models.Image;
import zach1590.game_sales.repositories.ImageRepository;

@Service
public class ImageService {
    
    @Autowired
    private ImageRepository imageRepository;

    public List<Image> getImagesByTitleId(long titleId) {
        return imageRepository.findImagesByTitleId(titleId);
    }

    public String getImageById(long imageId) {
        Image gameImage = imageRepository.findImageById(imageId);
        return gameImage.getImageName();
    }
}
