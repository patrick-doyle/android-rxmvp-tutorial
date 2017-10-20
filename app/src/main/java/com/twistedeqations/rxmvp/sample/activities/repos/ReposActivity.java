package com.twistedeqations.rxmvp.sample.activities.repos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.twistedeqations.rxmvp.sample.activities.repos.dagger.DaggerReposComponent;
import com.twistedeqations.rxmvp.sample.activities.repos.dagger.ReposModule;
import com.twistedeqations.rxmvp.sample.activities.repos.mvp.ReposPresenter;
import com.twistedeqations.rxmvp.sample.activities.repos.mvp.view.ReposView;
import com.twistedeqations.rxmvp.sample.app.GithubApplication;
import com.twistedeqations.rxmvp.sample.app.network.model.GitHubRepo;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class ReposActivity extends AppCompatActivity {

  public static final String INTENT_DATA_REPOS = "repoList";

  public static void start(Context context, List<GitHubRepo> repoList) {
    Intent intent = new Intent(context, ReposActivity.class);
    intent.putExtra(INTENT_DATA_REPOS, new ArrayList<>(repoList));
    context.startActivity(intent);
  }

  @Inject
  ReposView view;

  @Inject
  ReposPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    DaggerReposComponent.builder()
        .appComponent(GithubApplication.get(this).component())
        .reposModule(new ReposModule(this))
        .build().inject(this);

    setContentView(view);
    presenter.onCreate();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.onDestroy();
  }
}
