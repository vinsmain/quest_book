package ru.mgusev.questbook.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import ru.mgusev.questbook.R;
import ru.mgusev.questbook.model.Option;
import ru.mgusev.questbook.presentation.view.main.MainView;
import ru.mgusev.questbook.presentation.presenter.main.MainPresenter;
import ru.mgusev.questbook.support.ResizableImageView;
import ru.mgusev.questbook.support.RotatedBitmap;

import com.arellomobile.mvp.MvpAppCompatActivity;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bluejamesbond.text.DocumentView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Random;

public class MainActivity extends MvpAppCompatActivity implements MainView, View.OnClickListener {

    public static final String TAG = "MainActivity";

    @InjectPresenter
    MainPresenter mainPresenter;

    @BindView(R.id.main_episode_image)ResizableImageView episodeImage;
    @BindView(R.id.main_episode_text) DocumentView episodeText;
    @BindView(R.id.main_option_buttons_container) LinearLayout optionButtonsContainer;
    @BindView(R.id.main_scroll_container) NestedScrollView scrollContainer;
    @BindView(R.id.main_stamina_value) TextView staminaValue;
    @BindView(R.id.main_courage_value) TextView courageValue;
    @BindView(R.id.main_sympathy_value) TextView sympathyValue;

    private LinearLayout.LayoutParams imageViewLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    private Typeface type;

    public static Intent getIntent(final Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        type = Typeface.createFromAsset(getAssets(),"fonts/bangkok-cyr.ttf");
    }

    @Override
    public void setVisibilityEpisodeImage(boolean visible) {
        episodeImage.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showEpisodeImage(String imageResource) {
        episodeImage.setImageBitmap(RotatedBitmap.getBitmap(
                BitmapFactory.decodeResource(getResources(),
                getResources().getIdentifier(imageResource, "drawable", this.getPackageName())),
                new Random().nextInt(7) - 3));
    }

    @Override
    public void setEpisodeText(String text) {
        scrollContainer.scrollTo(0, 0);
        episodeText.setText(text);
    }

    @Override
    public void initOptionButtonList(List<Option> optionList) {
        for (Option option : optionList) {
            optionButtonsContainer.addView(createOptionButton(option));
        }
    }

    private Button createOptionButton(Option option) {
        Button button = new Button(this);
        button.setId(option.getId());
        button.setTypeface(type);
        button.setTextSize(16);
        button.setLineSpacing(1, (float) 1.5);
        button.setPadding(56, 56, 56, 56);
        button.setText(option.getText());
        button.setLayoutParams(imageViewLayoutParams);
        button.setOnClickListener(this);
        return button;
    }

    @Override
    public void clearOptionButtonsContainer() {
        optionButtonsContainer.removeAllViews();
    }


    @Override
    public void onClick(View v) {
        mainPresenter.onOptionButtonClick(v.getId());
    }

    @Override
    public void setStaminaValue(String value) {
        staminaValue.setText(value);
    }

    @Override
    public void setCourageValue(String value) {
        courageValue.setText(value);
    }

    @Override
    public void setSympathyValue(String value) {
        sympathyValue.setText(value);
    }
}
