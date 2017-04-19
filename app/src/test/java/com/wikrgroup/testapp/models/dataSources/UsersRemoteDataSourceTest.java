package com.wikrgroup.testapp.models.dataSources;

import com.google.gson.Gson;
import com.wikrgroup.testapp.api.UsersRestApi;
import com.wikrgroup.testapp.models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by ovitaliy on 19.04.2017.
 */
public class UsersRemoteDataSourceTest {

    private UsersRemoteDataSource usersRemoteDataSource;

    @Before
    public void setUp() throws Exception {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(interceptor);

        UsersRestApi usersRestApi = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
               .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build())
                .build().create(UsersRestApi.class);


        usersRemoteDataSource = new UsersRemoteDataSource(usersRestApi);

    }

    @Test
    public void getUsers() throws Exception {
        //load first five users
        List<User> users = usersRemoteDataSource.getUsers(0, 5).toBlocking().single();

        assertNotNull(users);
        assertEquals(5, users.size());

        //load next five users
        users = usersRemoteDataSource.getUsers(5, 5).toBlocking().single();
        assertNotNull(users);
        assertEquals(5, users.size());
    }

}