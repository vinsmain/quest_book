package ru.mgusev.questbook.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import ru.mgusev.questbook.model.Episode;

@Dao
public interface EpisodeDAO {

    @Query("SELECT * FROM episodes WHERE _id = :id LIMIT 1")
    Episode getEpisode(int id);
}