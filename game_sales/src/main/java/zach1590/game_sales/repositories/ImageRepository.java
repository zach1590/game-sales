package zach1590.game_sales.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import zach1590.game_sales.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{
    @Query(value = "SELECT * FROM images WHERE titleid = ?1", nativeQuery = true)
    List<Image> findImagesByTitleId(long titleid);

    @Query(value = "SELECT * FROM images WHERE imageid = ?1", nativeQuery = true)
    Image findImageById(long imageid);

    @Query(value = "SELECT COUNT(i) FROM images i WHERE titleid = ?1", nativeQuery = true)
    long findNumImages(long titleid);
}
