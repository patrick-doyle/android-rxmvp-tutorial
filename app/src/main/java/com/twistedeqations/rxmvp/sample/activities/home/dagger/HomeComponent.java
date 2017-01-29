package com.twistedeqations.rxmvp.sample.activities.home.dagger;

import android.content.Context;
import com.twistedeqations.rxmvp.sample.app.dagger.AppComponent;
import com.twistedeqations.rxmvp.sample.app.dagger.module.AppModule;
import dagger.Component;

@HomeScope
@Component(modules = { AppModule.class }, dependencies = AppComponent.class)
public interface HomeComponent {

  Context context();

}
