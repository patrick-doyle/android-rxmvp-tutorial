package com.twistedeqations.rxmvp.sample.activities.home.mvp;

import com.twistedeqations.rxmvp.sample.app.network.model.GitHubRepo;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import rx.Observable;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.schedulers.Schedulers;
import test.RxSchedulersOverrideRule;

import static org.junit.Assert.*;

public class HomePresenterTest {

  private HomePresenter homePresenter;
  private HomeView homeView;
  private HomeModel homeModel;

  private List<GitHubRepo> mockRepos = new ArrayList<>(0);

  @Rule
  public RxSchedulersOverrideRule schedulersOverrideRule = new RxSchedulersOverrideRule();

  @Before
  public void setUp() throws Exception {
    homeModel = Mockito.mock(HomeModel.class);
    homeView = Mockito.mock(HomeView.class);

    homePresenter = new HomePresenter(homeView, homeModel);

    Mockito.when(homeView.getUsernameEdit()).thenReturn("twistedequations");
    Mockito.when(homeView.observeButton()).thenReturn(Observable.never());

    Mockito.when(homeModel.getReposFromSaveState()).thenReturn(Observable.empty());
    Mockito.when(homeModel.getUserReops(Mockito.anyString()))
        .thenReturn(Observable.just(mockRepos));
  }

  @Test
  public void onGetRepoSavedStateNoData() {
    Mockito.when(homeModel.getReposFromSaveState()).thenReturn(Observable.empty());

    homePresenter.onCreate();

    Mockito.verify(homeView, Mockito.never()).setMessage(Mockito.anyString());
  }

  @Test
  public void onGetRepoSavedStateHasData() {
    Mockito.when(homeModel.getReposFromSaveState()).thenReturn(Observable.just(mockRepos));

    homePresenter.onCreate();

    Mockito.verify(homeView, Mockito.times(1)).setMessage("Look up button clicked - " + mockRepos);
  }

  @Test
  public void onLookupButtonClicks() {
    Mockito.when(homeView.observeButton()).thenReturn(Observable.just(null));
    Mockito.when(homeModel.getUserReops(Mockito.eq("twistedequations")))
        .thenReturn(Observable.just(mockRepos));

    homePresenter.onCreate();

    Mockito.verify(homeView, Mockito.times(1)).showLoading(Mockito.eq(true));
    Mockito.verify(homeView, Mockito.times(2)).showLoading(Mockito.eq(false));
    Mockito.verify(homeModel, Mockito.times(1)).saveRepoListState(Mockito.eq(mockRepos));
    Mockito.verify(homeModel, Mockito.times(1)).startRepoActivity(Mockito.eq(mockRepos));
  }


}