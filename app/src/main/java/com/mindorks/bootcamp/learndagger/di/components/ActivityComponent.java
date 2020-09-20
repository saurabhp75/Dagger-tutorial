package com.mindorks.bootcamp.learndagger.di.components;

import com.mindorks.bootcamp.learndagger.di.modules.ActivityModule;
import com.mindorks.bootcamp.learndagger.di.scope.ActivityScope;
import com.mindorks.bootcamp.learndagger.ui.MainActivity;

import dagger.Component;

// dependencies are needed because activity needs db and nw instance from the application class
// This way we can share instances/dependencies across the components.
//@Component(modules = {ActivityModule.class})
// ActivityScope isd the label which all the instances created by ActivityComponent are
// marked with.
// All components must be marked with a scope (Singleton, ActivityScope etc)
@ActivityScope
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity activity);
}
