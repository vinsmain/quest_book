package ru.mgusev.questbook.app;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.fstyle.library.helper.AssetSQLiteOpenHelperFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.mgusev.questbook.database.QuestBookDB;
import ru.mgusev.questbook.repository.Repository;

@Module
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

    @Provides
    @Singleton
    public QuestBookDB provideQuestBookDB(Context context) {
        return Room.databaseBuilder(context, QuestBookDB.class, "QuestBookDB.db")
                .openHelperFactory(new AssetSQLiteOpenHelperFactory())
                //.addMigrations(ru.mgusev.eldritchhorror.database.staticDB.Migrations.MIGRATION_1_2)
                .allowMainThreadQueries()
                .build();
    }
}
