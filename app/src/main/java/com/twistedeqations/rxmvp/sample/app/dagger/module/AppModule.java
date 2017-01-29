package com.twistedeqations.rxmvp.sample.app.dagger.module;

import android.app.Application;
import android.content.Context;
import com.twistedeqations.rxmvp.sample.app.dagger.AppScope;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

  private final Context context;

  public AppModule(Application application) {
    this.context = application.getApplicationContext();
  }

  @AppScope
  @Provides
  public Context context() {
    return context;
  }

}
