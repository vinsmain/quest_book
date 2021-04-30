package ru.mgusev.questbook.presentation.presenter.main;

import ru.mgusev.questbook.app.App;
import ru.mgusev.questbook.model.Condition;
import ru.mgusev.questbook.model.Episode;
import ru.mgusev.questbook.model.Option;
import ru.mgusev.questbook.model.UserCharacteristic;
import ru.mgusev.questbook.model.UserItem;
import ru.mgusev.questbook.model.UserKeyword;
import ru.mgusev.questbook.presentation.view.main.MainView;
import ru.mgusev.questbook.repository.Repository;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
        showEpisode(repository.getGame().getCurrentEpisodeId());
    }

    public void onOptionButtonClick(int optionId) {
        setEffects(repository.getOption(optionId));
        int nextEpisodeId = repository.getOption(optionId).getChildrenId();
        repository.getGame().setCurrentEpisodeId(nextEpisodeId);
        repository.getGame().setLastModified(new Date().getTime());
        repository.saveGameToDB(repository.getGame());
        showEpisode(nextEpisodeId);
    }

    private void showEpisode(int id) {
        Episode currentEpisode = repository.getEpisode(id);
        if (currentEpisode.getImage() != null) {
            getViewState().setVisibilityEpisodeImage(true);
            getViewState().showEpisodeImage(currentEpisode.getImage());
        } else getViewState().setVisibilityEpisodeImage(false);
        getViewState().setEpisodeText(currentEpisode.getText());
        getViewState().clearOptionButtonsContainer();
        getViewState().initOptionButtonList(getValidatedOptionList(repository.getOptionList(id)));
        setCharacteristics(repository.getGame().getCharacteristicList());

        if (currentEpisode.isEnd()) completeGame();
        getViewState().setVisibilityCompleteGame(currentEpisode.isEnd());
    }

    private void completeGame() {
        repository.getGame().setComplete(1);
        repository.getGame().setLastModified(new Date().getTime());
        repository.saveGameToDB(repository.getGame());
    }

    private List<Option> getValidatedOptionList(List<Option> list) {
        List<Option> validatedOptionList = new ArrayList<>();
        int i = 0;
        for (Option option : list) {
            if (option.getRandom() == 1) {
                if (validatedOptionList.isEmpty() && (new Random().nextInt(2) == 0 || i == list.size() - 1)) validatedOptionList.add(option);
                i++;
            } else if (option.getConditions() == null || (option.getConditions() != null && isValidated(option))) validatedOptionList.add(option);
        }
        return validatedOptionList;
    }

    private boolean isValidated(Option option) {
        for (Condition condition : getConditionListFromJSON(option.getConditions())) {
            switch (condition.getType()) {
                case "characteristic" :
                    if ((condition.getCount() == 0 && repository.getCharacteristicCount(condition.getId()) > 0) || (condition.getCount() != 0 && condition.getCount() > repository.getCharacteristicCount(condition.getId()))) return false;
                    break;
                case "item" :
                    if ((condition.getCount() == 0 && repository.getItemCount(condition.getId()) > 0) || (condition.getCount() != 0 && condition.getCount() > repository.getItemCount(condition.getId()))) return false;
                    break;
                case "keyword" :
                    if (condition.getCount() != repository.getKeywordCount(condition.getId())) return false;
                    break;
            }
        }
        return true;
    }

    private void setEffects(Option option) {
        if (option.getEffects() != null) {
            for (Condition condition : getConditionListFromJSON(option.getEffects())) {
                switch (condition.getType()) {
                    case "characteristic":
                        List<UserCharacteristic> characteristicList = repository.getGame().getCharacteristicList();
                        for (UserCharacteristic userCharacteristic : characteristicList) {
                            if (userCharacteristic.getCharacteristicId() == condition.getId())
                                userCharacteristic.setCount(userCharacteristic.getCount() + condition.getCount());
                        }
                        repository.getGame().setCharacteristicList(characteristicList);
                        break;
                    case "item":
                        List<UserItem> itemList = repository.getGame().getItemList();
                        for (UserItem userItem : itemList) {
                            if (userItem.getItemId() == condition.getId())
                                if (condition.getCount() != 0) userItem.setCount(userItem.getCount() + condition.getCount());
                                else userItem.setCount(condition.getCount());
                        }
                        repository.getGame().setItemList(itemList);
                        break;
                    case "keyword":
                        List<UserKeyword> keywordList = repository.getGame().getKeywordList();
                        for (UserKeyword userKeyword : keywordList) {
                            if (userKeyword.getKeywordId() == condition.getId())
                                userKeyword.setCount(condition.getCount());
                        }
                        repository.getGame().setKeywordList(keywordList);
                        break;
                }
            }
        }
    }

    private List<Condition> getConditionListFromJSON(String json) {
        List<Condition> conditionList = new ArrayList<>();
        try{
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                conditionList.add(new Condition(jsonObject.getString("type"), jsonObject.getInt("id"), jsonObject.getInt("count")));
            }
        } catch (JSONException e){
            e.getStackTrace();
        }
        return conditionList;
    }

    private void setCharacteristics(List<UserCharacteristic> list) {
        for (UserCharacteristic userCharacteristic : list) {
            switch (userCharacteristic.getCharacteristicId()) {
                case 1 :
                    getViewState().setStaminaValue(String.valueOf(userCharacteristic.getCount()));
                    break;
                case 2 :
                    getViewState().setCourageValue(String.valueOf(userCharacteristic.getCount()));
                    break;
                case 3 :
                    getViewState().setSympathyValue(String.valueOf(userCharacteristic.getCount()));
                    break;
            }
        }
    }

    public void onBackToMenuButtonClick() {
        getViewState().backToMenu();
    }
}
