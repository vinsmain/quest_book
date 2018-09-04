package ru.mgusev.questbook.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "episodes", foreignKeys = @ForeignKey(entity = Book.class, parentColumns = "_id", childColumns = "book_id"), indices = {@Index("book_id")})
public class Episode {

    @PrimaryKey
    @ColumnInfo(name = "_id")
    private int id;

    @ColumnInfo(name = "book_id")
    private int bookId;

    @ColumnInfo(name = "text")
    private String text;

    @ColumnInfo(name = "image")
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
