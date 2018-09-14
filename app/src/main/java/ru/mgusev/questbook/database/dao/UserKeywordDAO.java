package ru.mgusev.questbook.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import ru.mgusev.questbook.model.UserKeyword;

@Dao
public interface UserKeywordDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<UserKeyword> list);

    @Query("SELECT * FROM user_keywords WHERE game_id = :gameId")
    List<UserKeyword> getUserKeywords(long gameId);

    @Query("SELECT * FROM user_keywords WHERE game_id = :gameId AND keyword_id = :keywordId LIMIT 1")
    UserKeyword getUserKeyword(long gameId, int keywordId);
}
