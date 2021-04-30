package ru.mgusev.questbook.repository;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import dagger.Module;
import ru.mgusev.questbook.app.AppModule;
import ru.mgusev.questbook.database.QuestBookDB;
import ru.mgusev.questbook.model.Episode;
import ru.mgusev.questbook.model.Game;
import ru.mgusev.questbook.model.Item;
import ru.mgusev.questbook.model.Option;
import ru.mgusev.questbook.model.UserItem;

@Module(includes = AppModule.class)
public class Repository {

    private Context context;
    private QuestBookDB questBookDB;
    private Game game;

    @Inject
    public Repository(Context context, QuestBookDB questBookDB) {
        this.context = context;
        this.questBookDB = questBookDB;
    }

    public Context getContext() {
        return context;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void saveGameToDB(Game game) {
        questBookDB.gameDAO().insert(game);
        questBookDB.userCharacteristicDAO().insert(game.getCharacteristicList());
        questBookDB.userItemDAO().insert(game.getItemList());
        questBookDB.userKeywordDAO().insert(game.getKeywordList());
    }

    public void loadGameFromDB() {
        Game loadedGame = questBookDB.gameDAO().getNoCompleteGame();
        if (loadedGame != null) {
            loadedGame.setCharacteristicList(questBookDB.userCharacteristicDAO().getUserCharacteristics(loadedGame.getId()));
            loadedGame.setItemList(questBookDB.userItemDAO().getUserItems(loadedGame.getId()));
            loadedGame.setKeywordList(questBookDB.userKeywordDAO().getUserKeywords(loadedGame.getId()));
            setGame(loadedGame);
        }
    }

    public List<Game> getNoCompleteGames() {
        return questBookDB.gameDAO().getNoCompleteGames();
    }

    public void deleteGame(Game game) {
        questBookDB.userCharacteristicDAO().delete(game.getCharacteristicList());
        questBookDB.userItemDAO().delete(game.getItemList());
        questBookDB.userKeywordDAO().delete(game.getKeywordList());
        questBookDB.gameDAO().delete(game);
    }

    public Episode getEpisode(int id) {
        return questBookDB.episodeDAO().getEpisode(id);
    }

    public List<Option> getOptionList(int episodeId) {
        return questBookDB.optionDAO().getOptionList(episodeId);
    }

    public Option getOption(int optionId) {
        return questBookDB.optionDAO().getOptionById(optionId);
    }

    public int getCharacteristicCount(int id) {
        return questBookDB.userCharacteristicDAO().getUserCharacteristic(getGame().getId(), id).getCount();
    }

    public int getItemCount(int id) {
        return questBookDB.userItemDAO().getUserItem(getGame().getId(), id).getCount();
    }

    public int getKeywordCount(int id) {
        return questBookDB.userKeywordDAO().getUserKeyword(getGame().getId(), id).getCount();
    }

    public List<UserItem> getInventory(long gameId) {
        return questBookDB.userItemDAO().getUserInventory(gameId);
    }

    public List<Item> getAllItems() {
        return questBookDB.itemDAO().getAllItems();
    }
}
