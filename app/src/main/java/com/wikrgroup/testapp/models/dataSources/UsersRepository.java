package com.wikrgroup.testapp.models.dataSources;

import android.support.annotation.NonNull;

import com.wikrgroup.testapp.models.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by ovitaliy on 19.04.2017.
 */
@Singleton
public class UsersRepository implements UsersDataSource {

    private final UsersDataSource remoteDataSource;

    private List<User> users = new ArrayList<>();

    @Inject
    UsersRepository(@NonNull UsersDataSource remoteDataSource) {
        this.remoteDataSource = checkNotNull(remoteDataSource);
    }

    @Override
    public Observable<List<User>> getUsers(int start, int limit) {
        return remoteDataSource.getUsers(start, limit)
                .doOnNext(users -> this.users = users);
    }

}
