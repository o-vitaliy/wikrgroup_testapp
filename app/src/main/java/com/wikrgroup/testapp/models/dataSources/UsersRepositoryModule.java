package com.wikrgroup.testapp.models.dataSources;

import com.wikrgroup.testapp.api.UsersRestApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by ovitaliy on 19.04.2017.
 */

@Module
public class UsersRepositoryModule {

    @Singleton
    @Provides
    UsersDataSource provideUsersRemoteDataSource(Retrofit retrofit) {
        return new UsersRemoteDataSource(retrofit.create(UsersRestApi.class));
    }
}
