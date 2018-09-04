package ru.mgusev.questbook.app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Provides;
import ru.mgusev.questbook.database.QuestBookDB;
import ru.mgusev.questbook.repository.Repository;

public class AppModule {

    private Context context;

    AppModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    public Repository provideRepository(Context context, QuestBookDB questBookDB){
        return new Repository(context, questBookDB);
    }
}
