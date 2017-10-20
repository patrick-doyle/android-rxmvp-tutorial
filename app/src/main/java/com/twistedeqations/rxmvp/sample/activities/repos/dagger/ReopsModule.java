package com.twistedeqations.rxmvp.sample.activities.repos.dagger;

import android.app.Activity;
import com.twistedeqations.rxmvp.sample.activities.repos.mvp.ReposModel;
import com.twistedeqations.rxmvp.sample.activities.repos.mvp.ReposPresenter;
import com.twistedeqations.rxmvp.sample.activities.repos.mvp.view.ReposView;
import com.twistedeqations.rxmvp.sample.app.network.GithubNetwork;
import dagger.Module;
import dagger.Provides;

@Module
public class ReposModule {

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
  public ReposModel model() {
    return new ReposModel(activity);
  }

  @Provides
  @ReposScope
  public ReposPresenter homePresenter(ReposView homeView, ReopsModel model) {
    return new ReposPresenter(homeView, model);
  }

}
