package com.twistedeqations.rxmvp.sample.activities.home.dagger;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.twistedeqations.rxmvp.sample.activities.home.mvp.MainActivityView;
import com.twistedeqations.rxmvp.sample.app.dagger.AppScope;
import dagger.Module;
import dagger.Provides;
import retrofit2.http.POST;

@Module
public class HomeModule {

  private final Activity activity;

  public HomeModule(Activity activity) {
    this.activity = activity;
  }

  @Provides
  @HomeScope
  public MainActivityView view() {
    return new MainActivityView(activity);
  }

}
