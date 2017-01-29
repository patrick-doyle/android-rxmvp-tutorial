package com.twistedeqations.rxmvp.sample.app.dagger.module;

import com.fatboyindustrial.gsonjodatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twistedeqations.rxmvp.sample.app.dagger.AppScope;
import com.twistedeqations.rxmvp.sample.ext.GithubAdapterFactory;
import dagger.Module;
import dagger.Provides;

@Module
public class GsonModule {

  @AppScope
  @Provides
  public Gson context() {
    return Converters.registerAll(new GsonBuilder())
        .registerTypeAdapterFactory(GithubAdapterFactory.create())
        .create();
  }
}
