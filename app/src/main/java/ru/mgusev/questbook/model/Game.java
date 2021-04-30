package ru.mgusev.questbook.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(tableName = "games")
public class Game {

    @PrimaryKey
    @ColumnInfo(name = "_id")
    private long id;

    @ColumnInfo(name = "create")
    private long create;

    @ColumnInfo(name = "last_modified")
    private long lastModified;

    @ColumnInfo(name = "current_episode_id")
    private int currentEpisodeId;

    @ColumnInfo(name = "complete")
    private int complete;

    @Ignore
    private List<UserCharacteristic> characteristicList;

    @Ignore
    private List<UserItem> itemList;

    @Ignore
    private List<UserKeyword> keywordList;

    public Game() {
        Long timestamp = new Date().getTime();
        this.id = timestamp;
        this.create = timestamp;
        this.lastModified = timestamp;
        this.currentEpisodeId = 1;
        this.complete = 0;
        initCharacteristicList(timestamp);
        initItemList(timestamp);
        initKeywordList(timestamp);
    }

    private void initCharacteristicList(long gameId) {
        characteristicList = new ArrayList<>();
        characteristicList.add(new UserCharacteristic(gameId + 1, gameId, 1, 10));
        characteristicList.add(new UserCharacteristic(gameId + 2, gameId, 2, 7));
        characteristicList.add(new UserCharacteristic(gameId + 3, gameId, 3, 9));
    }

    private void initItemList(long gameId) {
        itemList = new ArrayList<>();
        itemList.add(new UserItem(gameId + 1, gameId, 1, 1));
        itemList.add(new UserItem(gameId + 2, gameId, 2, 1));
        itemList.add(new UserItem(gameId + 3, gameId, 3, 3));
        itemList.add(new UserItem(gameId + 4, gameId, 4, 1));
        itemList.add(new UserItem(gameId + 5, gameId, 5, 1));
        itemList.add(new UserItem(gameId + 6, gameId, 6, 1));
        itemList.add(new UserItem(gameId + 7, gameId, 7, 0));
        itemList.add(new UserItem(gameId + 8, gameId, 8, 0));
        itemList.add(new UserItem(gameId + 9, gameId, 9, 0));
        itemList.add(new UserItem(gameId + 10, gameId, 10, 0));
    }

