package zach1590.game_sales.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletContext;
import zach1590.game_sales.models.Image;
import zach1590.game_sales.services.ImageService;

@RestController
@RequestMapping(path="/api/v1/images")
@CrossOrigin(origins="*")
public class ImageController {

    @Autowired
    private ServletContext context;
    
    @Autowired
    private ImageService imageService;

    @GetMapping(value = "/bytitle/{titleId}")
    public ResponseEntity<List<Image>> getImagesByTitleId(@PathVariable long titleId) {
        return new ResponseEntity<List<Image>>(
            imageService.getImagesByTitleId(titleId), 
            HttpStatus.OK
        );
    }

    @GetMapping(value = "/{imageId}")
    public ResponseEntity<byte[]> getImageById(@PathVariable long imageId) throws IOException {

        String imageName = imageService.getImageById(imageId);
        String imagePath = context.getRealPath("/game_images/" + imageName);
        Path path = new File(imagePath).toPath();

        var imgFile = new ClassPathResource("/game_images/" + imageName);
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(Files.probeContentType(path)))
                .body(bytes);
    }

    @GetMapping(value = "/byname/{imageName}")
    public ResponseEntity<byte[]> getImageByName(@PathVariable String imageName) throws IOException {

        String imagePath = context.getRealPath("/game_images/" + imageName);
        Path path = new File(imagePath).toPath();

        var imgFile = new ClassPathResource("/game_images/" + imageName);
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(Files.probeContentType(path)))
                .body(bytes);
    }
}
