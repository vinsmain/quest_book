package ru.mgusev.questbook.presentation.presenter.main;


import ru.mgusev.questbook.app.App;
import ru.mgusev.questbook.presentation.view.main.MainView;
import ru.mgusev.questbook.repository.Repository;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    Repository repository;

    public MainPresenter() {
        App.getComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().setEpisodeText(repository.getEpisode(1).getText());
        getViewState().initOptionButtonList(repository.getOptionList(1));
    }
}
