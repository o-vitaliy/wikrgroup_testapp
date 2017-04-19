package com.wikrgroup.testapp.di.components;

import android.content.Context;

import com.wikrgroup.testapp.di.modules.AppModule;
import com.wikrgroup.testapp.di.modules.RestApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Uran on 18.07.2016.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        RestApiModule.class
})
public interface AppComponent extends RestApiComponent {

    Context context();

}