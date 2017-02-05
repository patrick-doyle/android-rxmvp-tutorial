package com.twistedeqations.rxmvp.sample.activities.repos.dagger;

import android.app.Activity;
import com.twistedeqations.rxmvp.sample.activities.repos.mvp.ReopsModel;
import com.twistedeqations.rxmvp.sample.activities.repos.mvp.ReposPresenter;
import com.twistedeqations.rxmvp.sample.activities.repos.mvp.view.ReposView;
import com.twistedeqations.rxmvp.sample.app.network.GithubNetwork;
import dagger.Module;
import dagger.Provides;

@Module
public class ReopsModule {

  private final Activity activity;

  public ReopsModule(Activity activity) {
    this.activity = activity;
  }

  @Provides
  @ReposScope
  public ReposView view() {
    return new ReposView(activity);
  }
  @Provides
  @ReposScope
  public ReopsModel model() {
    return new ReopsModel(activity);
  }

  @Provides
  @ReposScope
  public ReposPresenter homePresenter(ReposView homeView, ReopsModel model) {
    return new ReposPresenter(homeView, model);
  }

}
