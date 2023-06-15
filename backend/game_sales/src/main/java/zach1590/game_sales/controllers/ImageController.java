package zach1590.game_sales.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import zach1590.game_sales.models.Image;
import zach1590.game_sales.pojos.AddImageRequest;
import zach1590.game_sales.services.ImageService;

@RestController
@RequestMapping(path="/api/v1/images")
@CrossOrigin(origins="*")
public class ImageController {
    
    @Autowired
    private ImageService imageService;

    @Value("${IMAGE_FOLDER}")
    private String IMAGE_FOLDER;

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
        File imgFilePath = new File(IMAGE_FOLDER + imageName);
        Path path = imgFilePath.toPath();

        FileInputStream input = new FileInputStream(imgFilePath);
        byte[] bytes = StreamUtils.copyToByteArray(input);

        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(Files.probeContentType(path)))
                .body(bytes);
    }

    @GetMapping(value = "/byname/{imageName}")
    public ResponseEntity<byte[]> getImageByName(@PathVariable String imageName) throws IOException {

        File imgFilePath = new File(IMAGE_FOLDER + imageName);
        Path path = imgFilePath.toPath();

        FileInputStream input = new FileInputStream(imgFilePath);
        byte[] bytes = StreamUtils.copyToByteArray(input);

        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(Files.probeContentType(path)))
                .body(bytes);
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<Image> uploadImage(
        @RequestParam("imageName") String reqImageName,
        @RequestParam("image") MultipartFile imgFile,
        @RequestParam("titleId") long titleid
        ) throws IOException {
        
        String imageName = imageService.determineImageName(titleid) + getExtension(reqImageName);
        File imgFilePath = new File(IMAGE_FOLDER + imageName);
        imgFilePath.createNewFile();

        FileOutputStream output = new FileOutputStream(imgFilePath);
        output.write(imgFile.getBytes());
        output.close();

        AddImageRequest imageReq = new AddImageRequest(titleid, imageName, imgFile);
        return new ResponseEntity<Image>(
            imageService.addImage(imageReq), 
            HttpStatus.OK
        );
    }

    private String getExtension(String fileName) {
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i);
        }

        return extension;
    }
}
