package com.wikrgroup.testapp.users.list;

import com.wikrgroup.testapp.BasePresenterTest;
import com.wikrgroup.testapp.models.User;
import com.wikrgroup.testapp.models.dataSources.UsersRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import rx.Observable;

/**
 * Created by ovitaliy on 19.04.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UsersListPresenterTest extends BasePresenterTest {
    private static final String ERROR = "an error";

    @Mock
    UsersListContract.View view;

    @Mock
    UsersRepository usersRepository;

    private UsersListPresenter usersListPresenter;

    @Before
    public void setUp() throws Exception {
        super.setUp();

        Mockito.when(view.isActive()).thenReturn(true);

        usersListPresenter = new UsersListPresenter(view, usersRepository);
    }


    @Test
    public void load() throws Exception {
        Mockito.when(usersRepository.getUsers(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(Observable.just(Arrays.asList(new User(), new User())));

        usersListPresenter.load();

        Mockito.verify(view, Mockito.after(50).times(2)).showUserList(Mockito.anyListOf(User.class));
        Mockito.verify(view, Mockito.after(50)).showProgressBar();
        Mockito.verify(view, Mockito.after(50).atLeastOnce()).hideProgressBar();
    }

    @Test
    public void loadFailed() throws Exception {
        Mockito.when(usersRepository.getUsers(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(Observable.error(new Exception(ERROR)));

        usersListPresenter.load();

        Mockito.verify(view, Mockito.after(50).times(2)).showError(ERROR);
        Mockito.verify(view, Mockito.after(50)).showProgressBar();
        Mockito.verify(view, Mockito.after(50).atLeastOnce()).hideProgressBar();
    }
}