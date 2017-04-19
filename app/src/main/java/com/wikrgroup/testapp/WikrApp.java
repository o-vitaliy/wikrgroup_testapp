package com.wikrgroup.testapp;

import android.app.Application;

import com.wikrgroup.testapp.di.components.AppComponent;
import com.wikrgroup.testapp.di.components.DaggerAppComponent;
import com.wikrgroup.testapp.di.modules.AppModule;
import com.wikrgroup.testapp.models.dataSources.DaggerUsersRepositoryComponent;
import com.wikrgroup.testapp.models.dataSources.UsersRepositoryComponent;

/**
 * Created by ovitaliy on 19.04.2017.
 */

public class WikrApp extends Application {


    private UsersRepositoryComponent usersRepositoryComponent;

    public WikrApp() {
        super();

        usersRepositoryComponent = DaggerUsersRepositoryComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public UsersRepositoryComponent usersRepositoryComponent() {
        return usersRepositoryComponent;
    }

}
