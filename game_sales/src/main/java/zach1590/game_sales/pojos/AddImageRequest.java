package zach1590.game_sales.pojos;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AddImageRequest {
    long titleId;
    String imageName;
    MultipartFile imageFile;

    public AddImageRequest(long titleId, String imageName, MultipartFile file){
        this.titleId = titleId;
        this.imageName = imageName;
        this.imageFile = file;
    }
}
