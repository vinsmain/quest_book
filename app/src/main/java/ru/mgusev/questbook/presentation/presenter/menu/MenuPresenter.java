package ru.mgusev.questbook.presentation.presenter.menu;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.mgusev.questbook.app.App;
import ru.mgusev.questbook.model.Game;
import ru.mgusev.questbook.presentation.view.menu.MenuView;
import ru.mgusev.questbook.repository.Repository;

import javax.inject.Inject;

@InjectViewState
public class MenuPresenter extends MvpPresenter<MenuView> {

    @Inject
    Repository repository;

    public MenuPresenter() {
        App.getComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        refreshMenu();
    }

    public void refreshMenu() {
        getViewState().setVisibilityContinueGameButton(repository.getNoCompleteGames().size() != 0);
    }

    public void clickNewGame() {
        if (repository.getNoCompleteGames().size() != 0) getViewState().showDialog();
        else positiveDialogResult();
    }

    public void positiveDialogResult() {
        for (Game noCompleteGame : repository.getNoCompleteGames()) {
            repository.deleteGame(noCompleteGame);
        }

        Game game = new Game();
        repository.setGame(game);
        repository.saveGameToDB(game);
        getViewState().goToMainActivity();
    }

    public void clickContinueGame() {
        repository.loadGameFromDB();
        getViewState().goToMainActivity();
    }
}