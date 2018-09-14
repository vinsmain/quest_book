package ru.mgusev.questbook.presentation.presenter.menu;

import ru.mgusev.questbook.app.App;
import ru.mgusev.questbook.model.Game;
import ru.mgusev.questbook.presentation.view.menu.MenuView;
import ru.mgusev.questbook.repository.Repository;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

@InjectViewState
public class MenuPresenter extends MvpPresenter<MenuView> {

    @Inject
    Repository repository;

    public MenuPresenter() {
        App.getComponent().inject(this);
    }

    public void clickNewGame() {
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
