package com.mindorks.bootcamp.learndagger.di.components;

import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

// Component annotation requires a list of modules to search/scan to provide
// the instances/dependencies. Component acts as bridge between the modules and the classes
// which needs the dependency. Dagger will create a class by implementing this interface and
// prepending "Dagger" to the interface name. For eg.  the name of class will be
// DaggerApplicationComponent. Role of a component is to list all the classes(eg. MyApplication)
// which needs to be scanned by Dagger, using the inject() method. Singleton annotation tells
// Dagger to provide only one instance(singleton) of the dependency.
// All components must be marked with a scope (Singleton, ActivityScope etc)
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    // The parameter of inject will be the class, which needs the instance/dependency
    // Here for eg. it is MyApplication.
    void inject(MyApplication application);

    // This method is used to provide nw instance to activity class
    NetworkService getNetworkService();

    // This method is used to provide db instance to activity class
    DatabaseService getDatabaseService();
}
