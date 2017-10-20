package com.twistedeqations.rxmvp.sample.activities.repos.mvp;

import android.app.Activity;
import com.twistedeqations.rxmvp.sample.activities.repos.ReposActivity;
import com.twistedeqations.rxmvp.sample.app.network.GithubNetwork;
import com.twistedeqations.rxmvp.sample.app.network.model.GitHubRepo;
import com.twistedequations.rxstate.RxSaveState;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;

public class ReposModel {

  private final Activity activity;

  public ReposModel(Activity activity) {
    this.activity = activity;
  }

  public List<GitHubRepo> gitHubReposIntent() {
    return activity.getIntent().getParcelableArrayListExtra(ReposActivity.INTENT_DATA_REPOS);
  }

}
