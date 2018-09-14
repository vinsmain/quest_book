package ru.mgusev.questbook.ui.activity.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.mgusev.questbook.R;
import ru.mgusev.questbook.presentation.view.menu.MenuView;
import ru.mgusev.questbook.presentation.presenter.menu.MenuPresenter;
import ru.mgusev.questbook.ui.activity.main.MainActivity;

import com.arellomobile.mvp.MvpAppCompatActivity;


import com.arellomobile.mvp.presenter.InjectPresenter;

public class MenuActivity extends MvpAppCompatActivity implements MenuView {
    public static final String TAG = "MenuActivity";

    @InjectPresenter
    MenuPresenter menuPresenter;

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, MenuActivity.class);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.menu_new_game, R.id.menu_continue_game, R.id.menu_exit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu_new_game :
                menuPresenter.clickNewGame();
                break;
            case R.id.menu_continue_game :
                menuPresenter.clickContinueGame();
                break;
            case R.id.menu_exit :
                finish();
                break;
        }
    }

    @Override
    public void goToMainActivity() {
        startActivity(MainActivity.getIntent(this));
    }
}
