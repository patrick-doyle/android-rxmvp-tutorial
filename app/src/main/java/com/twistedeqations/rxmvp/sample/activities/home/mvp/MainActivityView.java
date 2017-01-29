package com.twistedeqations.rxmvp.sample.activities.home.mvp;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.twistedeqations.rxmvp.sample.R;

@SuppressLint("ViewConstructor")
public class MainActivityView extends FrameLayout {

  @BindView(R.id.edit_username)
  EditText usernameEditText;

  @BindView(R.id.btn_username_lookup)
  Button usernameLookUp;

  @BindView(R.id.main_toolbar)
  Toolbar toolbar;

  public MainActivityView(Activity activity) {
    super(activity);

    inflate(getContext(), R.layout.activity_main, this);

    ButterKnife.bind(this);

  }

}
