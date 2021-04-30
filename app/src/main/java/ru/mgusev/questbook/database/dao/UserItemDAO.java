package ru.mgusev.questbook.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import ru.mgusev.questbook.model.UserItem;

@Dao
public interface UserItemDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<UserItem> list);

    @Insert()
    void delete(List<UserItem> list);

    @Query("SELECT * FROM user_items WHERE game_id = :gameId")
    List<UserItem> getUserItems(long gameId);

    @Query("SELECT * FROM user_items WHERE game_id = :gameId AND item_id = :itemId LIMIT 1")
    UserItem getUserItem(long gameId, int itemId);

    @Query("SELECT * FROM user_items WHERE game_id = :gameId AND count > 0")
    List<UserItem> getUserInventory(long gameId);
}
