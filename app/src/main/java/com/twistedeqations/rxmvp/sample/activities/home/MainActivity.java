package com.twistedeqations.rxmvp.sample.activities.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.twistedeqations.rxmvp.sample.R;
import com.twistedeqations.rxmvp.sample.activities.home.dagger.DaggerHomeComponent;
import com.twistedeqations.rxmvp.sample.activities.home.dagger.HomeModule;
import com.twistedeqations.rxmvp.sample.activities.home.mvp.MainActivityView;
import com.twistedeqations.rxmvp.sample.app.GithubApplication;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

  @Inject
  MainActivityView view;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    DaggerHomeComponent.builder()
        .appComponent(GithubApplication.get(this).component())
        .homeModule(new HomeModule(this))
        .build().inject(this);

    setContentView(view);

  }
}
