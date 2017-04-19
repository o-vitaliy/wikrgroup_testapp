package com.wikrgroup.testapp.models.dataSources;

import com.wikrgroup.testapp.api.UsersRestApi;
import com.wikrgroup.testapp.models.User;

import java.util.List;

import rx.Observable;

/**
 * Created by ovitaliy on 19.04.2017.
 */

public class UsersRemoteDataSource implements UsersDataSource {

    private final UsersRestApi usersRestApi;

    public UsersRemoteDataSource(UsersRestApi usersRestApi) {
        this.usersRestApi = usersRestApi;
    }

    @Override
    public Observable<List<User>> getUsers(int start, int limit) {
        Observable<User> usersObservable = usersRestApi.getUsers()
                .flatMap(Observable::from);

        if (start > 0)
            usersObservable = usersObservable.skip(start);

        usersObservable = usersObservable.take(5);

        return usersObservable.toList();
    }

    @Override
    public Observable<User> getUserById(Long id) {
        throw new RuntimeException("Not required for the remote data source");
    }

}
