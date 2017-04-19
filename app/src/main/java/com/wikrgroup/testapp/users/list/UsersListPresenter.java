package com.wikrgroup.testapp.users.list;

import com.wikrgroup.testapp.models.dataSources.UsersRepository;

import java.util.TreeSet;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ovitaliy on 19.04.2017.
 */

class UsersListPresenter extends UsersListContract.Presenter {


    private static final int LIMIT = 5;

    private final UsersListContract.View view;
    private final UsersRepository usersRepository;

    private final CompositeSubscription subscriptions = new CompositeSubscription();

    private TreeSet<Integer> pagesInProgress = new TreeSet<>();

    private boolean loaded;

    @Inject
    UsersListPresenter(UsersListContract.View view, UsersRepository usersRepository) {
        this.view = view;
        this.usersRepository = usersRepository;
    }


    @Override
    void load() {
        if (!loaded) {
            load(0);
            load(LIMIT);
            loaded = true;
        }
    }

    private void load(int start) {
        //show progress bar for first page
        if (start == 0)
            view.showProgressBar();

        pagesInProgress.add(start);

        Subscription subscription = usersRepository.getUsers(start, LIMIT)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        users -> {
                            if (view.isActive()) {
                                view.hideProgressBar();
                                view.showUserList(users);
                                pagesInProgress.remove(start);
                            }
                        },
                        error -> {
                            if (view.isActive()) {
                                view.showError(error.getMessage());
                                view.hideProgressBar();
                            }
                        }

                );

        subscriptions.add(subscription);
    }

    @Override
    void resumed() {
        pagesInProgress.forEach(this::load);
    }

    @Override
    void stopped() {
        subscriptions.clear();
    }
}
