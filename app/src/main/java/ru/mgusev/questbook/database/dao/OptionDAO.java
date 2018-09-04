package ru.mgusev.questbook.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import ru.mgusev.questbook.model.Option;

@Dao
public interface OptionDAO {

    @Query("SELECT * FROM options WHERE parent_episode_id = :episodeId")
    List<Option> getOptionList(int episodeId);
}
