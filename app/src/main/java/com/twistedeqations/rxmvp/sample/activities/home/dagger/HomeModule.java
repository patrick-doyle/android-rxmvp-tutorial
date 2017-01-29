package com.twistedeqations.rxmvp.sample.activities.home.dagger;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.twistedeqations.rxmvp.sample.app.dagger.AppScope;
import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

  private final Activity activity;

  public HomeModule(Activity activity) {
    this.activity = activity;
  }

  //@HomeScope
  //@Provides
  //public Context context() {
  //  //return context;
  //}

}
