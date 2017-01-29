package com.twistedeqations.rxmvp.sample.app.network.model;

import android.os.Parcelable;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class GithubOwner implements Parcelable {

  public static TypeAdapter<GithubOwner> typeAdapter(Gson gson) {
    return new AutoValue_GithubOwner.GsonTypeAdapter(gson);
  }

  @SerializedName("login")
  public abstract String login();

  @SerializedName("id")
  public abstract String id();

  @SerializedName("avatar_url")
  public abstract String avatarUrl();

  @SerializedName("url")
  public abstract String url();

  @SerializedName("html_url")
  public abstract String htmlUrl();

  @SerializedName("repos_url")
  public abstract String reposUrl();
}
