package zach1590.game_sales.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zach1590.game_sales.models.Game;
import zach1590.game_sales.services.GameService;

@RestController
@RequestMapping(path="/api/v1/games")
@CrossOrigin(origins="*")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> getGamesList() {
        return new ResponseEntity<List<Game>>(
            gameService.getGamesList(),
            HttpStatus.OK
        );
    }

    @GetMapping("/{titleId}")
    public ResponseEntity<Optional<Game>> getSingleMovie(@PathVariable long titleId) {
        return new ResponseEntity<Optional<Game>>(
            gameService.getSingleGame(titleId), 
            HttpStatus.OK
        );
    }

    @GetMapping("/top")
    public ResponseEntity<List<Game>> getTop10() {
        return new ResponseEntity<List<Game>>(
            gameService.getTop10(),
            HttpStatus.OK
        );
    }
}
