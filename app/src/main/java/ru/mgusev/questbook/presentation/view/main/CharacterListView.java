package ru.mgusev.questbook.presentation.view.main;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.mgusev.questbook.model.Item;
import ru.mgusev.questbook.model.Option;
import ru.mgusev.questbook.model.UserItem;

public interface CharacterListView extends MvpView {

    void setItemList(List<UserItem> userItems, List<Item> itemNames);

    void setStamina(String value);

    void setCourage(String value);

    void setSympathy(String value);
}
