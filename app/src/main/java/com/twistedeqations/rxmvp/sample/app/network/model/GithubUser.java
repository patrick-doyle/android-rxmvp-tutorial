package com.twistedeqations.rxmvp.sample.app.network.model;

import android.os.Parcelable;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.parcel.ParcelAdapter;
import com.twistedeqations.rxmvp.sample.ext.DateTimeAdapter;
import org.joda.time.DateTime;

@AutoValue
public abstract class GithubUser implements Parcelable {

  public static TypeAdapter<GithubUser> typeAdapter(Gson gson) {
    return new AutoValue_GithubUser.GsonTypeAdapter(gson);
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

  @SerializedName("name")
  public abstract String name();

  @SerializedName("bio")
  public abstract String bio();

  @SerializedName("followers")
  public abstract int followers();

  @SerializedName("created_at")
  @ParcelAdapter(DateTimeAdapter.class)
  public abstract DateTime created();

  @SerializedName("updated_at")
  @ParcelAdapter(DateTimeAdapter.class)
  public abstract DateTime updated();
}
