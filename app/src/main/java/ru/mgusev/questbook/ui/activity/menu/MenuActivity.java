package ru.mgusev.questbook.ui.activity.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.mgusev.questbook.BuildConfig;
import ru.mgusev.questbook.R;
import ru.mgusev.questbook.presentation.view.menu.MenuView;
import ru.mgusev.questbook.presentation.presenter.menu.MenuPresenter;
import ru.mgusev.questbook.ui.activity.main.MainActivity;
import ru.mgusev.questbook.ui.dialog.CustomDialog;

public class MenuActivity extends MvpAppCompatActivity implements MenuView {
    public static final String TAG = "MenuActivity";
    public static boolean initialized;

    @InjectPresenter
    MenuPresenter menuPresenter;

    @BindView(R.id.menu_continue_game) Button continueGame;
    @BindView(R.id.menu_version) TextView version;

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, MenuActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        String versionValue = getString(R.string.version_header) + BuildConfig.VERSION_NAME;
        version.setText(versionValue);
        initialized = true;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(base));
    }

    @Override
    protected void onResume() {
        super.onResume();
        menuPresenter.refreshMenu();
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
    public void setVisibilityContinueGameButton(boolean visible) {
        continueGame.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showDialog() {
        CustomDialog dialog = new CustomDialog(this);
        dialog.show();
    }

    public void positiveDialogResult() {
        menuPresenter.positiveDialogResult();
    }

    @Override
    public void goToMainActivity() {
        startActivity(MainActivity.getIntent(this));
    }
}