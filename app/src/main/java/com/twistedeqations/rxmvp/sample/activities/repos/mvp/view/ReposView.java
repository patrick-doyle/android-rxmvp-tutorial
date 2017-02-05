package com.twistedeqations.rxmvp.sample.activities.repos.mvp.view;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jakewharton.rxbinding.view.RxView;
import com.twistedeqations.rxmvp.sample.R;
import com.twistedeqations.rxmvp.sample.app.network.model.GitHubRepo;
import java.util.List;
import rx.Observable;

@SuppressLint("ViewConstructor")
public class ReposView extends FrameLayout {

  @BindView(R.id.repos_list)
  ListView listView;

  @BindView(R.id.repos_toolbar)
  Toolbar toolbar;

  private final ReposAdapter reposAdapter = new ReposAdapter();

  public ReposView(Activity activity) {
    super(activity);

    inflate(getContext(), R.layout.activity_repos, this);
    ButterKnife.bind(this);

    listView.setAdapter(reposAdapter);
  }

  public void setMessage(String message) {
    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
  }

  public void setData(List<GitHubRepo> gitHubRepoList) {
    reposAdapter.swapData(gitHubRepoList);
  }
}
