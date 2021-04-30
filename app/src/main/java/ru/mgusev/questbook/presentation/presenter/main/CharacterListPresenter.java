package ru.mgusev.questbook.presentation.presenter.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import javax.inject.Inject;

import ru.mgusev.questbook.app.App;
import ru.mgusev.questbook.model.UserCharacteristic;
import ru.mgusev.questbook.presentation.view.main.CharacterListView;
import ru.mgusev.questbook.repository.Repository;

@InjectViewState
public class CharacterListPresenter extends MvpPresenter<CharacterListView> {

    @Inject
    Repository repository;

    public CharacterListPresenter() {
        App.getComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().setItemList(repository.getInventory(repository.getGame().getId()), repository.getAllItems());
        setCharacteristics(repository.getGame().getCharacteristicList());
    }

    private void setCharacteristics(List<UserCharacteristic> list) {
        for (UserCharacteristic userCharacteristic : list) {
            switch (userCharacteristic.getCharacteristicId()) {
                case 1 :
                    getViewState().setStamina(String.valueOf(userCharacteristic.getCount()));
                    break;
                case 2 :
                    getViewState().setCourage(String.valueOf(userCharacteristic.getCount()));
                    break;
                case 3 :
                    getViewState().setSympathy(String.valueOf(userCharacteristic.getCount()));
                    break;
            }
        }
    }
}
