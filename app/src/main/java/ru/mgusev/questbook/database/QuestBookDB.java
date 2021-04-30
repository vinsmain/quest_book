package ru.mgusev.questbook.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ru.mgusev.questbook.database.dao.BookDAO;
import ru.mgusev.questbook.database.dao.EpisodeDAO;
import ru.mgusev.questbook.database.dao.GameDAO;
import ru.mgusev.questbook.database.dao.ItemDAO;
import ru.mgusev.questbook.database.dao.OptionDAO;
import ru.mgusev.questbook.database.dao.UserCharacteristicDAO;
import ru.mgusev.questbook.database.dao.UserItemDAO;
import ru.mgusev.questbook.database.dao.UserKeywordDAO;
import ru.mgusev.questbook.model.Book;
import ru.mgusev.questbook.model.Episode;
import ru.mgusev.questbook.model.Game;
import ru.mgusev.questbook.model.Item;
import ru.mgusev.questbook.model.Option;
import ru.mgusev.questbook.model.UserCharacteristic;
import ru.mgusev.questbook.model.UserItem;
import ru.mgusev.questbook.model.UserKeyword;

@Database(entities = {Book.class, Episode.class, Option.class, Game.class, UserCharacteristic.class, UserItem.class, UserKeyword.class, Item.class}, version = 1)
public abstract class QuestBookDB extends RoomDatabase {
    public abstract BookDAO bookDAO();
    public abstract EpisodeDAO episodeDAO();
    public abstract OptionDAO optionDAO();
    public abstract GameDAO gameDAO();
    public abstract UserCharacteristicDAO userCharacteristicDAO();
    public abstract UserItemDAO userItemDAO();
    public abstract UserKeywordDAO userKeywordDAO();
    public abstract ItemDAO itemDAO();
}
