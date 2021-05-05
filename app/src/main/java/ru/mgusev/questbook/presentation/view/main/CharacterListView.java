package ru.mgusev.questbook.presentation.view.main;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;
import ru.mgusev.questbook.model.Item;
import ru.mgusev.questbook.model.UserItem;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface CharacterListView extends MvpView {

    void setItemList(List<UserItem> userItems, List<Item> itemNames);

    void setStamina(String value);

    void setCourage(String value);

    void setSympathy(String value);
}
