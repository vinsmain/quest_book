package ru.mgusev.questbook.presentation.view.menu;

import com.arellomobile.mvp.MvpView;

public interface MenuView extends MvpView {

    void setVisibilityContinueGameButton(boolean visible);

    void showDialog();

    void goToMainActivity();
}
