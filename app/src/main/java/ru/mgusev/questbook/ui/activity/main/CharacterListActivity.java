package ru.mgusev.questbook.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.mgusev.questbook.R;
import ru.mgusev.questbook.adapter.ItemListAdapter;
import ru.mgusev.questbook.model.Item;
import ru.mgusev.questbook.model.UserItem;
import ru.mgusev.questbook.presentation.presenter.main.CharacterListPresenter;
import ru.mgusev.questbook.presentation.view.main.CharacterListView;
import ru.mgusev.questbook.ui.activity.menu.MenuActivity;

public class CharacterListActivity extends MvpAppCompatActivity implements CharacterListView {

    public static final String TAG = "CharacterListActivity";

    @InjectPresenter
    CharacterListPresenter characterListPresenter;

    @BindView(R.id.character_list_items_rv) RecyclerView itemListRV;
    @BindView(R.id.character_list_stamina_value) TextView stamina;
    @BindView(R.id.character_list_courage_value) TextView courage;
    @BindView(R.id.character_list_sympathy_value) TextView sympathy;

    private ItemListAdapter adapter;

    public static Intent getIntent(final Context context) {
        return new Intent(context, CharacterListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_character_list);
        ButterKnife.bind(this);
        if (!MenuActivity.initialized) startActivity(MenuActivity.getIntent(this));
        initItemListRV();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(base));
    }

    private void initItemListRV() {
        //GridLayoutManager layoutManager = new GridLayoutManager(this, columnsCount);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        itemListRV.setLayoutManager(layoutManager);
        itemListRV.setHasFixedSize(true);

        adapter = new ItemListAdapter();
        itemListRV.setAdapter(adapter);
    }

    @Override
    public void setItemList(List<UserItem> userItems, List<Item> itemNames) {
        adapter.setUserItems(userItems, itemNames);
    }

    @Override
    public void setStamina(String value) {
        stamina.setText(value);
    }

    @Override
    public void setCourage(String value) {
        courage.setText(value);
    }

    @Override
    public void setSympathy(String value) {
        sympathy.setText(value);
    }

    @OnClick({R.id.character_list_back_to_menu})
    public void onClick() {
        finish();
    }
}