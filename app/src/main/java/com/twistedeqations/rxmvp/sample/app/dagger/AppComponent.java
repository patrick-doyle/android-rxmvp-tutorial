package com.twistedeqations.rxmvp.sample.app.dagger;

import android.content.Context;
import com.squareup.picasso.Picasso;
import com.twistedeqations.rxmvp.sample.app.dagger.module.AppModule;
import com.twistedeqations.rxmvp.sample.app.dagger.module.GsonModule;
import com.twistedeqations.rxmvp.sample.app.dagger.module.NetworkModule;
import com.twistedeqations.rxmvp.sample.app.network.GithubNetwork;
import dagger.Component;
import okhttp3.OkHttpClient;

@AppScope
@Component(modules = { AppModule.class , NetworkModule.class, GsonModule.class})
public interface AppComponent {

  Context context();

  OkHttpClient okhttpClient();

  GithubNetwork githubNetwork();

  Picasso picasso();

}
