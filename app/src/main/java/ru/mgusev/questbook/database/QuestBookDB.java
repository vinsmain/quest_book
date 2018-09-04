package ru.mgusev.questbook.database;

import android.arch.persistence.room.Database;

import ru.mgusev.questbook.model.Book;
import ru.mgusev.questbook.model.Episode;
import ru.mgusev.questbook.model.Option;

@Database(entities = {Book.class, Episode.class, Option.class}, version = 1)
public class QuestBookDB {
}
