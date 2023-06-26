package zach1590.game_sales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zach1590.game_sales.models.Game;
import zach1590.game_sales.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    public List<Game> getGamesList() {
        return gameRepository.findAll();
    }

    public Optional<Game> getSingleGame(long titleId) {
        return gameRepository.findById(titleId);
    }

    public List<Game> getTop10() {
        return gameRepository.FindTop10Selling();
    }
}
