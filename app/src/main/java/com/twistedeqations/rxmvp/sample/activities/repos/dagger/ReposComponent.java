package com.twistedeqations.rxmvp.sample.activities.repos.dagger;

import com.twistedeqations.rxmvp.sample.activities.repos.ReposActivity;
import com.twistedeqations.rxmvp.sample.app.dagger.AppComponent;
import dagger.Component;

@ReposScope
@Component(modules = { ReopsModule.class }, dependencies = AppComponent.class)
public interface ReposComponent {

  void inject(ReposActivity mainActivity);

}
