package ru.mgusev.questbook.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

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

    @ColumnInfo(name = "conditions")
    private String conditions;

    @ColumnInfo(name = "effects")
    private String effects;

    @ColumnInfo(name = "random")
    private int random;

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

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getEffects() {
        return effects;
    }

    public void setEffects(String effects) {
        this.effects = effects;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }
}
