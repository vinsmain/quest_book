package ru.mgusev.questbook.presentation.view.main;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.mgusev.questbook.model.Option;

public interface MainView extends MvpView {

    void setEpisodeText(String text);

    void initOptionButtonList(List<Option> optionList);
}
