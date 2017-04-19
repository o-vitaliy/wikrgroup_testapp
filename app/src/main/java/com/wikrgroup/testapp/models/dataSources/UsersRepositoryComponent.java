package com.wikrgroup.testapp.models.dataSources;

import com.wikrgroup.testapp.di.modules.AppModule;
import com.wikrgroup.testapp.di.modules.RestApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ovitaliy on 19.04.2017.
 */
@Singleton
@Component(
        modules = {
                UsersRepositoryModule.class,
                AppModule.class,
                RestApiModule.class
        })
public interface UsersRepositoryComponent {

    UsersRepository userRepository();

}
