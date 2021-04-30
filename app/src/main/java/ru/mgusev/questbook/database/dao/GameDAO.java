package ru.mgusev.questbook.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

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
