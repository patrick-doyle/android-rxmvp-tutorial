package com.twistedeqations.rxmvp.sample.activities.repos.mvp;

import com.twistedeqations.rxmvp.sample.activities.repos.mvp.view.ReposView;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

@SuppressWarnings("Convert2MethodRef")
public class ReposPresenter {

  private final ReposView view;
  private final ReposModel model;
  private final CompositeSubscription compositeSubscription = new CompositeSubscription();

  public ReposPresenter(ReposView view, ReposModel model) {
    this.view = view;
    this.model = model;
  }

  public void onCreate() {
    setIntentData();
  }

  public void onDestroy() {
    compositeSubscription.clear();
  }

  private void setIntentData() {
    view.setData(model.gitHubReposIntent());
  }


}
