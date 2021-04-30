package ru.mgusev.questbook.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import ru.mgusev.questbook.model.Item;

@Dao
public interface ItemDAO {

    @Query("SELECT * FROM items")
    List<Item> getAllItems();
}
