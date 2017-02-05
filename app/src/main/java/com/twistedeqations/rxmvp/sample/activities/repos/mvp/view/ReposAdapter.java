package com.twistedeqations.rxmvp.sample.activities.repos.mvp.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.twistedeqations.rxmvp.sample.app.network.model.GitHubRepo;
import java.util.ArrayList;
import java.util.List;

public class ReposAdapter extends BaseAdapter {

  private final List<GitHubRepo> repoList = new ArrayList<>(0);

  @Override
  public int getCount() {
    return repoList.size();
  }

  @Override
  public GitHubRepo getItem(int position) {
    return repoList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return repoList.get(position).id().hashCode();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ReposListItem listItem;

    if (convertView == null) {
      listItem = new ReposListItem(parent.getContext());
    } else {
      listItem = ReposListItem.class.cast(convertView);
    }
    listItem.setRepo(repoList.get(position));
    return listItem;
  }

  public void swapData(List<GitHubRepo> repoList) {
    this.repoList.clear();
    if (repoList != null && !repoList.isEmpty()) {
      this.repoList.addAll(repoList);
    }
    notifyDataSetChanged();
  }
}
