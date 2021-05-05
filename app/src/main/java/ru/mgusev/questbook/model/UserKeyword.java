package ru.mgusev.questbook.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_keywords")
public class UserKeyword {

    @PrimaryKey
    @ColumnInfo(name = "_id")
    private long id;

    @ColumnInfo(name = "game_id")
    private long gameId;

    @ColumnInfo(name = "keyword_id")
    private int keywordId;

    @ColumnInfo(name = "count")
    private int count;

    public UserKeyword(long id, long gameId, int keywordId, int count) {
        this.id = id;
        this.gameId = gameId;
        this.keywordId = keywordId;
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

    public int getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(int keywordId) {
        this.keywordId = keywordId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
