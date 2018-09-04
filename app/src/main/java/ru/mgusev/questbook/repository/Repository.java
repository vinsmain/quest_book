package ru.mgusev.questbook.repository;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import dagger.Module;
import ru.mgusev.questbook.app.AppModule;
import ru.mgusev.questbook.database.QuestBookDB;
import ru.mgusev.questbook.model.Episode;
import ru.mgusev.questbook.model.Option;

@Module(includes = AppModule.class)
public class Repository {

    private Context context;
    private QuestBookDB questBookDB;

    @Inject
    public Repository(Context context, QuestBookDB questBookDB) {
        this.context = context;
        this.questBookDB = questBookDB;
    }

    public Episode getEpisode(int id) {
        return questBookDB.episodeDAO().getEpisode(id);
    }

    public List<Option> getOptionList(int episodeId) {
        return questBookDB.optionDAO().getOptionList(episodeId);
    }
}
