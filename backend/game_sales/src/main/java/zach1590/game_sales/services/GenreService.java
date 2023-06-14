package zach1590.game_sales.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zach1590.game_sales.models.Genre;
import zach1590.game_sales.pojos.GetGameGenreResponse;
import zach1590.game_sales.repositories.GenreRepository;

@Service
public class GenreService {
    
    @Autowired
    private GenreRepository genreRepository;

    public List<String> getGenres() {
        List<GetGameGenreResponse> titleGenres = genreRepository.findGenres();
        List<String> genres = new ArrayList<String>();

        for (GetGameGenreResponse temp: titleGenres) {
            genres.add(temp.getGenre());
        }
        
        return genres;
    }

    public List<String> getGenresByTitleId(long titleId) {
        List<GetGameGenreResponse> titleGenres = genreRepository.findGenresByTitleId(titleId);
        List<String> genres = new ArrayList<String>();

        for (GetGameGenreResponse temp: titleGenres) {
            genres.add(temp.getGenre());
        }

        return genres;
    }

    public List<Genre> getGamesByGenre(String gameGenre) {
        return genreRepository.findGamesByGenre(gameGenre);
    }
    
}
