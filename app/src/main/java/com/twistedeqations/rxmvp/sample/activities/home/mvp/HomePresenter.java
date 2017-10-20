package com.twistedeqations.rxmvp.sample.activities.home.mvp;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

@SuppressWarnings("Convert2MethodRef")
public class HomePresenter {

  private final HomeView view;
  private final HomeModel model;
  private final CompositeSubscription compositeSubscription = new CompositeSubscription();

  public HomePresenter(HomeView view, HomeModel model) {
    this.view = view;
    this.model = model;
  }

  public void onCreate() {
    compositeSubscription.add(observeLookupButton());
    compositeSubscription.add(loadSavedState());
  }

  public void onDestroy() {
    compositeSubscription.clear();
  }

  private Subscription loadSavedState() {
    return model.getReposFromSaveState()
        .subscribe(gitHubRepoList -> view.setMessage("Look up button clicked - " + gitHubRepoList));
  }

  private Subscription observeLookupButton() {
    return view.observeButton()
        .doOnNext(__ -> view.showLoading(true))
        .map(__ -> view.getUsernameEdit())
        .observeOn(Schedulers.io())
        .switchMap(username -> model.getUserRepos(username))
        .observeOn(AndroidSchedulers.mainThread())
        .doOnNext(gitHubRepoList -> model.saveRepoListState(gitHubRepoList))
        .doOnEach(__ -> view.showLoading(false))
        .retry()
        .subscribe(gitHubRepoList -> {
          model.startRepoActivity(gitHubRepoList);
        });
  }
}
