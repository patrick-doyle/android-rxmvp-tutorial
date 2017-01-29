package com.twistedeqations.rxmvp.sample.app.dagger;

import android.content.Context;
import com.twistedeqations.rxmvp.sample.app.dagger.module.AppModule;
import dagger.Component;

@AppScope
@Component(modules = { AppModule.class })
public interface AppComponent {

  Context context();

}
