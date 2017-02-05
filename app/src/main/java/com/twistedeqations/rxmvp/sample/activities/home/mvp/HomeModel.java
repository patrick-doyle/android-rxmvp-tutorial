package com.twistedeqations.rxmvp.sample.activities.home.mvp;

import android.app.Activity;
import com.twistedeqations.rxmvp.sample.app.network.GithubNetwork;
import com.twistedeqations.rxmvp.sample.app.network.model.GitHubRepo;
import com.twistedequations.rxstate.RxSaveState;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;

public class HomeModel {

  public static final String REPOLIST_STATE_KEY = "REPOLIST_STATE_KEY";
  private final Activity activity;
  private final GithubNetwork githubNetwork;

  public HomeModel(Activity activity, GithubNetwork githubNetwork) {
    this.activity = activity;
    this.githubNetwork = githubNetwork;
  }

  public Observable<List<GitHubRepo>> getUserReops(String username) {
    return githubNetwork.getReposForUser(username);
  }

  public void saveRepoListState(List<GitHubRepo> repoList) {
    RxSaveState.updateSaveState(activity, bundle -> {
      bundle.putParcelableArrayList(REPOLIST_STATE_KEY, new ArrayList<>(repoList));
    });
  }

  public Observable<List<GitHubRepo>> getReposFromSaveState() {
    return RxSaveState.getSavedState(activity)
        .map(bundle -> bundle.getParcelableArrayList(REPOLIST_STATE_KEY));
  }
}
