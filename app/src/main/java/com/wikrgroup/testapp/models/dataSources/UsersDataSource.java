package com.wikrgroup.testapp.models.dataSources;

import com.wikrgroup.testapp.models.User;

import java.util.List;

import rx.Observable;

/**
 * Created by ovitaliy on 19.04.2017.
 */

public interface UsersDataSource {

    Observable<List<User>> getUsers(int start, int limit);

    Observable<User> getUserById(Long id);

}
