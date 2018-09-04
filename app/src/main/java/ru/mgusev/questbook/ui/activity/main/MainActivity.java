package ru.mgusev.questbook.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.mgusev.questbook.R;
import ru.mgusev.questbook.model.Option;
import ru.mgusev.questbook.presentation.view.main.MainView;
import ru.mgusev.questbook.presentation.presenter.main.MainPresenter;

import com.arellomobile.mvp.MvpAppCompatActivity;


import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    public static final String TAG = "MainActivity";

    @InjectPresenter
    MainPresenter mMainPresenter;

    @BindView(R.id.episode_text) TextView episodeText;
    @BindView(R.id.main_linear) LinearLayout linearLayout;

    LinearLayout.LayoutParams imageViewLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

    public static Intent getIntent(final Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void setEpisodeText(String text) {
        episodeText.setText(text);
    }

    @Override
    public void initOptionButtonList(List<Option> optionList) {
        for (Option option : optionList) {
            Button button = new Button(this);
            button.setText(option.getText());
            button.setLayoutParams(imageViewLayoutParams);
            linearLayout.addView(button);
        }
    }
}
