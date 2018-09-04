package ru.mgusev.questbook.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import ru.mgusev.questbook.R;
import ru.mgusev.questbook.presentation.view.main.MainView;
import ru.mgusev.questbook.presentation.presenter.main.MainPresenter;

import com.arellomobile.mvp.MvpAppCompatActivity;


import com.arellomobile.mvp.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    public static final String TAG = "MainActivity";
    @InjectPresenter
    MainPresenter mMainPresenter;

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, MainActivity.class);

        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
