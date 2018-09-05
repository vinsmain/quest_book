package ru.mgusev.questbook.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConditionList {

    private List<Condition> conditionList;

    public ConditionList() {
        this.conditionList = new ArrayList<>();
    }

    private void parseJSON() {
        try{
            JSONObject jsonObject = new JSONObject("[{\"type\":\"item\", \"id\":1, \"count\":2},{\"type\":\"item\", \"id\":2, \"count\":3}]");
        } catch (JSONException e){
            e.getStackTrace();
        }
    }
}
