package ru.mgusev.questbook.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

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

    @ColumnInfo(name = "end")
    private boolean end;

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

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