    private void initKeywordList(long gameId) {
        keywordList = new ArrayList<>();
        keywordList.add(new UserKeyword(gameId + 1, gameId, 1, 0));
        keywordList.add(new UserKeyword(gameId + 2, gameId, 2, 0));
        keywordList.add(new UserKeyword(gameId + 3, gameId, 3, 0));
        keywordList.add(new UserKeyword(gameId + 4, gameId, 4, 0));
        keywordList.add(new UserKeyword(gameId + 5, gameId, 5, 0));
        keywordList.add(new UserKeyword(gameId + 6, gameId, 6, 0));
        keywordList.add(new UserKeyword(gameId + 7, gameId, 7, 0));
        keywordList.add(new UserKeyword(gameId + 8, gameId, 8, 0));
        keywordList.add(new UserKeyword(gameId + 9, gameId, 9, 0));
        keywordList.add(new UserKeyword(gameId + 10, gameId, 10, 0));
        keywordList.add(new UserKeyword(gameId + 11, gameId, 11, 0));
        keywordList.add(new UserKeyword(gameId + 12, gameId, 12, 0));
        keywordList.add(new UserKeyword(gameId + 13, gameId, 13, 0));
        keywordList.add(new UserKeyword(gameId + 14, gameId, 14, 0));
        keywordList.add(new UserKeyword(gameId + 15, gameId, 15, 0));
        keywordList.add(new UserKeyword(gameId + 16, gameId, 16, 0));
        keywordList.add(new UserKeyword(gameId + 17, gameId, 17, 0));
        keywordList.add(new UserKeyword(gameId + 18, gameId, 18, 0));
        keywordList.add(new UserKeyword(gameId + 19, gameId, 19, 0));
        keywordList.add(new UserKeyword(gameId + 20, gameId, 20, 0));
        keywordList.add(new UserKeyword(gameId + 21, gameId, 21, 0));
        keywordList.add(new UserKeyword(gameId + 22, gameId, 22, 1));
        keywordList.add(new UserKeyword(gameId + 23, gameId, 23, 1));
        keywordList.add(new UserKeyword(gameId + 24, gameId, 24, 1));
        keywordList.add(new UserKeyword(gameId + 25, gameId, 25, 1));
        keywordList.add(new UserKeyword(gameId + 26, gameId, 26, 1));
        keywordList.add(new UserKeyword(gameId + 27, gameId, 27, 1));
        keywordList.add(new UserKeyword(gameId + 28, gameId, 28, 1));
        keywordList.add(new UserKeyword(gameId + 29, gameId, 29, 1));
        keywordList.add(new UserKeyword(gameId + 30, gameId, 30, 0));
        keywordList.add(new UserKeyword(gameId + 31, gameId, 31, 1));
        keywordList.add(new UserKeyword(gameId + 32, gameId, 32, 1));
        keywordList.add(new UserKeyword(gameId + 33, gameId, 33, 1));
        keywordList.add(new UserKeyword(gameId + 34, gameId, 34, 1));
        keywordList.add(new UserKeyword(gameId + 35, gameId, 35, 1));
        keywordList.add(new UserKeyword(gameId + 36, gameId, 36, 1));
        keywordList.add(new UserKeyword(gameId + 37, gameId, 37, 1));
        keywordList.add(new UserKeyword(gameId + 38, gameId, 38, 1));
        keywordList.add(new UserKeyword(gameId + 39, gameId, 39, 1));
        keywordList.add(new UserKeyword(gameId + 40, gameId, 40, 0));
        keywordList.add(new UserKeyword(gameId + 41, gameId, 41, 0));
        keywordList.add(new UserKeyword(gameId + 42, gameId, 42, 0));
        keywordList.add(new UserKeyword(gameId + 43, gameId, 43, 1));
        keywordList.add(new UserKeyword(gameId + 44, gameId, 44, 1));
        keywordList.add(new UserKeyword(gameId + 45, gameId, 45, 1));
        keywordList.add(new UserKeyword(gameId + 46, gameId, 46, 1));
        keywordList.add(new UserKeyword(gameId + 47, gameId, 47, 1));
        keywordList.add(new UserKeyword(gameId + 48, gameId, 48, 1));
        keywordList.add(new UserKeyword(gameId + 49, gameId, 49, 1));
        keywordList.add(new UserKeyword(gameId + 50, gameId, 50, 1));
        keywordList.add(new UserKeyword(gameId + 51, gameId, 51, 1));
        keywordList.add(new UserKeyword(gameId + 52, gameId, 52, 1));
        keywordList.add(new UserKeyword(gameId + 53, gameId, 53, 1));
        keywordList.add(new UserKeyword(gameId + 54, gameId, 54, 1));
        keywordList.add(new UserKeyword(gameId + 55, gameId, 55, 1));
        keywordList.add(new UserKeyword(gameId + 56, gameId, 56, 1));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreate() {
        return create;
    }

    public void setCreate(long create) {
        this.create = create;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public int getCurrentEpisodeId() {
        return currentEpisodeId;
    }

    public void setCurrentEpisodeId(int currentEpisodeId) {
        this.currentEpisodeId = currentEpisodeId;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public List<UserCharacteristic> getCharacteristicList() {
        return characteristicList;
    }

    public void setCharacteristicList(List<UserCharacteristic> characteristicList) {
        this.characteristicList = characteristicList;
    }

    public List<UserItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<UserItem> itemList) {
        this.itemList = itemList;
    }

    public List<UserKeyword> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(List<UserKeyword> keywordList) {
        this.keywordList = keywordList;
    }
}
