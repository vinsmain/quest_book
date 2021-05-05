package ru.mgusev.questbook.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_characteristics")
public class UserCharacteristic {

    @PrimaryKey
    @ColumnInfo(name = "_id")
    private long id;

    @ColumnInfo(name = "game_id")
    private long gameId;

    @ColumnInfo(name = "characteristic_id")
    private int characteristicId;

    @ColumnInfo(name = "count")
    private int count;

    public UserCharacteristic(long id, long gameId, int characteristicId, int count) {
        this.id = id;
        this.gameId = gameId;
        this.characteristicId = characteristicId;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public int getCharacteristicId() {
        return characteristicId;
    }

    public void setCharacteristicId(int characteristicId) {
        this.characteristicId = characteristicId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}