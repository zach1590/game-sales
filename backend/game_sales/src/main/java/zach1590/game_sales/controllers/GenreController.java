package zach1590.game_sales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zach1590.game_sales.models.Genre;
import zach1590.game_sales.services.GenreService;

@RestController
@RequestMapping(path="/api/v1/genres")
@CrossOrigin(origins="*")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public ResponseEntity<List<String>> getGenres() {
        return new ResponseEntity<List<String>>(
            genreService.getGenres(), 
            HttpStatus.OK
        );
    }

    @GetMapping("/bytitle/{titleId}")
    public ResponseEntity<List<String>> getGenresByTitleId(@PathVariable long titleId) {
        return new ResponseEntity<List<String>>(
            genreService.getGenresByTitleId(titleId), 
            HttpStatus.OK
        );
    }

    @GetMapping("/{gameGenre}")
    public ResponseEntity<List<Genre>> getGenresByTitleId(@PathVariable String gameGenre) {
        return new ResponseEntity<List<Genre>>(
            genreService.getGamesByGenre(gameGenre), 
            HttpStatus.OK
        );
    }
}
