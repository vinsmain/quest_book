package ru.mgusev.questbook.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "options", foreignKeys = @ForeignKey(entity = Episode.class, parentColumns = "_id", childColumns = "parent_episode_id"), indices = {@Index("parent_episode_id")})
public class Option {

    @PrimaryKey
    @ColumnInfo(name = "_id")
    private int id;

    @ColumnInfo(name = "parent_episode_id")
    private int parentId;

    @ColumnInfo(name = "text")
    private String text;

    @ColumnInfo(name = "children_episode_id")
    private int childrenId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getChildrenId() {
        return childrenId;
    }

    public void setChildrenId(int childrenId) {
        this.childrenId = childrenId;
    }
}
