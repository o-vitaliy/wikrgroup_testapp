package com.wikrgroup.testapp.api;

import com.wikrgroup.testapp.models.User;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ovitaliy on 19.04.2017.
 */

public interface UsersRestApi {

    @GET("users")
    Observable<List<User>> getUsers();
}
