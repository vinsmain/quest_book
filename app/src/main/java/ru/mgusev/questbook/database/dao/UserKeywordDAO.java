package ru.mgusev.questbook.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import ru.mgusev.questbook.model.UserKeyword;

@Dao
public interface UserKeywordDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<UserKeyword> list);

    @Insert()
    void delete(List<UserKeyword> list);

    @Query("SELECT * FROM user_keywords WHERE game_id = :gameId")
    List<UserKeyword> getUserKeywords(long gameId);

    @Query("SELECT * FROM user_keywords WHERE game_id = :gameId AND keyword_id = :keywordId LIMIT 1")
    UserKeyword getUserKeyword(long gameId, int keywordId);
}
