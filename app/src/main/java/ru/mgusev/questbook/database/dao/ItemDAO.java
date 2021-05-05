package ru.mgusev.questbook.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import ru.mgusev.questbook.model.Item;

@Dao
public interface ItemDAO {

    @Query("SELECT * FROM items")
    List<Item> getAllItems();
}
