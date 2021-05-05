package ru.mgusev.questbook.presentation.view.menu;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface MenuView extends MvpView {

    void setVisibilityContinueGameButton(boolean visible);

    void showDialog();

    void goToMainActivity();
}
