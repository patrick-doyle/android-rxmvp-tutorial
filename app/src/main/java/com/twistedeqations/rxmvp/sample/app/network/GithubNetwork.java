package com.twistedeqations.rxmvp.sample.app.network;

import com.twistedeqations.rxmvp.sample.app.network.model.GitHubRepo;
import com.twistedeqations.rxmvp.sample.app.network.model.GithubUser;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GithubNetwork {

  @GET("users/{user}/repos")
  Observable<List<GitHubRepo>> getReposForUser(@Path("user") String user);

  @GET("repos/{user}/{repo}")
  Observable<GitHubRepo> getRepo(@Path("user") String username, @Path("repo") String repo);

  @GET("user/{user}")
  Observable<GithubUser> getUser(@Path("user") String username);

}
