package ru.mgusev.questbook.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ru.mgusev.questbook.database.dao.BookDAO;
import ru.mgusev.questbook.database.dao.EpisodeDAO;
import ru.mgusev.questbook.database.dao.OptionDAO;
import ru.mgusev.questbook.model.Book;
import ru.mgusev.questbook.model.Episode;
import ru.mgusev.questbook.model.Option;

@Database(entities = {Book.class, Episode.class, Option.class}, version = 1)
public abstract class QuestBookDB extends RoomDatabase {
    public abstract BookDAO bookDAO();
    public abstract EpisodeDAO episodeDAO();
    public abstract OptionDAO optionDAO();
}
