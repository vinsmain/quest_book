package ru.mgusev.questbook.presentation.view.main;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.mgusev.questbook.model.Option;

public interface MainView extends MvpView {

    void setVisibilityEpisodeImage(boolean visible);

    void showEpisodeImage(String imageResource);

    void setEpisodeText(String text);

    void initOptionButtonList(List<Option> optionList);

    void clearOptionButtonsContainer();

    void setStaminaValue(String value);

    void setCourageValue(String value);

    void setSympathyValue(String value);

    void setVisibilityCompleteGame(boolean visibility);

    void backToMenu();
}
