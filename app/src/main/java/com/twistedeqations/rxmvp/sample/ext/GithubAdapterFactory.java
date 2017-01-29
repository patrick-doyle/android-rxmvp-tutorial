package com.twistedeqations.rxmvp.sample.ext;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

@GsonTypeAdapterFactory
public abstract class GithubAdapterFactory implements TypeAdapterFactory {

  // Static factory method to access the package
  // private generated implementation
  public static TypeAdapterFactory create() {
    return new AutoValueGson_GithubAdapterFactory();
  }

}