package ru.mgusev.questbook.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import ru.mgusev.questbook.model.UserCharacteristic;

@Dao
public interface UserCharacteristicDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<UserCharacteristic> list);

    @Insert()
    void delete(List<UserCharacteristic> list);

    @Query("SELECT * FROM user_characteristics WHERE game_id = :gameId")
    List<UserCharacteristic> getUserCharacteristics(long gameId);

    @Query("SELECT * FROM user_characteristics WHERE game_id = :gameId AND characteristic_id = :characteristicId LIMIT 1")
    UserCharacteristic getUserCharacteristic(long gameId, int characteristicId);
}
