package ru.mgusev.questbook.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import ru.mgusev.questbook.model.Option;

@Dao
public interface OptionDAO {

    @Query("SELECT * FROM options WHERE parent_episode_id = :episodeId")
    List<Option> getOptionList(int episodeId);

    @Query("SELECt * FROM options WHERE _id = :id")
    Option getOptionById(int id);
}
