package com.wikrgroup.testapp.users.list;

import com.wikrgroup.testapp.BasePresenter;
import com.wikrgroup.testapp.BaseView;
import com.wikrgroup.testapp.models.User;

import java.util.List;

/**
 * Created by ovitaliy on 19.04.2017.
 */

interface UsersListContract {

    interface View extends BaseView<Presenter> {

        void showProgressBar();

        void hideProgressBar();

        void showUserList(List<User> users);

        void showError(String error);

        boolean isActive();
    }

    abstract class Presenter extends BasePresenter {

        abstract void load();

        abstract void resumed();

        abstract void stopped();

    }
}
