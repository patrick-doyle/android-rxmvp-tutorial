package com.twistedeqations.rxmvp.sample.app.network.model;

import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.parcel.ParcelAdapter;
import com.twistedeqations.rxmvp.sample.ext.DateTimeAdapter;
import org.joda.time.DateTime;

@AutoValue
public abstract class GitHubRepo implements Parcelable {

  public static TypeAdapter<GitHubRepo> typeAdapter(Gson gson) {
    return new AutoValue_GitHubRepo.GsonTypeAdapter(gson);
  }

  public abstract String id();

  public abstract String name();

  @SerializedName("full_name")
  public abstract String fullName();

  @SerializedName("owner")
  public abstract GithubOwner owner();

  @SerializedName("private")
  public abstract boolean isPrivate();

  @SerializedName("html_url")
  public abstract String htmlUrl();

  @Nullable
  @SerializedName("description")
  public abstract String description();

  @SerializedName("fork")
  public abstract boolean fork();

  @SerializedName("url")
  public abstract String url();

  @SerializedName("created_at")
  @ParcelAdapter(DateTimeAdapter.class)
  public abstract DateTime created();

  @SerializedName("updated_at")
  @ParcelAdapter(DateTimeAdapter.class)
  public abstract DateTime updated();

  @SerializedName("pushed_at")
  @ParcelAdapter(DateTimeAdapter.class)
  public abstract DateTime pushedAt();

  @SerializedName("git_url")
  public abstract String gitUrl();

  @SerializedName("ssh_url")
  public abstract String sshUrl();

  @SerializedName("size")
  public abstract int size();

  @SerializedName("watchers_count")
  public abstract int watchersCount();

  @SerializedName("forks_count")
  public abstract int forksCount();

  @SerializedName("language")
  public abstract String language();
}
