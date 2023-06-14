package zach1590.game_sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import zach1590.game_sales.models.Genre;
import zach1590.game_sales.pojos.GetGameGenreResponse;

import java.util.List;


public interface GenreRepository extends JpaRepository<Genre, Long>{

    @Query(value = "SELECT DISTINCT genre FROM genres", nativeQuery = true)
    List<GetGameGenreResponse> findGenres();

    @Query(value = "SELECT genre FROM genres WHERE titleid = ?1", nativeQuery = true)
    List<GetGameGenreResponse> findGenresByTitleId(long titleid);

    @Query(value = "SELECT * FROM genres WHERE genre = ?1", nativeQuery = true)
    List<Genre> findGamesByGenre(String gameGenre);
}
