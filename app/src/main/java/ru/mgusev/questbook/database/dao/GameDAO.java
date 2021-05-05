package ru.mgusev.questbook.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import ru.mgusev.questbook.model.Game;

@Dao
public interface GameDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Game game);

    @Delete()
    void delete(Game game);

    @Query("SELECT * FROM games WHERE complete = 0 LIMIT 1")
    Game getNoCompleteGame();

    @Query("SELECT * FROM games WHERE complete = 0")
    List<Game> getNoCompleteGames();
}
