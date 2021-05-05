package ru.mgusev.questbook.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_items")
public class UserItem {

    @PrimaryKey
    @ColumnInfo(name = "_id")
    private long id;

    @ColumnInfo(name = "game_id")
    private long gameId;

    @ColumnInfo(name = "item_id")
    private int itemId;

    @ColumnInfo(name = "count")
    private int count;

    public UserItem(long id, long gameId, int itemId, int count) {
        this.id = id;
        this.gameId = gameId;
        this.itemId = itemId;
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

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}