package com.twistedeqations.rxmvp.sample.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import com.twistedeqations.rxmvp.sample.BuildConfig;
import com.twistedeqations.rxmvp.sample.app.dagger.AppComponent;
import com.twistedeqations.rxmvp.sample.app.dagger.DaggerAppComponent;
import com.twistedeqations.rxmvp.sample.app.dagger.module.AppModule;
import com.twistedeqations.rxmvp.sample.ext.Constants;
import net.danlew.android.joda.JodaTimeAndroid;
import timber.log.Timber;

public class GithubApplication extends Application {

  public static GithubApplication get(Activity activity) {
    return (GithubApplication) activity.getApplication();
  }

  public static GithubApplication get(Service service) {
    return (GithubApplication) service.getApplication();
  }

  private AppComponent appComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    if(BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree(){
        @Override
        protected void log(int priority, String tag, String message, Throwable t) {
          super.log(priority, Constants.LOGTAG, message, t);
        }
      });
    }

    JodaTimeAndroid.init(this);

    appComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .build();
  }

  public AppComponent component() {
    return appComponent;
  }
}
