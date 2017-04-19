package com.wikrgroup.testapp.models.dataSources;

import com.wikrgroup.testapp.di.modules.AppModule;
import com.wikrgroup.testapp.di.modules.DataSourceModule;

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
                DataSourceModule.class
        })
public interface UsersRepositoryComponent {

    UsersRepository userRepository();

}
